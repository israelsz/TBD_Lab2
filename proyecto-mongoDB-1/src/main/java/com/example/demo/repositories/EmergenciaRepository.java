package com.example.demo.repositories;


import java.util.List;

import com.example.demo.models.Emergencia;

public interface EmergenciaRepository {
	 public int countEmergencias();
	    public List<Emergencia> getEmergencias();
	    public Emergencia createEmergencia(Emergencia emergencia);
}
