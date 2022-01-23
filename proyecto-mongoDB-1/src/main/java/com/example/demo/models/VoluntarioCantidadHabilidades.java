package com.example.demo.models;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class VoluntarioCantidadHabilidades {
	@BsonId
    ObjectId _id;
    private int cantidad_habilidades;
    private String nombre;
    private String apellido;
    private String estado_salud;

    public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstadoSalud() {
        return estado_salud;
    }

    public void setEstadoSalud(String estado_salud) {
        this.estado_salud = estado_salud;
    }
    public int getCantidadHabilidades() {
        return cantidad_habilidades;
    }

    public void setCantidadHabilidades(int cantidad_habilidades) {
        this.cantidad_habilidades = cantidad_habilidades;
    }
}
