package com.example.demo.repositories;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Coordinador;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {

    @Autowired
    MongoDatabase database;

    @Override
    public int countCoordinadors() {
        MongoCollection<Document> collection = database.getCollection("coordinador");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Coordinador> getCoordinadors() {
        MongoCollection<Coordinador> collection = database.getCollection("coordinador", Coordinador.class);
        List <Coordinador> coordinadors = collection.find().into(new ArrayList<>());
        
        return coordinadors;
    }

    @Override
    public Coordinador createCoordinador(Coordinador coordinador) {
        MongoCollection<Coordinador> collection = database.getCollection("coordinador", Coordinador.class);
        collection.insertOne(coordinador);
        return coordinador;
    }
    
}