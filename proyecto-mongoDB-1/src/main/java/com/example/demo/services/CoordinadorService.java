package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Coordinador;
import com.example.demo.repositories.CoordinadorRepository;

@RestController
public class CoordinadorService {
 
    private final CoordinadorRepository coordinadorRepository;
    CoordinadorService(CoordinadorRepository coordinadorRepository){
        this.coordinadorRepository = coordinadorRepository;
    }
    @GetMapping("/coordinadors/count")
    public String countCoordinadors(){
        int total = coordinadorRepository.countCoordinadors();
        return String.format("Tienes %s Coordinador!!", total);
    }

    @GetMapping("/coordinadors")
    public List<Coordinador> getCoordinadors(){
        return coordinadorRepository.getCoordinadors();
    }

    @PostMapping("/coordinadors")
    @ResponseBody
    public Coordinador createCoordinador(@RequestBody Coordinador coordinador){
    	Coordinador result = coordinadorRepository.createCoordinador(coordinador);
        return result;
    }

}