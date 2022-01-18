package com.example.Lab1TBD.services;

import com.example.Lab1TBD.models.EstadoTarea;
import com.example.Lab1TBD.repositories.EstadoTareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class EstadoTareaService {

    private final EstadoTareaRepository estadoTareaRepository;

    //Constructor
    EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
        this.estadoTareaRepository = estadoTareaRepository;
    }

    //Create
    @PostMapping("/createestadotarea")
    @ResponseBody
    public EstadoTarea createEstadoTarea(@RequestBody EstadoTarea estadoTarea){
        return estadoTareaRepository.createEstadoTarea(estadoTarea);
    }
    //Read
    @GetMapping("/estadotarea/get/{id}")
    @ResponseBody
    public EstadoTarea getEstadoTarea(@PathVariable int id){
        return estadoTareaRepository.getEstadoTarea(id);
    }


    //Read all
    @GetMapping("/estadotareas")
    public List<EstadoTarea> getAllEstadoTareas(){
        return estadoTareaRepository.getAllEstadoTareas();
    }

    //Update
    @PutMapping("/estadotarea/update/{id}")
    @ResponseBody
    public String updateEstadoTarea(@PathVariable int id, @RequestBody EstadoTarea estadoTarea){
        return estadoTareaRepository.updateEstadoTarea(id, estadoTarea);
    }

    //Delete
    @DeleteMapping("/estadotarea/delete/id={id}")
    @ResponseBody
    public String deleteEstadoTarea(@PathVariable int id){
        return estadoTareaRepository.deleteEstadoTarea(id);
    }
}
