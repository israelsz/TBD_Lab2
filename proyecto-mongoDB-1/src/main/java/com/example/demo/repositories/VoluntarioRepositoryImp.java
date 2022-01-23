package com.example.demo.repositories;

import com.example.demo.models.Voluntario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
	@Autowired
    MongoDatabase database;

    @Override
    public int countVoluntarios() {
        MongoCollection<Document> collection = database.getCollection("voluntario");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Voluntario> getVoluntarios() {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        List <Voluntario> voluntarios = collection.find().into(new ArrayList<>());
        
        return voluntarios;
    }

    @Override
    public Voluntario createVoluntario(Voluntario voluntario) {
        MongoCollection<Voluntario> collection = database.getCollection("voluntario", Voluntario.class);
        collection.insertOne(voluntario);
        return voluntario;
    }
}
