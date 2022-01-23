package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Tarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class TareaRepositoryImp implements TareaRepository{


    @Autowired
    MongoDatabase database;

    @Override
    public int countTareas() {
        MongoCollection<Document> collection = database.getCollection("tarea");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Tarea> getTareas() {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        List <Tarea> tareas = collection.find().into(new ArrayList<>());
        
        return tareas;
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection("tarea", Tarea.class);
        collection.insertOne(tarea);
        return tarea;
    }
}
