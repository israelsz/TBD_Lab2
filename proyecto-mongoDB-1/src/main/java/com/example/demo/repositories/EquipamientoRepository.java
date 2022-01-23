package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Equipamiento;

public interface EquipamientoRepository {

	public int countEquipamientos();
    public List<Equipamiento> getEquipamientos();
    public Equipamiento createEquipamiento(Equipamiento equipamiento);
}
