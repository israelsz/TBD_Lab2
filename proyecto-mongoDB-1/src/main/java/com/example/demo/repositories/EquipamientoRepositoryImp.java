package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Equipamiento;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EquipamientoRepositoryImp implements EquipamientoRepository {
	 @Autowired
	    MongoDatabase database;

	    @Override
	    public int countEquipamientos() {
	        MongoCollection<Document> collection = database.getCollection("equipamiento");
	        long count = collection.countDocuments();
	        return (int) count;
	    }

	    @Override
	    public List<Equipamiento> getEquipamientos() {
	        MongoCollection<Equipamiento> collection = database.getCollection("equipamiento", Equipamiento.class);
	        List <Equipamiento> equipamientos = collection.find().into(new ArrayList<>());
	        
	        return equipamientos;
	    }

	    @Override
	    public Equipamiento createEquipamiento(Equipamiento equipamiento) {
	        MongoCollection<Equipamiento> collection = database.getCollection("equipamiento", Equipamiento.class);
	        collection.insertOne(equipamiento);
	        return equipamiento;
	    }


}
