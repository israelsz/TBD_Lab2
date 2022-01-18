package com.example.Lab1TBD.services;


import com.example.Lab1TBD.models.VoluntarioRanking;
import com.example.Lab1TBD.repositories.VoluntarioRankingPorTareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioRankingPorTareaService {

    private final VoluntarioRankingPorTareaRepository voluntarioRankingPorTareaRepository;

    //Constructor
    VoluntarioRankingPorTareaService(VoluntarioRankingPorTareaRepository voluntarioRankingPorTareaRepository){
        this.voluntarioRankingPorTareaRepository = voluntarioRankingPorTareaRepository;
    }

    //Conseguir el ranking de voluntarios para una cierta tarea
    @GetMapping("/voluntariesRankedPerTask/{id}") //id de la tarea
    @ResponseBody
    public List<VoluntarioRanking> getVoluntariesRankedPerTask(@PathVariable int id){
        return this.voluntarioRankingPorTareaRepository.getVoluntariesRankedPerTask(id);
    }
}
