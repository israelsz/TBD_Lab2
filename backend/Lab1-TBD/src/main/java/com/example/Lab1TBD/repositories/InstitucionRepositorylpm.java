package com.example.Lab1TBD.repositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import com.example.Lab1TBD.models.Coordinador;
import com.example.Lab1TBD.models.Emergencia;
import com.example.Lab1TBD.models.Institucion;



@Repository
public class InstitucionRepositorylpm implements InstitucionRepository {
	@Autowired
    private Sql2o sql2o;
	
	@Override
    public int getIdInstitucionMayor(){
        try(Connection conn = sql2o.open()){
            Institucion auxiliar = conn.createQuery("SELECT * FROM institucion ORDER BY id DESC").executeAndFetchFirst(Institucion.class);
            return auxiliar.getId();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return 1;
        }
    }
	
	
	  @Override
	    public String createInstitucion(Institucion institucion) {
	        String sql =
	                "INSERT INTO institucion (id, razon_social) " +
	                        "VALUES (:id, :razon_social)";

	        int nuevoId = getIdInstitucionMayor() + 1;

	        try(Connection conn = sql2o.open()){
	           conn.createQuery(sql)
	                    .addParameter("id", nuevoId)
	                    .addParameter("razon_social", institucion.getRazon_social())
	                    .executeUpdate();

	            return "Se ha creado la institucion con id: " + nuevoId;

	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 @Override
	    public List<Institucion> getAllInstitucion() {
	        final String sql =
	                "SELECT * FROM institucion";
	        try(Connection conn = sql2o.open()){
	            return conn.createQuery(sql)
	                    .executeAndFetch(Institucion.class);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 @Override
	    public Institucion getInstitucionById(Integer id){
	        String sql = "SELECT * FROM institucion WHERE id = :eid";

	        try(Connection conn = sql2o.open()){
	            return conn.createQuery(sql)
	                    .addParameter("eid", id)
	                    .executeAndFetchFirst(Institucion.class);
	        }catch (Exception e){
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	  @Override
	    public String updateInstitucion(int id, Institucion institucion) {
	        String updateSql = "UPDATE institucion " +
	                            "SET razon_social = :institucionRazon_social, updated_at = :institucionFechaActualizacion " +
	                            "WHERE id = :institucionID";
	        Date date = new Date();
	        Timestamp timestamp = new Timestamp(date.getTime());
	        try (Connection con = sql2o.open()) {
	        	Institucion antiguo = con.createQuery("SELECT * FROM institucion where id = :idE")
	                    .addParameter("idE", id)
	                    .executeAndFetchFirst(Institucion.class);

	           //Se verifica si existe la tupla que se desea actualizar
	            if(antiguo == null){
	                return ("No existe la emergencia con id: " + id);
	            }

	            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
	            Query consulta = con.createQuery(updateSql);
	            consulta.addParameter("institucionID", id);

	            if(institucion.getRazon_social() != null){
	                consulta.addParameter("institucionRazon_social", institucion.getRazon_social());
	            } else {
	                consulta.addParameter("institucionRazon_social", antiguo.getRazon_social());
	            }

	            //Se cambia la fecha de actualizacion
	            consulta.addParameter("institucionFechaActualizacion",timestamp);

	            consulta.executeUpdate();

	            return ("La institucion de id: " + id + " se actualizo correctamente");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }

	    @Override
	    public String deleteInstitucion(int id) {
	        String deleteSql = "DELETE FROM institucion e WHERE e.id = "+id;

	        try(Connection conn = sql2o.open()){

	        	Institucion tupla = conn.createQuery("SELECT * FROM institucion where id = :idE")
	                    .addParameter("idE", id)
	                    .executeAndFetchFirst(Institucion.class);
	            if(tupla == null){
	                return ("No existe la institucion con id: " + id);
	            }

	            conn.createQuery(deleteSql)
	                    .executeUpdate();
	            return "Se ha eliminado la institucion "+id;
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
}