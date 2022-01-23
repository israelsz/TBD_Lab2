package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Ranking;

public interface RankingRepository {
	public int countRankings();
    public List<Ranking> getRankings();
    public Ranking createRanking(Ranking ranking);
}
