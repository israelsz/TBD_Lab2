package com.example.demo.models;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Voluntario_Habilidad {
	@BsonId
    ObjectId _id;
    private Integer id_voluntario;
    private Integer id_habilidad;
    private Date created_at;
    private Date updated_at;

    public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}

    public Integer getId_voluntario() {
        return id_voluntario;
    }
    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Integer getId_habilidad() {
        return id_habilidad;
    }
    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
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
