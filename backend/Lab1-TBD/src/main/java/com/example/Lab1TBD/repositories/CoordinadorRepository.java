package com.example.Lab1TBD.repositories;

import java.util.List;

import com.example.Lab1TBD.models.Coordinador;
import com.example.Lab1TBD.models.Emergencia;

public interface CoordinadorRepository {
    public String createCoordinador(Coordinador coordinador); //Create
    public List<Coordinador> getAllCoordinador(); //Read
    public Coordinador getCoordinadorById(Integer id);
    public String updateCoordinador(int id, Coordinador coordinador); //Update
    public String deleteCoordinador(int id);
    public int getIdCoordinadorMayor();
}
