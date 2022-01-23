package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Emergencia_Habilidad;
import com.example.demo.repositories.Emergencia_HabilidadRepository;



@RestController
public class Emergencia_HabilidadService {
	 private final Emergencia_HabilidadRepository emergencia_HabilidadRepository;
	 Emergencia_HabilidadService(Emergencia_HabilidadRepository emergencia_HabilidadRepository){
	        this.emergencia_HabilidadRepository = emergencia_HabilidadRepository;
	    }
	    @GetMapping("/emergencia_Habilidads/count")
	    public String countDogs(){
	        int total = emergencia_HabilidadRepository.countEmergencia_Habilidads();
	        return String.format("Tienes %s Coordinador!!", total);
	    }

	    @GetMapping("/emergencia_Habilidads")
	    public List<Emergencia_Habilidad> getEmergencia_Habilidads(){
	        return emergencia_HabilidadRepository.getEmergencia_Habilidads();
	    }

	    @PostMapping("/emergencia_Habilidads")
	    @ResponseBody
	    public Emergencia_Habilidad createEmergencia_Habilidad(@RequestBody Emergencia_Habilidad emergencia_Habilidad){
	    	Emergencia_Habilidad result = emergencia_HabilidadRepository.createEmergencia_Habilidad(emergencia_Habilidad);
	        return result;
	    }
}