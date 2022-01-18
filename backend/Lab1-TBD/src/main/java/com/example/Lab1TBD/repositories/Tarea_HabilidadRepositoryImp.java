package com.example.Lab1TBD.repositories;
import com.example.Lab1TBD.models.Tarea_Habilidad;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;


@Repository
public class Tarea_HabilidadRepositoryImp  implements Tarea_HabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    //Encontrar el mayor id dentro de la tabla Tarea_Habilidad
    @Override
    public int getIdTarea_HabilidadMayor(){
        try(Connection conn = sql2o.open()){
            Tarea_Habilidad auxiliar = conn.createQuery("SELECT * FROM tarea_habilidad ORDER BY id DESC").executeAndFetchFirst(Tarea_Habilidad.class);
            
            //En caso de que la tabla no contenga tuplas
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
    public String createTarea_Habilidad(Tarea_Habilidad tarea_habilidad) {
        String sql =
                "INSERT INTO tarea_habilidad (id, id_tarea, id_eme_habilidad) " +
                        "VALUES (:id, :id_tarea, :id_eme_habilidad)";
        int nuevoId = getIdTarea_HabilidadMayor() + 1;

        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", nuevoId)
                    .addParameter("id_tarea", tarea_habilidad.getId_tarea())
                    .addParameter("id_eme_habilidad", tarea_habilidad.getId_eme_habilidad())
                    .executeUpdate();
            return "Se ha creado la tabla intermedia tarea_habilidad con id: " + nuevoId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Read all
    @Override
    public List<Tarea_Habilidad> getAllTarea_Habilidad() {
        final String sql =
                "SELECT * FROM tarea_habilidad";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Tarea_Habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Read id
    @Override
    public Tarea_Habilidad getTarea_HabilidadById(Integer id){
        String sql = "SELECT * FROM tarea_habilidad WHERE id = :eid";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetchFirst(Tarea_Habilidad.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Update
    @Override
    public String updateTarea_Habilidad(int id, Tarea_Habilidad tarea_habilidad) {
        String updateSql = "UPDATE tarea_habilidad " +
                "SET id_tarea = :tarea_habilidadId_tarea, " +
                "id_eme_habilidad = :tarea_habilidadId_eme_habilidad, updated_at = :tarea_habilidadFechaActualizacion " +
                "WHERE id = :tarea_habilidadID";

        //Se consigue el timestamp actual para la actualización
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        try (Connection con = sql2o.open()) {
            Tarea_Habilidad antiguo = con.createQuery("SELECT * FROM tarea_habilidad where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Tarea_Habilidad.class);

            //Se verifica si existe la tupla que se desea actualizar
            if(antiguo == null){
                return ("No existe la tupla tarea_habilidad con id: " + id);
            }

            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("tarea_habilidadID", id);

            if(tarea_habilidad.getId_tarea() != null){
                consulta.addParameter("tarea_habilidadId_tarea", tarea_habilidad.getId_tarea());
            } else {
                consulta.addParameter("tarea_habilidadId_tarea", antiguo.getId_tarea());
            }

            if(tarea_habilidad.getId_eme_habilidad() != null){
                consulta.addParameter("tarea_habilidadId_eme_habilidad", tarea_habilidad.getId_eme_habilidad());
            } else {
                consulta.addParameter("tarea_habilidadId_eme_habilidad", antiguo.getId_eme_habilidad());
            }

            consulta.addParameter("tarea_habilidadFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("La tupla de tarea_habilidad de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteTarea_Habilidad(int id) {
        String deleteSql = "DELETE FROM tarea_habilidad e WHERE e.id = "+id;
        try(Connection conn = sql2o.open()){
            Tarea_Habilidad tupla = conn.createQuery("SELECT * FROM tarea_habilidad where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Tarea_Habilidad.class);
            if(tupla == null){
                return ("No existe la tupla tarea_habilidad con id: " + id);
            }
            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado la tupla de tarea_habilidad "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}