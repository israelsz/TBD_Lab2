package com.example.demo.repositories;

import java.util.List;
import java.util.ArrayList;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Voluntario_Habilidad;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@Repository
public class Voluntario_HabilidadRepositorylmp implements Voluntario_HabilidadRepository  {

	 @Autowired
	    MongoDatabase database;

	    @Override
	    public int countVoluntario_Habilidads() {
	        MongoCollection<Document> collection = database.getCollection("voluntario_Habilidad");
	        long count = collection.countDocuments();
	        return (int) count;
	    }

	    @Override
	    public List<Voluntario_Habilidad> getVoluntario_Habilidads() {
	        MongoCollection<Voluntario_Habilidad> collection = database.getCollection("voluntario_Habilidad", Voluntario_Habilidad.class);
	        List <Voluntario_Habilidad> voluntario_Habilidads = collection.find().into(new ArrayList<>());
	        
	        return voluntario_Habilidads;
	    }

	    @Override
	    public Voluntario_Habilidad createVoluntario_Habilidad(Voluntario_Habilidad voluntario_Habilidad) {
	        MongoCollection<Voluntario_Habilidad> collection = database.getCollection("voluntario_Habilidad", Voluntario_Habilidad.class);
	        collection.insertOne(voluntario_Habilidad);
	        return voluntario_Habilidad;
	    }
	 
	 
}
