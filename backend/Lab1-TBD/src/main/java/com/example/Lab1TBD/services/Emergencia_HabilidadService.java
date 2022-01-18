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

import com.example.Lab1TBD.models.Emergencia_Habilidad;
import com.example.Lab1TBD.repositories.Emergencia_HabilidadRepository;

@CrossOrigin
@RestController
public class Emergencia_HabilidadService {
    private final Emergencia_HabilidadRepository emergencia_habilidadRepository;

    //Constructor
    Emergencia_HabilidadService(Emergencia_HabilidadRepository emergencia_habilidadRepository){
        this.emergencia_habilidadRepository = emergencia_habilidadRepository;
    }

    //Create
    @PostMapping("/eme_abilities")
    @ResponseBody
    public String createEmergencia_Habilidad(@RequestBody Emergencia_Habilidad emergencia_habilidad){
        return emergencia_habilidadRepository.createEmergencia_Habilidad(emergencia_habilidad);
    }

    //Read all
    @GetMapping("/eme_abilities")
    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad(){
        return emergencia_habilidadRepository.getAllEmergencia_Habilidad();
    }

    //Leer por id
    @GetMapping("/eme_abilities/{id}")
    @ResponseBody
    public Emergencia_Habilidad getEmergencia_HabilidadById(@PathVariable int id){
        return this.emergencia_habilidadRepository.getEmergencia_HabilidadById(id);
    }

    //Update
    @PutMapping("/eme_abilities/update/{id}")
    @ResponseBody
    public String updateEmergencia_Habilidad(@PathVariable int id, @RequestBody Emergencia_Habilidad emergencia_habilidad){
        return emergencia_habilidadRepository.updateEmergencia_Habilidad(id, emergencia_habilidad);
    }

    //Delete
    @DeleteMapping("/eme_abilities/delete/{id}")
    @ResponseBody
    public String deleteEmergencia_Habilidad(@PathVariable int id){
        return emergencia_habilidadRepository.deleteEmergencia_Habilidad(id);
    }
}