package com.example.demo.repositories;

import java.util.List;

import org.bson.Document;

import com.example.demo.models.Coordinador;


public interface CoordinadorRepository {
    public int countCoordinadors();
    public List<Coordinador> getCoordinadors();
    public Coordinador createCoordinador(Coordinador coordinador);
}