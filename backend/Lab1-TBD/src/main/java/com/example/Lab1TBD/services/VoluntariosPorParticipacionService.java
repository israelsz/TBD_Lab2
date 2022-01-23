package com.example.Lab1TBD.services;


import com.example.Lab1TBD.models.VoluntarioParticipacion;
import com.example.Lab1TBD.repositories.VoluntariosPorParticipacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntariosPorParticipacionService {

    private final VoluntariosPorParticipacionRepository voluntariosPorParticipacionRepository;

    //Constructor
    VoluntariosPorParticipacionService (VoluntariosPorParticipacionRepository voluntariosPorParticipacionRepository){
        this.voluntariosPorParticipacionRepository = voluntariosPorParticipacionRepository;
    }

    //Conseguir los voluntarios que se han realizado mas tareas de una emergencia
    @GetMapping("/voluntariesPerParticipation/{id}") //id de la emergencia
    @ResponseBody
    public List<VoluntarioParticipacion> getVoluntariesPerParticipation(@PathVariable int id){
        return this.voluntariosPorParticipacionRepository.getVoluntariesPerParticipation(id);
    }
}