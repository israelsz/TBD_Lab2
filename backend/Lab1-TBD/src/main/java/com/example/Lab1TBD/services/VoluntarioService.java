package com.example.Lab1TBD.services;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Lab1TBD.models.Voluntario;
import com.example.Lab1TBD.repositories.VoluntarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class VoluntarioService {
    private VoluntarioRepository voluntarioRepository;

    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository=voluntarioRepository;
    }

    //Create
    @PostMapping("/volunteers")
    @ResponseBody
    public String createVoluntario(@RequestBody Voluntario voluntario){
        return voluntarioRepository.createVoluntario(voluntario);
    }

    //Getter
    @GetMapping("/volunteers")
    public List<Voluntario> getAllVoluntarios(){
        return voluntarioRepository.getAllVoluntario();
    }

    //Get by id
    @GetMapping("/volunteers/{id}")
    @ResponseBody
    public Voluntario getVoluntarioById(@PathVariable int id){
        return this.voluntarioRepository.getVoluntarioById(id);
    }

    @PutMapping("/volunteers/update/{id}")
    @ResponseBody
    public String updateVoluntario(@PathVariable int id, @RequestBody Voluntario voluntario){
        return voluntarioRepository.updateVoluntario(id,voluntario);
    }

    @DeleteMapping("/volunteers/delete/id={id}")
    @ResponseBody
    public String deleteVoluntario(@PathVariable int id){
        return voluntarioRepository.deleteVoluntario(id);
    }


}
