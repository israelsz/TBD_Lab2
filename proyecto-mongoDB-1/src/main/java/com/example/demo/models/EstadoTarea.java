package com.example.demo.models;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class EstadoTarea {
    //Atributos
	@BsonId
    ObjectId _id;
    private String estado;
    private Date created_at;
    private Date updated_at;



    //Getters y Setters
    public ObjectId get_id() {
		return _id;
	}


	public void set_id(ObjectId _id) {
		this._id = _id;
	}

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getCreated_at() { return created_at; }
    public void setCreated_at(Date created_at) { this.created_at = created_at; }

    public Date getUpdated_at() { return updated_at; }
    public void setUpdated_at(Date updated_at) { this.updated_at = updated_at; }


}
