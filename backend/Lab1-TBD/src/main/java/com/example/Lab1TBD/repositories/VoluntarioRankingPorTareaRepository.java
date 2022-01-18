package com.example.Lab1TBD.repositories;

import com.example.Lab1TBD.models.VoluntarioRanking;

import java.util.List;

public interface VoluntarioRankingPorTareaRepository {
    public List<VoluntarioRanking> getVoluntariesRankedPerTask(int id);
}
