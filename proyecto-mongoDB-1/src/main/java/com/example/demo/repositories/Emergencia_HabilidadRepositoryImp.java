package com.example.demo.repositories;
import com.example.demo.models.Emergencia_Habilidad;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import java.util.ArrayList;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class Emergencia_HabilidadRepositoryImp  implements Emergencia_HabilidadRepository {

	 @Autowired
	    MongoDatabase database;

	    @Override
	    public int countEmergencia_Habilidads() {
	        MongoCollection<Document> collection = database.getCollection("emergencia_Habilidad");
	        long count = collection.countDocuments();
	        return (int) count;
	    }

	    @Override
	    public List<Emergencia_Habilidad> getEmergencia_Habilidads() {
	        MongoCollection<Emergencia_Habilidad> collection = database.getCollection("emergencia_Habilidad", Emergencia_Habilidad.class);
	        List <Emergencia_Habilidad> emergencia_Habilidads = collection.find().into(new ArrayList<>());
	        
	        return emergencia_Habilidads;
	    }

	    @Override
	    public Emergencia_Habilidad createEmergencia_Habilidad(Emergencia_Habilidad emergencia_Habilidad) {
	        MongoCollection<Emergencia_Habilidad> collection = database.getCollection("emergencia_Habilidad", Emergencia_Habilidad.class);
	        collection.insertOne(emergencia_Habilidad);
	        return emergencia_Habilidad;
	    }
}