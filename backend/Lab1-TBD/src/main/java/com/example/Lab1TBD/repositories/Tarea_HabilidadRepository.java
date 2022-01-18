package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Tarea_Habilidad;

public interface Tarea_HabilidadRepository {
    public String createTarea_Habilidad(Tarea_Habilidad tarea_habilidad); //Create
    public List<Tarea_Habilidad> getAllTarea_Habilidad(); //Read
    public String updateTarea_Habilidad(int id, Tarea_Habilidad tarea_habilidad); //Update
    public String deleteTarea_Habilidad(int id);
    public Tarea_Habilidad getTarea_HabilidadById(Integer id);
    public int getIdTarea_HabilidadMayor();
}
