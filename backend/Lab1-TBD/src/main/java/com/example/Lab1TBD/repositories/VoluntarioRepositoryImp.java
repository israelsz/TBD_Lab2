package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Voluntario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int getIdVoluntarioMayor(){
        try(Connection conn = sql2o.open()) {
            Voluntario aux=conn.createQuery("SELECT * FROM voluntario ORDER BY id DESC ").executeAndFetchFirst(Voluntario.class);
            return aux.getId();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }

    @Override
    public List<Voluntario> getAllVoluntario(){
        final String sql="SELECT * FROM voluntario";
        try (Connection conn=sql2o.open()){
            return conn.createQuery(sql).executeAndFetch(Voluntario.class);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Voluntario getVoluntarioById(Integer id){
        final String sqlGet="SELECT * FROM voluntario WHERE id=:eid";
        try (Connection conn=sql2o.open()){
            return conn.createQuery(sqlGet).addParameter("eid",id)
                    .executeAndFetchFirst(Voluntario.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createVoluntario(Voluntario voluntario){
        final String sql=
                "INSERT INTO voluntario (id,nombre,apellido,estado_salud,password,correo_electronico)"+
                        "VALUES (:id,:nombre,:apellido,:estado_salud,:password,:correo_electronico)";
        int nuevoId=getIdVoluntarioMayor()+1;

        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id", nuevoId)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("apellido", voluntario.getApellido())
                    .addParameter("estado_salud", voluntario.getEstado_salud())
                    .addParameter("password", voluntario.getPassword())
                    .addParameter("correo_electronico",voluntario.getCorreo_electronico())
                    .executeUpdate();
            return "Se ha creado el voluntario con id: "+nuevoId;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateVoluntario(int id, Voluntario voluntario) {
        String updateSql = "UPDATE voluntario " +
                "SET nombre = :voluntarioNombre,apellido = :voluntarioApellido, estado_salud = :voluntarioEstado_salud,"
                + "password =:voluntarioPassword, correo_electronico =:voluntarioCorreo_electronico, "
                + "updated_at = :voluntarioFechaActualizacion " +
                "WHERE id = :voluntarioID";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try (Connection con = sql2o.open()) {
            Voluntario antiguo = con.createQuery("SELECT * FROM voluntario where id = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Voluntario.class);

            //Se verifica si existe la tupla que se desea actualizar
            if (antiguo == null) {
                return ("No existe el voluntario con id: " + id);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("voluntarioID", id);

            if (voluntario.getNombre() != null) {
                consulta.addParameter("voluntarioNombre", voluntario.getNombre());
            } else {
                consulta.addParameter("voluntarioNombre", antiguo.getNombre());
            }
            if (voluntario.getApellido() != null) {
                consulta.addParameter("voluntarioApellido", voluntario.getApellido());
            } else {
                consulta.addParameter("voluntarioApellido", antiguo.getApellido());
            }
            if (voluntario.getEstado_salud() != null) {
                consulta.addParameter("voluntarioEstado_salud", voluntario.getEstado_salud());
            } else {
                consulta.addParameter("voluntarioEstado_salud", antiguo.getEstado_salud());
            }
            if (voluntario.getPassword() != null) {
                consulta.addParameter("voluntarioPassword", voluntario.getPassword());
            } else {
                consulta.addParameter("voluntarioPassword", antiguo.getPassword());
            }
            if (voluntario.getCorreo_electronico() != null) {
                consulta.addParameter("voluntarioCorreo_electronico", voluntario.getCorreo_electronico());
            } else {
                consulta.addParameter("voluntarioCorreo_electronico", antiguo.getCorreo_electronico());
            }
            //Se cambia la fecha de actualizacion
            consulta.addParameter("voluntarioFechaActualizacion", timestamp);

            consulta.executeUpdate();

            return ("El voluntario de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteVoluntario(int id){
        String deleteSql="DELETE FROM voluntario e WHERE e.id =" +id;
        try (Connection conn = sql2o.open()){
            Voluntario voluntario = conn.createQuery("SELECT * FROM voluntario WHERE id= :idE")
                    .addParameter("idE",id)
                    .executeAndFetchFirst(Voluntario.class);
            if (voluntario==null){
                return ("No existe el voluntario con id: " +id);

            }
            conn.createQuery(deleteSql).executeUpdate();
            return "Se ha eliminado el voluntario: "+id;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
