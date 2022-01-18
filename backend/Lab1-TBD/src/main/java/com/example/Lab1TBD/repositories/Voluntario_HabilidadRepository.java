package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Voluntario_Habilidad;

public interface Voluntario_HabilidadRepository {
    public String createVoluntario_Habilidad(Voluntario_Habilidad voluntario_habilidad); //Create
    public List<Voluntario_Habilidad> getAllVoluntario_Habilidad(); //Read
    public String updateVoluntario_Habilidad(int id, Voluntario_Habilidad voluntario_habilidad); //Update
    public String deleteVoluntario_Habilidad(int id);
    public Voluntario_Habilidad getVoluntario_HabilidadById(Integer id);
    public int getIdVoluntario_HabilidadMayor();
}
