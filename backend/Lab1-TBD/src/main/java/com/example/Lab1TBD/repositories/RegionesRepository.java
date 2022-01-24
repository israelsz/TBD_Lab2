package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Regiones;

import java.util.List;
import java.util.Map;

public interface RegionesRepository {
    public List<Regiones> getAllRegiones(); //Read
    public List<Map<String, Object>> getRegionPoly(int id); //Consigue el poligono que la describe
}
