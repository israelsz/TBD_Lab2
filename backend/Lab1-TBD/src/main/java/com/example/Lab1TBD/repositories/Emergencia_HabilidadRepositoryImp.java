package com.example.Lab1TBD.repositories;
import com.example.Lab1TBD.models.Emergencia_Habilidad;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;


@Repository
public class Emergencia_HabilidadRepositoryImp  implements Emergencia_HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    //Encontrar el mayor id dentro de la tabla Emergencia_Habilidad
    @Override
    public int getIdEmergencia_HabilidadMayor(){
        try(Connection conn = sql2o.open()){
            Emergencia_Habilidad auxiliar = conn.createQuery("SELECT * FROM eme_habilidad ORDER BY id DESC").executeAndFetchFirst(Emergencia_Habilidad.class);

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
    public String createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad) {
        String sql =
                "INSERT INTO eme_habilidad (id, id_emergencia, id_habilidad) " +
                        "VALUES (:id, :id_emergencia, :id_habilidad)";
        int nuevoId = getIdEmergencia_HabilidadMayor() + 1;

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", nuevoId)
                    .addParameter("id_emergencia", emergencia_habilidad.getId_emergencia())
                    .addParameter("id_habilidad", emergencia_habilidad.getId_habilidad())
                    .executeUpdate();
            return "Se ha creado la tabla intermedia eme-habilidad con id: " + nuevoId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Read all
    @Override
    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad() {
        final String sql =
                "SELECT * FROM eme_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Emergencia_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Read id
    @Override
    public Emergencia_Habilidad getEmergencia_HabilidadById(Integer id){
        String sql = "SELECT * FROM eme_habilidad WHERE id = :eid";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetchFirst(Emergencia_Habilidad.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Update
    @Override
    public String updateEmergencia_Habilidad(int id, Emergencia_Habilidad emergencia_habilidad) {
        String updateSql = "UPDATE eme_habilidad " +
                "SET id_emergencia = :emergencia_habilidadId_emergencia, " +
                "id_habilidad = :emergencia_habilidadId_habilidad, updated_at = :emergencia_habilidadFechaActualizacion " +
                "WHERE id = :emergencia_habilidadID";

        //Se consigue el timestamp actual para la actualización
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        try (Connection con = sql2o.open()) {
            Emergencia_Habilidad antiguo = con.createQuery("SELECT * FROM eme_habilidad where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Emergencia_Habilidad.class);

            //Se verifica si existe la tupla que se desea actualizar
            if(antiguo == null){
                return ("No existe la tupla eme_habilidad con id: " + id);
            }

            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("emergencia_habilidadID", id);

            if(emergencia_habilidad.getId_emergencia() != null){
                consulta.addParameter("emergencia_habilidadId_emergencia", emergencia_habilidad.getId_emergencia());
            } else {
                consulta.addParameter("emergencia_habilidadId_emergencia", antiguo.getId_emergencia());
            }

            if(emergencia_habilidad.getId_habilidad() != null){
                consulta.addParameter("emergencia_habilidadId_habilidad", emergencia_habilidad.getId_habilidad());
            } else {
                consulta.addParameter("emergencia_habilidadId_habilidad", antiguo.getId_habilidad());
            }

            consulta.addParameter("emergencia_habilidadFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("La tupla de eme_habilidad de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEmergencia_Habilidad(int id) {
        String deleteSql = "DELETE FROM eme_habilidad e WHERE e.id = "+id;
        try(Connection conn = sql2o.open()){
            Emergencia_Habilidad tupla = conn.createQuery("SELECT * FROM eme_habilidad where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Emergencia_Habilidad.class);
            if(tupla == null){
                return ("No existe la tupla eme_habilidad con id: " + id);
            }
            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado la tupla de eme_habilidad "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}