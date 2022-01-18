package com.example.Lab1TBD.models;

import java.util.Date;

public class Ranking {
    private int id;
    private Long puntos;
    private Integer id_tarea;
    private Integer id_voluntario;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Long getPuntos() {
        return puntos;
    }
    public void setPuntos(Long puntos) {
        this.puntos = puntos;
    }

    public Integer getId_tarea() {
        return id_tarea;
    }
    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_voluntario() {
        return id_voluntario;
    }
    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
