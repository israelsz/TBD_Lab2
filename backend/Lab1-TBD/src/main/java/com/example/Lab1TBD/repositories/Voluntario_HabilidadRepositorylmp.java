package com.example.Lab1TBD.repositories;

import java.util.List;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import com.example.Lab1TBD.models.Voluntario_Habilidad;
@Repository
public class Voluntario_HabilidadRepositorylmp implements Voluntario_HabilidadRepository  {

	@Autowired
    private Sql2o sql2o;

	@Override
	public int getIdVoluntario_HabilidadMayor(){
		try(Connection conn = sql2o.open()){
			Voluntario_Habilidad auxiliar = conn.createQuery("SELECT * FROM vol_habilidad ORDER BY id DESC").executeAndFetchFirst(Voluntario_Habilidad.class);
			return auxiliar.getId();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 1;
		}
	}

	 @Override
	    public String createVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad) {
	        String sql =
	                "INSERT INTO vol_habilidad (id, id_voluntario, id_habilidad) " +
	                        "VALUES (:id, :id_voluntario, :id_habilidad)";
			int nuevoId = getIdVoluntario_HabilidadMayor() + 1;

	        try(Connection conn = sql2o.open()){
				conn.createQuery(sql)
						.addParameter("id", nuevoId)
	                    .addParameter("id_voluntario", voluntario_habilidad.getId_voluntario())
	                    .addParameter("id_habilidad", voluntario_habilidad.getId_habilidad())
	                    .executeUpdate();
				return "Se ha creado la tabla intermedia vol-habilidad con id: " + nuevoId;
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 
	 @Override
	    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad() {
	        final String sql =
	                "SELECT * FROM vol_habilidad";
	        try(Connection conn = sql2o.open()){
	            return conn.createQuery(sql)
	                    .executeAndFetch(Voluntario_Habilidad.class);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }

	@Override
	public Voluntario_Habilidad getVoluntario_HabilidadById(Integer id){
		String sql = "SELECT * FROM vol_habilidad WHERE id = :eid";
		try(Connection conn = sql2o.open()){
			return conn.createQuery(sql)
					.addParameter("eid", id)
					.executeAndFetchFirst(Voluntario_Habilidad.class);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}

	 @Override
	    public String updateVoluntario_Habilidad(int id, Voluntario_Habilidad voluntario_habilidad) {
	        String updateSql = "UPDATE vol_habilidad " +
	                            "SET id_voluntario = :voluntario_habilidadId_voluntario, " +
	                            "id_habilidad = :voluntario_habilidadId_habilidad, updated_at = :voluntario_habilidadFechaActualizacion " +
	                            "WHERE id = :voluntario_habilidadID";
		 //Se consigue el timestamp actual para la actualización
		 Date date = new Date();
		 Timestamp timestamp = new Timestamp(date.getTime());

	        try (Connection con = sql2o.open()) {
				Voluntario_Habilidad antiguo = con.createQuery("SELECT * FROM vol_habilidad where id = :idE")
	                    .addParameter("idE", id)
	                    .executeAndFetchFirst(Voluntario_Habilidad.class);

				//Se verifica si existe la tupla que se desea actualizar
				if(antiguo == null){
					return ("No existe la vol_habilidad con id: " + id);
				}

	            Query consulta = con.createQuery(updateSql);
	            consulta.addParameter("voluntario_habilidadID", id);

	            if(voluntario_habilidad.getId_voluntario() != null){
	                consulta.addParameter("voluntario_habilidadId_voluntario", voluntario_habilidad.getId_voluntario());
	            } else {
	                consulta.addParameter("voluntario_habilidadId_voluntario", antiguo.getId_voluntario());
	            }

				if(voluntario_habilidad.getId_habilidad() != null){
					consulta.addParameter("voluntario_habilidadId_habilidad", voluntario_habilidad.getId_habilidad());
				} else {
					consulta.addParameter("voluntario_habilidadId_habilidad", antiguo.getId_habilidad());
				}

				consulta.addParameter("voluntario_habilidadFechaActualizacion",timestamp);

	            consulta.executeUpdate();

	            return ("La tupla de vol_habilidad de id: " + id + " se actualizo correctamente");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 @Override
	    public String deleteVoluntario_Habilidad(int id) {
	        String deleteSql = "DELETE FROM vol_habilidad e WHERE e.id = "+id;
		 try(Connection conn = sql2o.open()){
			 Voluntario_Habilidad tupla = conn.createQuery("SELECT * FROM vol_habilidad where id = :idE")
					 .addParameter("idE", id)
					 .executeAndFetchFirst(Voluntario_Habilidad.class);
			 if(tupla == null){
				 return ("No existe la vol_habilidad con id: " + id);
			 }
			 conn.createQuery(deleteSql)
					 .executeUpdate();
			 return "Se ha eliminado la tupla de vol_habilidad "+id;
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
			 return null;
		 }
	 }
	 
	 
	 
	 
}
