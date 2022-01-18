package com.example.Lab1TBD.services;

import com.example.Lab1TBD.models.Habilidad;
import com.example.Lab1TBD.repositories.HabilidadRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {
    private final HabilidadRepository habilidadRepository;

    //Constructor
    HabilidadService(HabilidadRepository habilidadRepository){
        this.habilidadRepository = habilidadRepository;
    }

    //Create
    @PostMapping("/abilities")
    @ResponseBody
    public String createHabilidad(@RequestBody Habilidad habilidad){
        return habilidadRepository.createHabilidad(habilidad);
    }

    //Read all
    @GetMapping("/abilities")
    public List<Habilidad> getAllHabilidades(){
        return habilidadRepository.getAllHabilidades();
    }

    //Leer uno
    @GetMapping("/abilities/{id}")
    @ResponseBody
    public Habilidad getHabilidadById(@PathVariable int id){
        return this.habilidadRepository.getHabilidadById(id);
    }

    //Update
    @PutMapping("/abilities/update/{id}")
    @ResponseBody
    public String updateHabilidad(@PathVariable int id, @RequestBody Habilidad habilidad){
        return habilidadRepository.updateHabilidad(id, habilidad);
    }

    //Delete
    @DeleteMapping("/abilities/delete/{id}")
    @ResponseBody
    public String deleteHabilidad(@PathVariable int id){
        return habilidadRepository.deleteHabilidad(id);
    }
}