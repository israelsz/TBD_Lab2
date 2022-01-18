package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Institucion;


public interface InstitucionRepository {
	 public String createInstitucion(Institucion institucion); //Create
	    public List<Institucion> getAllInstitucion(); //Read
	    public Institucion getInstitucionById(Integer id);
	    public String updateInstitucion(int id, Institucion institucion); //Update
	    public String deleteInstitucion(int id);
	    public int getIdInstitucionMayor();
}
