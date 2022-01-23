package com.example.demo.services;

import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Tarea;
import com.example.demo.repositories.TareaRepository;

import java.util.List;

@RestController
public class TareaService {

	private final TareaRepository tareaRepository;
	TareaService(TareaRepository tareaRepository){
        this.tareaRepository = tareaRepository;
    }
    @GetMapping("/tareas/count")
    public String countTareas(){
        int total = tareaRepository.countTareas();
        return String.format("Tienes %s Tarea!!", total);
    }

    @GetMapping("/tareas")
    public List<Tarea> getTareas(){
        return tareaRepository.getTareas();
    }

    @PostMapping("/tareas")
    @ResponseBody
    public Tarea createTarea(@RequestBody Tarea tarea){
    	Tarea result = tareaRepository.createTarea(tarea);
        return result;
    }
}
