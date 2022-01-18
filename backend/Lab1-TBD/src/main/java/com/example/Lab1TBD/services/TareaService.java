package com.example.Lab1TBD.services;

import com.example.Lab1TBD.models.Tarea;
import com.example.Lab1TBD.repositories.TareaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final TareaRepository TareaRepository;

    //Constructor
    TareaService(TareaRepository tareaRepository){
        this.TareaRepository = tareaRepository;
    }

    //Create
    @PostMapping("/createtarea")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
        return TareaRepository.createTarea(tarea);
    }

    //Read
    @GetMapping("/tarea/get/{id}")
    @ResponseBody
    public Tarea getTarea(@PathVariable int id){
        return TareaRepository.getTarea(id);
    }

    //Read all
    @GetMapping("/tareas")
    @ResponseBody
    public List<Tarea> getAllTareas(){
        return TareaRepository.getAllTareas();
    }

    //Update
    @PutMapping("/tarea/update/{id}")
    @ResponseBody
    public String updateTarea(@PathVariable int id, @RequestBody Tarea tarea){
        return TareaRepository.updateTarea(id, tarea);
    }

    //Delete
    @DeleteMapping("/tarea/delete/id={id}")
    @ResponseBody
    public String deleteTarea(@PathVariable int id){
        return TareaRepository.deleteTarea(id);
    }
}
