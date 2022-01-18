package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Tarea;

import java.util.List;

public interface TareaRepository {
    public Tarea createTarea(Tarea tarea); //Create
    public List<Tarea> getAllTareas(); //Read
    public String updateTarea(int id, Tarea tarea); //Update
    public String deleteTarea(int id);
    public Tarea getTarea(int id);
}
