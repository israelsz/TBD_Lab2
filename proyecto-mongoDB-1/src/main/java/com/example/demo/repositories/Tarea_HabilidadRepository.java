package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Tarea_Habilidad;

public interface Tarea_HabilidadRepository {
	 public int countTarea_Habilidads();
	    public List<Tarea_Habilidad> getTarea_Habilidads();
	    public Tarea_Habilidad createTarea_Habilidad(Tarea_Habilidad tarea_Habilidad);
}
