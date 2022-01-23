package com.example.demo.models;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Tarea_Habilidad {
	@BsonId
    ObjectId _id;
    private Integer id_tarea;
    private Integer id_eme_habilidad;
    private Date created_at;
    private Date updated_at;

    public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}

    public Integer getId_tarea() {
        return id_tarea;
    }
    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Integer getId_eme_habilidad() {
        return id_eme_habilidad;
    }
    public void setId_eme_habilidad(int id_eme_habilidad) {
        this.id_eme_habilidad = id_eme_habilidad;
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