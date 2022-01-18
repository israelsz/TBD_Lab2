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

import com.example.Lab1TBD.models.Coordinador;
import com.example.Lab1TBD.models.Emergencia;
import com.example.Lab1TBD.repositories.CoordinadorRepository;

@CrossOrigin
@RestController
public class CoordinadorService {
	 private final CoordinadorRepository coordinadorRepository;

	    //Constructor
	    CoordinadorService(CoordinadorRepository coordinadorRepository){
	        this.coordinadorRepository = coordinadorRepository;
	    }

	    //Create
	    @PostMapping("/coodinadors")
	    @ResponseBody
	    public String createCoordinador(@RequestBody Coordinador coordinador){
	        return coordinadorRepository.createCoordinador(coordinador);
	    }

	    //Read all
	    @GetMapping("/coodinadors")
	    public List<Coordinador> getAllCoordinador(){
	        return coordinadorRepository.getAllCoordinador();
	        
	    }

	  //Leer uno
	    @GetMapping("/coordinador/{id}")
	    @ResponseBody
	    public Coordinador getCoordinadorById(@PathVariable int id){
	        return this.coordinadorRepository.getCoordinadorById(id);
	    }
	    
	    //Update
	    @PutMapping("/coodinadors/update/{id}")
	    @ResponseBody
	    public String updateCoordinador(@PathVariable int id, @RequestBody Coordinador coordinador){
	        return coordinadorRepository.updateCoordinador(id, coordinador);
	    }

	    //Delete
	    @DeleteMapping("/coodinadors/delete/id={id}")
	    @ResponseBody
	    public String deleteCoordinador(@PathVariable int id){
	        return coordinadorRepository.deleteCoordinador(id);
	    }
}
