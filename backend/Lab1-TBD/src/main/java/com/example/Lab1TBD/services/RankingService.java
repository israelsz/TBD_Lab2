package com.example.Lab1TBD.services;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lab1TBD.models.Ranking;
import com.example.Lab1TBD.repositories.RankingRepository;

@CrossOrigin
@RestController
public class RankingService {
	 private final RankingRepository rankingRepository;

	    //Constructor
		RankingService(RankingRepository rankingRepository){
	        this.rankingRepository = rankingRepository;
	    }

	    //Create
	    @PostMapping("/rankings")
	    @ResponseBody
	    public String createRanking(@RequestBody Ranking ranking){
	        return rankingRepository.createRanking(ranking);
	    }

	    //Read all
	    @GetMapping("/rankings")
	    public List<Ranking> getAllRanking(){
	        return rankingRepository.getAllRanking();
	    }
		//Leer uno
		@GetMapping("/rankings/{id}")
		@ResponseBody
		public Ranking getRankingById(@PathVariable int id){
			return this.rankingRepository.getRankingById(id);
	}
	    //Update
	    @PutMapping("/rankings/update/{id}")
	    @ResponseBody
	    public String updateRanking(@PathVariable int id, @RequestBody Ranking ranking){
	        return rankingRepository.updateRanking(id, ranking);
	    }

	    //Delete
	    @DeleteMapping("/rankings/delete/id={id}")
	    @ResponseBody
	    public String deleteRanking(@PathVariable int id){
	        return rankingRepository.deleteRanking(id);
	    }
}
