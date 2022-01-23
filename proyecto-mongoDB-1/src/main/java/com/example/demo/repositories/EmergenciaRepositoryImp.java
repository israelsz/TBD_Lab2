package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Emergencia;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

	@Autowired
    MongoDatabase database;

    @Override
    public int countEmergencias() {
        MongoCollection<Document> collection = database.getCollection("emergencia");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Emergencia> getEmergencias() {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        List <Emergencia> emergencias = collection.find().into(new ArrayList<>());
        
        return emergencias;
    }

    @Override
    public Emergencia createEmergencia(Emergencia emergencia) {
        MongoCollection<Emergencia> collection = database.getCollection("emergencia", Emergencia.class);
        collection.insertOne(emergencia);
        return emergencia;
    }
}
