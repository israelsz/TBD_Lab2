package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Habilidad;

public interface HabilidadRepository {

	 public int countHabilidads();
	 public List<Habilidad> getHabilidads();
	 public Habilidad createHabilidad(Habilidad habilidad);
}
