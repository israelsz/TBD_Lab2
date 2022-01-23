package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Voluntario_Habilidad;
import com.example.demo.repositories.Voluntario_HabilidadRepository;


@RestController
public class Voluntario_HabilidadService {
	private final Voluntario_HabilidadRepository voluntario_HabilidadRepository;
	Voluntario_HabilidadService(Voluntario_HabilidadRepository voluntario_HabilidadRepository){
        this.voluntario_HabilidadRepository = voluntario_HabilidadRepository;
    }
    @GetMapping("/voluntario_Habilidads/count")
    public String countVoluntario_Habilidads(){
        int total = voluntario_HabilidadRepository.countVoluntario_Habilidads();
        return String.format("Tienes %s Coordinador!!", total);
    }

    @GetMapping("/voluntario_Habilidads")
    public List<Voluntario_Habilidad> getVoluntario_Habilidads(){
        return voluntario_HabilidadRepository.getVoluntario_Habilidads();
    }

    @PostMapping("/voluntario_Habilidads")
    @ResponseBody
    public Voluntario_Habilidad createVoluntario_Habilidad(@RequestBody Voluntario_Habilidad voluntario_Habilidad){
    	Voluntario_Habilidad result = voluntario_HabilidadRepository.createVoluntario_Habilidad(voluntario_Habilidad);
        return result;
    }
}
