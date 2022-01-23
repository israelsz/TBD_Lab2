package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.VoluntarioParticipacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntariosPorParticipacionRepositoryImp implements VoluntariosPorParticipacionRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VoluntarioParticipacion> getVoluntariesPerParticipation(int id) {

        String sql = "select v.id, v.nombre, v.apellido, count (v.id) as cantidad_tareas" +
                " from voluntario v, voluntario_tarea vt, " +
                " (select e.id as id_emergencia, t.id as id_tarea" +
                " from emergencia e, tarea t, estado_tarea et" +
                " where e.id = :eid and t.id_emergencia = e.id and et.estado = 'Terminada') as te" +
                " where te.id_tarea = vt.id_tarea and v.id = vt.id_voluntario" +
                " group by v.id, v.nombre, v.apellido" +
                " order by cantidad_tareas desc";


        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("eid", id)
                    .executeAndFetch(VoluntarioParticipacion.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

/*

                 String sql = "create view total_participaciones (id_voluntario, cantidad_tareas) as " +
                "select v.id as id_voluntario, count (v.id) as cantidad_tareas " +
                "from voluntario v, voluntario_tarea vt,  " +
                " (select e.id as id_emergencia, t.id as id_tarea " +
                " from emergencia e, tarea t, estado_tarea et " +
                " where e.id = :eid and t.id_emergencia = e.id and et.estado = 'Terminada') as te " +
                "where te.id_tarea = vt.id_tarea and v.id = vt.id_voluntario " +
                " group by v.id; " +
                "\n" +
                " select v.id, v.nombre, v.apellido, tp.cantidad_tareas " +
                " from voluntario v, total_participaciones tp " +
                " where v.id = tp.id_voluntario and " +
                " tp.cantidad_tareas IN (select max(cantidad_tareas) from total_participaciones);";
*/