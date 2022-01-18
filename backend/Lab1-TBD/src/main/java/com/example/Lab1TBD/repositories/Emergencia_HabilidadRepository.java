package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Emergencia_Habilidad;

public interface Emergencia_HabilidadRepository {
    public String createEmergencia_Habilidad(Emergencia_Habilidad emergencia_habilidad); //Create
    public List<Emergencia_Habilidad> getAllEmergencia_Habilidad(); //Read
    public String updateEmergencia_Habilidad(int id, Emergencia_Habilidad emergencia_habilidad); //Update
    public String deleteEmergencia_Habilidad(int id);
    public Emergencia_Habilidad getEmergencia_HabilidadById(Integer id);
    public int getIdEmergencia_HabilidadMayor();
}
