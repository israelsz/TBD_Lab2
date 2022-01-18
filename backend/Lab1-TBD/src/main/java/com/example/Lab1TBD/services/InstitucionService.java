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
import com.example.Lab1TBD.models.Institucion;
import com.example.Lab1TBD.repositories.InstitucionRepository;


@CrossOrigin
@RestController
public class InstitucionService {
	 private final InstitucionRepository institucionRepository;

	    //Constructor
	 	InstitucionService(InstitucionRepository institucionRepository){
	        this.institucionRepository = institucionRepository;
	    }

	    //Create
	    @PostMapping("/institucions")
	    @ResponseBody
	    public String createCoordinador(@RequestBody Institucion institucion){
	        return institucionRepository.createInstitucion(institucion);
	    }

	    //Read all
	    @GetMapping("/institucions")
	    public List<Institucion> getAllInstitucion(){
	        return institucionRepository.getAllInstitucion();
	    }
	    
	    //Leer uno
	    @GetMapping("/institucion/{id}")
	    @ResponseBody
	    public Institucion getInstitucionById(@PathVariable int id){
	        return this.institucionRepository.getInstitucionById(id);
	    }

	    //Update
	    @PutMapping("/institucions/update/{id}")
	    @ResponseBody
	    public String updateInstitucion(@PathVariable int id, @RequestBody Institucion institucion){
	        return institucionRepository.updateInstitucion(id, institucion);
	    }

	    //Delete
	    @DeleteMapping("/institucions/delete/id={id}")
	    @ResponseBody
	    public String deleteInstitucion(@PathVariable int id){
	        return institucionRepository.deleteInstitucion(id);
	    }
}
