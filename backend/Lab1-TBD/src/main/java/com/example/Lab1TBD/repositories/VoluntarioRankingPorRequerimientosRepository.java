package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.VoluntarioCantidadHabilidades;

import java.util.List;

public interface VoluntarioRankingPorRequerimientosRepository {
    public List<VoluntarioCantidadHabilidades> getVoluntariosRequerimiento(int idEmergencia);
}
