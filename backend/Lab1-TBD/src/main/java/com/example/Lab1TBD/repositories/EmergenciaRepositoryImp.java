package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Emergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public int getIdEmergenciaMayor(){
        try(Connection conn = sql2o.open()){
            Emergencia auxiliar = conn.createQuery("SELECT * FROM emergencia ORDER BY id DESC").executeAndFetchFirst(Emergencia.class);
            return auxiliar.getId();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }


    @Override
    public String createEmergencia(Emergencia emergencia) {
        String sql =
                "INSERT INTO emergencia (id, nombre, ubicacion, fecha, descripcion,coordenadas) " +
                        "VALUES (:id, :nombre, :ubicacion, :fecha, :descripcion,ST_GeomFromText(:coordenadas,4326))";

        int nuevoId = getIdEmergenciaMayor() + 1;

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", nuevoId)
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("ubicacion", emergencia.getUbicacion())
                    .addParameter("fecha", emergencia.getFecha())
                    .addParameter("descripcion", emergencia.getDescripcion())
                    .addParameter("coordenadas","POINT("+emergencia.getCoordenadas()+")")
                    .executeUpdate();

            return "Se ha creado la emergencia con id: " + nuevoId;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Emergencia> getAllEmergencias() {
        final String sql =
                "SELECT * FROM emergencia";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergenciaById(Integer id){
        String sql = "SELECT * FROM emergencia WHERE id = :eid";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetchFirst(Emergencia.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEmergencia(int id, Emergencia emergencia) {
        String updateSql = "UPDATE emergencia " +
                            "SET nombre = :emergenciaNombre, ubicacion = :emergenciaUbicacion, " +
                            "fecha = :emergenciaFecha, descripcion = :emergenciaDescripcion, updated_at = :emergenciaFechaActualizacion, " +
                            "coordenadas = ST_GeomFromText(:emergenciaCoordenadas,4326)"+
                            "WHERE id = :emergenciaID";

        //Se colnsigue el timestamp actual para la actualización
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        //Se consigue el valor actual de la emergencia, que sera actualizado

        try (Connection con = sql2o.open()) {
            Emergencia antiguo = con.createQuery("SELECT * FROM emergencia where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Emergencia.class);

           //Se verifica si existe la tupla que se desea actualizar
            if(antiguo == null){
                return ("No existe la emergencia con id: " + id);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("emergenciaID", id);

            if(emergencia.getNombre() != null){
                consulta.addParameter("emergenciaNombre", emergencia.getNombre());
            } else {
                consulta.addParameter("emergenciaNombre", antiguo.getNombre());
            }

            if(emergencia.getUbicacion() != null){
                consulta.addParameter("emergenciaUbicacion", emergencia.getUbicacion());
            } else {
                consulta.addParameter("emergenciaUbicacion",antiguo.getUbicacion());
            }

            if(emergencia.getFecha() != null){
                consulta.addParameter("emergenciaFecha", emergencia.getFecha());
            } else {
                consulta.addParameter("emergenciaFecha", antiguo.getFecha());
            }

            if(emergencia.getDescripcion() != null){
                consulta.addParameter("emergenciaDescripcion", emergencia.getDescripcion());
            } else {
                consulta.addParameter("emergenciaDescripcion", antiguo.getDescripcion());
            }

            if (emergencia.getCoordenadas()!=null){
                consulta.addParameter("emergenciaCoordenadas","POINT("+emergencia.getCoordenadas()+")");
            }else {
                consulta.addParameter("emergenciaCoordenadas","POINT("+antiguo.getCoordenadas()+")");
            }
            //Se cambia la fecha de actualizacion
            consulta.addParameter("emergenciaFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("La emergencia de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEmergencia(int id) {
        String deleteSql = "DELETE FROM emergencia e WHERE e.id = "+id;

        try(Connection conn = sql2o.open()){

            Emergencia tupla = conn.createQuery("SELECT * FROM emergencia where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Emergencia.class);
            if(tupla == null){
                return ("No existe la emergencia con id: " + id);
            }

            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado la emergencia "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
