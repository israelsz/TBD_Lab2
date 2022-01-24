package com.example.demo.repositories;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Voluntario;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface VoluntarioTareaRepository {
    public List<Voluntario> findByTarea(String id);
    public ArrayList<Document> findByTareaB(String id);
}
