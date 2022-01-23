package com.example.demo.services;


import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Habilidad;
import com.example.demo.repositories.HabilidadRepository;

import java.util.List;


@RestController
public class HabilidadService {
	private final HabilidadRepository habilidadRepository;
	HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }
    @GetMapping("/habilidads/count")
    public String countHabilidads(){
        int total = habilidadRepository.countHabilidads();
        return String.format("Tienes %s Habilidad!!", total);
    }

    @GetMapping("/habilidads")
    public List<Habilidad> getHabilidads(){
        return habilidadRepository.getHabilidads();
    }

    @PostMapping("/habilidads")
    @ResponseBody
    public Habilidad createHabilidad(@RequestBody Habilidad  habilidad){
    	Habilidad result = habilidadRepository.createHabilidad( habilidad);
        return result;
    }
}