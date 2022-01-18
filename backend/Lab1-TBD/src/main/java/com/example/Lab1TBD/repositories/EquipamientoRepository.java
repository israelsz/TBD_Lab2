package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.Equipamiento;

import java.util.List;

public interface EquipamientoRepository {

    public String createEquipamiento(Equipamiento equipamiento);            //Create
    public int getIdEquipamientoMayor();
    public List<Equipamiento> getAllEquipamiento();                         //ReadAll
    public Equipamiento getEquipamientoById(int id);                        //Read
    public String updateEquipamiento(int id,Equipamiento equipamiento);     //Update
    public String deleteEquipamiento(int id);                               //Delete
}
