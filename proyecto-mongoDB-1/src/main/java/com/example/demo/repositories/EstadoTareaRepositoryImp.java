package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.models.EstadoTarea;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EstadoTareaRepositoryImp implements EstadoTareaRepository{

	@Autowired
    MongoDatabase database;

    @Override
    public int countEstadoTareas() {
        MongoCollection<Document> collection = database.getCollection("estadoTarea");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<EstadoTarea> getEstadoTareas() {
        MongoCollection<EstadoTarea> collection = database.getCollection("estadoTarea", EstadoTarea.class);
        List <EstadoTarea> estadoTareas = collection.find().into(new ArrayList<>());
        
        return estadoTareas;
    }

    @Override
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea) {
        MongoCollection<EstadoTarea> collection = database.getCollection("estadoTarea", EstadoTarea.class);
        collection.insertOne(estadoTarea);
        return estadoTarea;
    }
}

