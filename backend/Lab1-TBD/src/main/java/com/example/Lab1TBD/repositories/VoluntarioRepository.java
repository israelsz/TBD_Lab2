package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public String createVoluntario(Voluntario voluntario); //Create
    public List<Voluntario> getAllVoluntario(); //Read
    public Voluntario getVoluntarioById(Integer id);
    public String updateVoluntario(int id, Voluntario voluntario);//Update
    public String deleteVoluntario(int id);//Delete
    public int getIdVoluntarioMayor();
}
