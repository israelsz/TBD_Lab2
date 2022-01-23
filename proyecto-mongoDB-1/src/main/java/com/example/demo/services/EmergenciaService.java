package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Emergencia;
import com.example.demo.repositories.EmergenciaRepository;

@RestController
public class EmergenciaService {

	 private final EmergenciaRepository emergenciaRepository;
	 EmergenciaService(EmergenciaRepository emergenciaRepository){
	        this.emergenciaRepository = emergenciaRepository;
	    }
	    @GetMapping("/emergencias/count")
	    public String countEmergencias(){
	        int total = emergenciaRepository.countEmergencias();
	        return String.format("Tienes %s Emergencia!!", total);
	    }

	    @GetMapping("/emergencias")
	    public List<Emergencia> getEmergencias(){
	        return emergenciaRepository.getEmergencias();
	    }

	    @PostMapping("/emergencias")
	    @ResponseBody
	    public Emergencia createEmergencia(@RequestBody Emergencia emergencia){
	    	Emergencia result = emergenciaRepository.createEmergencia(emergencia);
	        return result;
	    }
}
