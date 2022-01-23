package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Voluntario_Habilidad;



public interface Voluntario_HabilidadRepository {
	public int countVoluntario_Habilidads();
    public List<Voluntario_Habilidad> getVoluntario_Habilidads();
    public Voluntario_Habilidad createVoluntario_Habilidad(Voluntario_Habilidad voluntario_Habilidad);
}
