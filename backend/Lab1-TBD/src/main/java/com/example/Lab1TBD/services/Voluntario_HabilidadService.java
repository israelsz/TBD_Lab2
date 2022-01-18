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

import com.example.Lab1TBD.models.Voluntario_Habilidad;
import com.example.Lab1TBD.repositories.Voluntario_HabilidadRepository;

@CrossOrigin
@RestController
public class Voluntario_HabilidadService {
	 private final Voluntario_HabilidadRepository voluntario_habilidadRepository;

	    //Constructor
		Voluntario_HabilidadService(Voluntario_HabilidadRepository voluntario_habilidadRepository){
	        this.voluntario_habilidadRepository = voluntario_habilidadRepository;
	    }

	    //Create
	    @PostMapping("/vol_abilities")
	    @ResponseBody
	    public String createVoluntario_Habilidad(@RequestBody Voluntario_Habilidad voluntario_habilidad){
	        return voluntario_habilidadRepository.createVoluntario_Habilidad(voluntario_habilidad);
	    }

	    //Read all
	    @GetMapping("/vol_abilities")
	    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad(){
	        return voluntario_habilidadRepository.getAllVoluntario_Habilidad();
	    }

		//Leer uno
		@GetMapping("/vol_abilities/{id}")
		@ResponseBody
		public Voluntario_Habilidad getVoluntario_HabilidadById(@PathVariable int id){
			return this.voluntario_habilidadRepository.getVoluntario_HabilidadById(id);
		}

	    //Update
	    @PutMapping("/vol_abilities/update/{id}")
	    @ResponseBody
	    public String updateVoluntario_Habilidad(@PathVariable int id, @RequestBody Voluntario_Habilidad voluntario_habilidad){
	        return voluntario_habilidadRepository.updateVoluntario_Habilidad(id, voluntario_habilidad);
	    }

	    //Delete
	    @DeleteMapping("/vol_abilities/delete/id={id}")
	    @ResponseBody
	    public String deleteVoluntario_Habilidad(@PathVariable int id){
	        return voluntario_habilidadRepository.deleteVoluntario_Habilidad(id);
	    }
}
