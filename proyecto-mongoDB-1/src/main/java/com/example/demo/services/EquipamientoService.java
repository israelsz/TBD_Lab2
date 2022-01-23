package com.example.demo.services;


import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Equipamiento;
import com.example.demo.repositories.EquipamientoRepository;

import java.util.List;

@RestController
public class EquipamientoService {
	 private final EquipamientoRepository equipamientoRepository;
	 EquipamientoService(EquipamientoRepository equipamientoRepository){
	        this.equipamientoRepository = equipamientoRepository;
	    }
	    @GetMapping("/equipamientos/count")
	    public String countEquipamientos(){
	        int total = equipamientoRepository.countEquipamientos();
	        return String.format("Tienes %s Equipamiento!!", total);
	    }

	    @GetMapping("/equipamientos")
	    public List<Equipamiento> getEquipamientos(){
	        return equipamientoRepository.getEquipamientos();
	    }

	    @PostMapping("/equipamientos")
	    @ResponseBody
	    public Equipamiento createEquipamiento(@RequestBody Equipamiento equipamiento){
	    	Equipamiento result = equipamientoRepository.createEquipamiento(equipamiento);
	        return result;
	    }

}
