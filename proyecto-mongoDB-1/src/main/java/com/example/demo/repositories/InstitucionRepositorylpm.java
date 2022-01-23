package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Institucion;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



@Repository
public class InstitucionRepositorylpm implements InstitucionRepository {
	 @Autowired
	    MongoDatabase database;

	    @Override
	    public int countInstitucions() {
	        MongoCollection<Document> collection = database.getCollection("institucion");
	        long count = collection.countDocuments();
	        return (int) count;
	    }

	    @Override
	    public List<Institucion> getInstitucions() {
	        MongoCollection<Institucion> collection = database.getCollection("institucion", Institucion.class);
	        List <Institucion> institucions = collection.find().into(new ArrayList<>());
	        
	        return institucions;
	    }

	    @Override
	    public Institucion createInstitucion(Institucion institucion) {
	        MongoCollection<Institucion> collection = database.getCollection("institucion", Institucion.class);
	        collection.insertOne(institucion);
	        return institucion;
	    }
}