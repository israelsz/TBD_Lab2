package com.example.demo.models;

import java.util.Date;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Institucion {
	@BsonId
    ObjectId _id;
	 private String razon_social;
	 private Date created_at;
	 private Date updated_at;
	 
	 public ObjectId get_id() {
			return _id;
		}


		public void set_id(ObjectId _id) {
			this._id = _id;
		}
	public String getRazon_social() {
		return razon_social;
	}
	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
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
