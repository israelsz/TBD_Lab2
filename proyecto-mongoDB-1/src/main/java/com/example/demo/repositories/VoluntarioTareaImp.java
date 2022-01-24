package com.example.demo.repositories;

import com.example.demo.models.Voluntario;
import com.mongodb.client.AggregateIterable;
import org.springframework.stereotype.Repository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;

import com.mongodb.client.FindIterable;

@Repository
public class VoluntarioTareaImp implements VoluntarioTareaRepository{
    @Autowired
    MongoDatabase database;

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public ArrayList<Document> findByTarea(String id) {
        MongoCollection<Document> collection = database.getCollection("voluntario");
        AggregateIterable<Document> r = collection.aggregate(Arrays.asList(new Document("$lookup",
                        new Document("from", "voluntario_tarea")
                                .append("localField", "_id")
                                .append("foreignField", "id_voluntario")
                                .append("pipeline", Arrays.asList(new Document("$match",
                                        new Document("id_tarea", "1"))))
                                .append("as", "voluntarios")),
                new Document("$unwind",
                        new Document("path", "$voluntarios")),
                new Document("$project",
                        new Document("nombre", 1L)
                                .append("apellido", 1L)
                                .append("correo_electronico", 1L))));
        ArrayList<Document> result = new ArrayList<>(2);
        for (Document document : r) {
            result.add(document);
        }
        return result;
    }


}
