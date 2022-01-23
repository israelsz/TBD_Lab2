package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.EstadoTarea;


public interface EstadoTareaRepository {
	public int countEstadoTareas();
    public List<EstadoTarea> getEstadoTareas();
    public EstadoTarea createEstadoTarea(EstadoTarea estadoTarea);
}