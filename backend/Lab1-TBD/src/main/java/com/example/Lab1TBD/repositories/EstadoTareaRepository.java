package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.EstadoTarea;

import java.util.List;

public interface EstadoTareaRepository {
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea); //Create
    public List<EstadoTarea> getAllEstadoTareas(); //Read
    public String updateEstadoTarea(int id, EstadoTarea estadoTarea); //Update
    public String deleteEstadoTarea(int id);
    public EstadoTarea getEstadoTarea(int id);
}