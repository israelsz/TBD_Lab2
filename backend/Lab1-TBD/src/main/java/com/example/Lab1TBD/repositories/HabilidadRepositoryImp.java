package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Habilidad;
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
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int getIdHabilidadMayor(){
        try(Connection conn = sql2o.open()){
            Habilidad auxiliar = conn.createQuery("SELECT * FROM habilidad ORDER BY id DESC").executeAndFetchFirst(Habilidad.class);

            //Caso en que la tabla no contenga tuplas
            if(auxiliar == null){
                return 0;
            }
            //Caso general
            else{
                return auxiliar.getId();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }

    @Override
    public String createHabilidad(Habilidad habilidad) {
        String sql =
                "INSERT INTO habilidad (id, nombre, descripcion) " +
                        "VALUES (:id, :nombre, :descripcion)";

        int nuevoId = getIdHabilidadMayor() + 1;

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", nuevoId)
                    .addParameter("nombre", habilidad.getNombre())
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate();

            return "Se ha creado la habilidad con id: " + nuevoId;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> getAllHabilidades() {
        final String sql =
                "SELECT * FROM habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad getHabilidadById(Integer id){
        String sql = "SELECT * FROM habilidad WHERE id = :eid";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetchFirst(Habilidad.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateHabilidad(int id, Habilidad habilidad) {
        String updateSql = "UPDATE habilidad " +
                "SET nombre = :habilidadNombre, descripcion = :habilidadDescripcion, updated_at = :habilidadFechaActualizacion " +
                "WHERE id = :habilidadID";

        //Se obtiene el timestamp actual para actualizar la fecha de modificacion
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        //Se consigue el valor actual de la habilidad que sera actualizada
        try (Connection con = sql2o.open()) {
            Habilidad habilidadOriginal = con.createQuery("SELECT * FROM habilidad where id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Habilidad.class);

            //Se verifica si existe la tupla que se desea actualizar
            if(habilidadOriginal == null){
                return ("No existe la habilidad con id: " + id);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("habilidadID", id);

            //Si se desea cambiar el nombre, se actualiza
            if(habilidad.getNombre() != null){
                consulta.addParameter("habilidadNombre", habilidad.getNombre());
            }
            //Si no se desea cambiar el nombre, se mantiene
            else {
                consulta.addParameter("emergenciaNombre", habilidadOriginal.getNombre());
            }

            //Si se desea cambiar la descripcion, se actualiza
            if(habilidad.getDescripcion() != null){
                consulta.addParameter("habilidadDescripcion", habilidad.getDescripcion());
            }
            //Si no se desea cambiar la descripcion, se mantiene
            else {
                consulta.addParameter("habilidadDescripcion", habilidadOriginal.getDescripcion());
            }

            //Se cambia la fecha de actualizacion
            consulta.addParameter("habilidadFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("La habilidad de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteHabilidad(int id) {
        String deleteSql = "DELETE FROM habilidad e WHERE e.id = " + id;
        try(Connection conn = sql2o.open()){
            Habilidad habilidadAEliminar = conn.createQuery("SELECT * FROM habilidad where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Habilidad.class);
            if(habilidadAEliminar == null){
                return ("No existe la habilidad con id: " + id);
            }
            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado la habilidad con id: "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

