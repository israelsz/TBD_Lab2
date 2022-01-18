package com.example.Lab1TBD.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.Lab1TBD.models.Ranking;
@Repository
public class RankingRepositorylmp implements RankingRepository  {

	@Autowired
    private Sql2o sql2o;

	@Override
	public int getIdRankingMayor(){
		try(Connection conn = sql2o.open()){
			Ranking auxiliar = conn.createQuery("SELECT * FROM ranking ORDER BY id DESC").executeAndFetchFirst(Ranking.class);
			return auxiliar.getId();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return 1;
		}
	}
	@Override
	    public String createRanking(Ranking ranking) {
	        String sql =
	                "INSERT INTO ranking (id, puntos, id_tarea, id_voluntario) " +
	                        "VALUES (:id, :puntos, :id_tarea, :id_voluntario)";
			int nuevoId = getIdRankingMayor() + 1;


	        try(Connection conn = sql2o.open()){
				conn.createQuery(sql)
						.addParameter("id", nuevoId)
						.addParameter("puntos", ranking.getPuntos())
						.addParameter("id_tarea", ranking.getId_tarea())
	                    .addParameter("id_voluntario", ranking.getId_voluntario())
	                    .executeUpdate();
	            return "Se ha creado el ranking con id: " + nuevoId;
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 
	 @Override
	    public List<Ranking> getAllRanking() {
		 final String sql =
				 "SELECT * FROM ranking";
		 try (Connection conn = sql2o.open()) {
			 return conn.createQuery(sql)
					 .executeAndFetch(Ranking.class);
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
			 return null;
		 }
	 }

	@Override
	public Ranking getRankingById(Integer id){
		String sql = "SELECT * FROM ranking WHERE id = :eid";
		try(Connection conn = sql2o.open()){
			return conn.createQuery(sql)
					.addParameter("eid", id)
					.executeAndFetchFirst(Ranking.class);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	 
	 @Override
	    public String updateRanking(int id, Ranking ranking) {
	        String updateSql = "UPDATE ranking " +
								"SET puntos = :rankingPuntos, " +
								"id_tarea = :rankingId_tarea, " +
	                            "id_voluntario = :rankingId_voluntario, updated_at = :rankingFechaActualizacion " +
	                            "WHERE id = :rankingID";
		 //Se consigue el timestamp actual para la actualización
		 Date date = new Date();
		 Timestamp timestamp = new Timestamp(date.getTime());

	        try (Connection con = sql2o.open()) {
				Ranking antiguo = con.createQuery("SELECT * FROM ranking where id = :idE")
	                    .addParameter("idE", id)
	                    .executeAndFetchFirst(Ranking.class);

				//Se verifica si existe la tupla que se desea actualizar
				if(antiguo == null){
					return ("No existe el ranking con id: " + id);
				}

	            Query consulta = con.createQuery(updateSql);
	            consulta.addParameter("rankingID", id);

				if(ranking.getPuntos() != null){
					consulta.addParameter("rankingPuntos", ranking.getPuntos());
				} else {
					consulta.addParameter("rankingPuntos", antiguo.getPuntos());
				}

				if(ranking.getId_tarea() != null){
					consulta.addParameter("rankingId_tarea", ranking.getId_tarea());
				} else {
					consulta.addParameter("rankingId_tarea", antiguo.getId_tarea());
				}

	            if(ranking.getId_voluntario() != null){
	                consulta.addParameter("rankingId_voluntario", ranking.getId_voluntario());
	            } else {
	                consulta.addParameter("rankingId_voluntario", antiguo.getId_voluntario());
	            }

				consulta.addParameter("rankingFechaActualizacion",timestamp);


	            consulta.executeUpdate();

	            return ("El ranking de id: " + id + " se actualizo correctamente");

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 @Override
	    public String deleteRanking(int id) {
	        String deleteSql = "DELETE FROM ranking e WHERE e.id = "+id;
	        try(Connection conn = sql2o.open()){
				Ranking tupla = conn.createQuery("SELECT * FROM ranking where id = :idE")
						.addParameter("idE", id)
						.executeAndFetchFirst(Ranking.class);
				if(tupla == null){
					return ("No existe el ranking con id: " + id);
				}
	            conn.createQuery(deleteSql)
	                    .executeUpdate();
	            return "Se ha eliminado la tupla de ranking "+id;
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return null;
	        }
	    }
	 
	 
	 
	 
}
