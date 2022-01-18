package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.EstadoTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.sql.Timestamp;
import java.util.Date;

import java.util.List;

@Repository
public class EstadoTareaRepositoryImp implements EstadoTareaRepository{

    @Autowired
    private Sql2o sql2o;


    @Override
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea) {
        final String sql =
                "INSERT INTO estado_tarea (id, estado) " +
                        "VALUES (:id, :estado)";


        try(Connection conn = sql2o.open()){
            int idNuevo = getIdMayor() + 1;
            conn.createQuery(sql, true)
                    .addParameter("id", idNuevo)
                    .addParameter("estado", estadoTarea.getEstado())
                    .executeUpdate();
            estadoTarea.setId(idNuevo);
            return estadoTarea;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EstadoTarea> getAllEstadoTareas() {
        final String sql =
                "SELECT * FROM estado_tarea";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(EstadoTarea.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEstadoTarea(int id, EstadoTarea estadoTarea) {
        String updateSql = "UPDATE estado_tarea " +
                "SET estado = :estadoTareaEstado, updated_at = :estadoTareaFecha " +
                "WHERE id = :estadoTareaID";

        //Se consigue el valor actual de la tarea, que sera actualizado
        Date fecha = new Date();
        Timestamp timestamp = new Timestamp(fecha.getTime());
        try (Connection con = sql2o.open()) {
            EstadoTarea antiguo = con.createQuery("SELECT * FROM estado_tarea where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(EstadoTarea.class);
            //No encontro tupla
            if(antiguo == null){
                return "No se encontro el id";
            }
            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("estadoTareaID", id);

            if(estadoTarea.getEstado() != null){
                consulta.addParameter("estadoTareaEstado", estadoTarea.getEstado());
            } else {
                consulta.addParameter("estadoTareaEstado", antiguo.getEstado());
            }
            consulta.addParameter("estadoTareaFecha", timestamp);

            consulta.executeUpdate();

            return ("El estado_tarea de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEstadoTarea(int id) {
        String deleteSql = "DELETE FROM estado_tarea e WHERE e.id = "+id;
        try(Connection conn = sql2o.open()){
            EstadoTarea esta = getEstadoTarea(id);
            if(esta ==  null){
                return "El id:"+id+" no existe";
            }
            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado el estado_tarea "+id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public EstadoTarea getEstadoTarea(int id) {
        final String sql =
                "SELECT * FROM estado_tarea e WHERE e.id = "+id;
        try(Connection conn = sql2o.open()){
            EstadoTarea estadoTarea = (EstadoTarea) conn.createQuery(sql).executeAndFetchFirst(EstadoTarea.class);
            return estadoTarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getIdMayor(){
        try(Connection conn = sql2o.open()){
            int aux = conn.createQuery("SELECT id FROM estado_tarea ORDER BY id DESC")
            .executeAndFetchFirst(EstadoTarea.class).
            getId();
            return aux;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

}

