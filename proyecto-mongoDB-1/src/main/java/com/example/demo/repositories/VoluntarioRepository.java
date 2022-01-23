package com.example.demo.repositories;



import java.util.List;

import com.example.demo.models.Voluntario;

public interface VoluntarioRepository {
	public int countVoluntarios();
    public List<Voluntario> getVoluntarios();
    public Voluntario createVoluntario(Voluntario voluntario);
}
