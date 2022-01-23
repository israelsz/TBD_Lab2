package com.example.demo.services;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Tarea_Habilidad;
import com.example.demo.repositories.Tarea_HabilidadRepository;



@RestController
public class Tarea_HabilidadService {
	 private final Tarea_HabilidadRepository tarea_HabilidadRepository;
	 Tarea_HabilidadService(Tarea_HabilidadRepository tarea_HabilidadRepository){
	        this.tarea_HabilidadRepository = tarea_HabilidadRepository;
	    }
	    @GetMapping("/tarea_Habilidads/count")
	    public String countTarea_Habilidads(){
	        int total = tarea_HabilidadRepository.countTarea_Habilidads();
	        return String.format("Tienes %s tarea_Habilidad!!", total);
	    }

	    @GetMapping("/tarea_Habilidads")
	    public List<Tarea_Habilidad> getTarea_Habilidads(){
	        return tarea_HabilidadRepository.getTarea_Habilidads();
	    }

	    @PostMapping("/tarea_Habilidads")
	    @ResponseBody
	    public Tarea_Habilidad createTarea_Habilidad(@RequestBody Tarea_Habilidad tarea_Habilidad){
	    	Tarea_Habilidad result = tarea_HabilidadRepository.createTarea_Habilidad(tarea_Habilidad);
	        return result;
	    }

}