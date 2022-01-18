package com.example.Lab1TBD.models;

import java.util.Date;

public class EstadoTarea {
    //Atributos
    private int id;
    private String estado;
    private Date created_at;
    private Date updated_at;



    //Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }


}
