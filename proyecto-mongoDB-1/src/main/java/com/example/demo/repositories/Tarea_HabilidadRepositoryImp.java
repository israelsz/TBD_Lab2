package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Tarea_Habilidad;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class Tarea_HabilidadRepositoryImp  implements Tarea_HabilidadRepository {


    @Autowired
    MongoDatabase database;

    @Override
    public int countTarea_Habilidads() {
        MongoCollection<Document> collection = database.getCollection("tarea_Habilidad");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Tarea_Habilidad> getTarea_Habilidads() {
        MongoCollection<Tarea_Habilidad> collection = database.getCollection("tarea_Habilidad", Tarea_Habilidad.class);
        List <Tarea_Habilidad> tarea_Habilidads = collection.find().into(new ArrayList<>());
        
        return tarea_Habilidads;
    }

    @Override
    public Tarea_Habilidad createTarea_Habilidad(Tarea_Habilidad tarea_Habilidad) {
        MongoCollection<Tarea_Habilidad> collection = database.getCollection("tarea_Habilidad", Tarea_Habilidad.class);
        collection.insertOne(tarea_Habilidad);
        return tarea_Habilidad;
    }
}