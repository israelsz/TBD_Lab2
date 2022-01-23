package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Ranking;
import com.example.demo.repositories.RankingRepository;


@RestController
public class RankingService {
	 private final RankingRepository rankingRepository;
	 RankingService(RankingRepository rankingRepository){
	        this.rankingRepository = rankingRepository;
	    }
	    @GetMapping("/rankings/count")
	    public String countRankings(){
	        int total = rankingRepository.countRankings();
	        return String.format("Tienes %s ranking!!", total);
	    }

	    @GetMapping("/rankings")
	    public List<Ranking> getRankings(){
	        return rankingRepository.getRankings();
	    }

	    @PostMapping("/rankings")
	    @ResponseBody
	    public Ranking createRanking(@RequestBody Ranking ranking){
	    	Ranking result = rankingRepository.createRanking(ranking);
	        return result;
	    }
}
