package com.example.Lab1TBD.services;

import com.example.Lab1TBD.models.Emergencia;
import com.example.Lab1TBD.repositories.EmergenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    //Constructor
    EmergenciaService(EmergenciaRepository emergenciaRepository){
        this.emergenciaRepository = emergenciaRepository;
    }

    //Create
    @PostMapping("/emergencies")
    @ResponseBody
    public String createEmergencia(@RequestBody Emergencia emergencia){
        return emergenciaRepository.createEmergencia(emergencia);
    }

    //Read all
    @GetMapping("/emergencies")
    public List<Emergencia> getAllEmergencias(){
        return emergenciaRepository.getAllEmergencias();
    }

    //Leer uno
    @GetMapping("/emergencies/{id}")
    @ResponseBody
    public Emergencia getEmergenciaById(@PathVariable int id){
        return this.emergenciaRepository.getEmergenciaById(id);
    }

    //Update
    @PutMapping("/emergencies/update/{id}")
    @ResponseBody
    public String updateEmergencia(@PathVariable int id, @RequestBody Emergencia emergencia){
        return emergenciaRepository.updateEmergencia(id, emergencia);
    }

    //Delete
    @DeleteMapping("/emergencies/delete/{id}")
    @ResponseBody
    public String deleteEmergencia(@PathVariable int id){
        return emergenciaRepository.deleteEmergencia(id);
    }
}
