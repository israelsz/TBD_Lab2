package com.example.demo.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Voluntario;
import com.example.demo.repositories.VoluntarioRepository;

import java.util.List;
@RestController
public class VoluntarioService {
	 private final VoluntarioRepository voluntarioRepository;
	 VoluntarioService(VoluntarioRepository voluntarioRepository){
	        this.voluntarioRepository = voluntarioRepository;
	    }
	    @GetMapping("/voluntarios/count")
	    public String countVoluntarios(){
	        int total = voluntarioRepository.countVoluntarios();
	        return String.format("Tienes %s Voluntario!!", total);
	    }

	    @GetMapping("/voluntarios")
	    public List<Voluntario> getVoluntarios(){
	        return voluntarioRepository.getVoluntarios();
	    }

	    @PostMapping("/voluntarios")
	    @ResponseBody
	    public Voluntario createVoluntario(@RequestBody Voluntario voluntario){
	    	Voluntario result = voluntarioRepository.createVoluntario(voluntario);
	        return result;
	    }
}
