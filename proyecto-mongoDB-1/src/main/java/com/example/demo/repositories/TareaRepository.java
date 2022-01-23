package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Tarea;

public interface TareaRepository {
	public int countTareas();
    public List<Tarea> getTareas();
    public Tarea createTarea(Tarea tarea);
}
