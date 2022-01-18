package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Ranking;

public interface RankingRepository {
    public String createRanking(Ranking ranking); //Create
    public List<Ranking> getAllRanking(); //Read
    public String updateRanking(int id, Ranking ranking); //Update
    public String deleteRanking(int id);
    public Ranking getRankingById(Integer id);
    public int getIdRankingMayor();
}
