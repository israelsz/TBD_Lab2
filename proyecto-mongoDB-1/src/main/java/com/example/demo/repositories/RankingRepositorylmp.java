package com.example.demo.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ranking;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

@Repository
public class RankingRepositorylmp implements RankingRepository  {

	@Autowired
    MongoDatabase database;

    @Override
    public int countRankings() {
        MongoCollection<Document> collection = database.getCollection("ranking");
        long count = collection.countDocuments();
        return (int) count;
    }

    @Override
    public List<Ranking> getRankings() {
        MongoCollection<Ranking> collection = database.getCollection("ranking", Ranking.class);
        List <Ranking> rankings = collection.find().into(new ArrayList<>());
        
        return rankings;
    }

    @Override
    public Ranking createRanking(Ranking ranking) {
        MongoCollection<Ranking> collection = database.getCollection("ranking", Ranking.class);
        collection.insertOne(ranking);
        return ranking;
    }
	 
}
