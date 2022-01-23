package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Institucion;
import com.example.demo.repositories.InstitucionRepository;


@RestController
public class InstitucionService {
	private final InstitucionRepository institucionRepository;
	InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }
    @GetMapping("/institucions/count")
    public String countInstitucions(){
        int total = institucionRepository.countInstitucions();
        return String.format("Tienes %s Institucion!!", total);
    }

    @GetMapping("/institucions")
    public List<Institucion> getInstitucions(){
        return institucionRepository.getInstitucions();
    }

    @PostMapping("/institucions")
    @ResponseBody
    public Institucion createInstitucion(@RequestBody Institucion institucion){
    	Institucion result = institucionRepository.createInstitucion(institucion);
        return result;
    }
}
