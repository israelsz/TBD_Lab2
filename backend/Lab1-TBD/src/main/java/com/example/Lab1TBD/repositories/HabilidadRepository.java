package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Habilidad;

import java.util.List;

public interface HabilidadRepository {

    public String createHabilidad(Habilidad habilidad); //Create
    public int getIdHabilidadMayor();
    public List<Habilidad> getAllHabilidades(); //Read(All)
    public Habilidad getHabilidadById(Integer id);
    public String updateHabilidad(int id, Habilidad habilidad); //Update
    public String deleteHabilidad(int id); //Delete
}
