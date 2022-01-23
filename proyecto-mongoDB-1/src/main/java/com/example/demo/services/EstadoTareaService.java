package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.EstadoTarea;
import com.example.demo.repositories.EstadoTareaRepository;


@RestController
public class EstadoTareaService {

	 private final EstadoTareaRepository estadoTareaRepository;
	 EstadoTareaService(EstadoTareaRepository estadoTareaRepository){
	        this.estadoTareaRepository = estadoTareaRepository;
	    }
	    @GetMapping("/estadoTareas/count")
	    public String countEstadoTareas(){
	        int total = estadoTareaRepository.countEstadoTareas();
	        return String.format("Tienes %s EstadoTarea!!", total);
	    }

	    @GetMapping("/estadoTareas")
	    public List<EstadoTarea> getEstadoTareas(){
	        return estadoTareaRepository.getEstadoTareas();
	    }

	    @PostMapping("/estadoTareas")
	    @ResponseBody
	    public EstadoTarea createEstadoTarea(@RequestBody EstadoTarea estadoTarea){
	    	EstadoTarea result = estadoTareaRepository.createEstadoTarea(estadoTarea);
	        return result;
	    }
}
