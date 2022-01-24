package com.example.demo.repositories;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Voluntario;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface VoluntarioTareaRepository {
    public ArrayList<Document> findByTarea(String id);
}
