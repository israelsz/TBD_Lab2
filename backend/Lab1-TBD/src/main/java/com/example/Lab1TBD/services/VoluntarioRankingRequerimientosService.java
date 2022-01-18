package com.example.Lab1TBD.services;

import com.example.Lab1TBD.models.VoluntarioCantidadHabilidades;
import com.example.Lab1TBD.repositories.VoluntarioRankingPorRequerimientosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioRankingRequerimientosService {
    private final VoluntarioRankingPorRequerimientosRepository voluntarioRankingPorRequerimientosRepository;
    public VoluntarioRankingRequerimientosService(VoluntarioRankingPorRequerimientosRepository voluntarioRankingPorRequerimientosRepository) {
        this.voluntarioRankingPorRequerimientosRepository = voluntarioRankingPorRequerimientosRepository;
    }

    @GetMapping("/voluntarioHabilidades/{id}")
    @ResponseBody
    public List<VoluntarioCantidadHabilidades> getVoluntarioHabilidades(@PathVariable int id){
        return voluntarioRankingPorRequerimientosRepository.getVoluntariosRequerimiento(id);
    }

}
