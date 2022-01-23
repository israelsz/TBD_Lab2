package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.VoluntarioParticipacion;

import java.util.List;

public interface VoluntariosPorParticipacionRepository {
    public List<VoluntarioParticipacion> getVoluntariesPerParticipation(int id);
}
