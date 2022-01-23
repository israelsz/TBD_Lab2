package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Emergencia_Habilidad;


public interface Emergencia_HabilidadRepository {
	public int countEmergencia_Habilidads();
    public List<Emergencia_Habilidad> getEmergencia_Habilidads();
    public Emergencia_Habilidad createEmergencia_Habilidad(Emergencia_Habilidad emergencia_Habilidad);
}
