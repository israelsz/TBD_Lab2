package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Habilidad;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

	 @Autowired
	    MongoDatabase database;

	    @Override
	    public int countHabilidads() {
	        MongoCollection<Document> collection = database.getCollection("habilidad");
	        long count = collection.countDocuments();
	        return (int) count;
	    }

	    @Override
	    public List<Habilidad> getHabilidads() {
	        MongoCollection<Habilidad> collection = database.getCollection("habilidad", Habilidad.class);
	        List <Habilidad> habilidads = collection.find().into(new ArrayList<>());
	        
	        return habilidads;
	    }

	    @Override
	    public Habilidad createHabilidad(Habilidad habilidad) {
	        MongoCollection<Habilidad> collection = database.getCollection("habilidad", Habilidad.class);
	        collection.insertOne(habilidad);
	        return habilidad;
	    }
	    
}

