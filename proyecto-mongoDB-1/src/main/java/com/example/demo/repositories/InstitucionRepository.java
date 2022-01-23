package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Institucion;


public interface InstitucionRepository {
	public int countInstitucions();
    public List<Institucion> getInstitucions();
    public Institucion createInstitucion(Institucion institucion);
}
