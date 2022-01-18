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

import com.example.Lab1TBD.models.Tarea_Habilidad;
import com.example.Lab1TBD.repositories.Tarea_HabilidadRepository;

@CrossOrigin
@RestController
public class Tarea_HabilidadService {
    private final Tarea_HabilidadRepository tarea_habilidadRepository;

    //Constructor
    Tarea_HabilidadService(Tarea_HabilidadRepository tarea_habilidadRepository){
        this.tarea_habilidadRepository = tarea_habilidadRepository;
    }

    //Create
    @PostMapping("/task_abilities")
    @ResponseBody
    public String createTarea_Habilidad(@RequestBody Tarea_Habilidad tarea_habilidad){
        return tarea_habilidadRepository.createTarea_Habilidad(tarea_habilidad);
    }

    //Read all
    @GetMapping("/task_abilities")
    public List<Tarea_Habilidad> getAllTarea_Habilidad(){
        return tarea_habilidadRepository.getAllTarea_Habilidad();
    }

    //Leer por id
    @GetMapping("/task_abilities/{id}")
    @ResponseBody
    public Tarea_Habilidad getTarea_HabilidadById(@PathVariable int id){
        return this.tarea_habilidadRepository.getTarea_HabilidadById(id);
    }

    //Update
    @PutMapping("/task_abilities/update/{id}")
    @ResponseBody
    public String updateTarea_Habilidad(@PathVariable int id, @RequestBody Tarea_Habilidad tarea_habilidad){
        return tarea_habilidadRepository.updateTarea_Habilidad(id, tarea_habilidad);
    }

    //Delete
    @DeleteMapping("/task_abilities/delete/{id}")
    @ResponseBody
    public String deleteTarea_Habilidad(@PathVariable int id){
        return tarea_habilidadRepository.deleteTarea_Habilidad(id);
    }
}