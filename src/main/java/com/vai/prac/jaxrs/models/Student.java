package com.vai.prac.jaxrs.models;

import java.sql.Timestamp;
import java.util.Date;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.ws.rs.FormParam;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.vai.prac.jaxrs.utils.RestDateParam;

@XmlRootElement
public class Student {

	private long id;
	private String name;
	private Date createdAt;

	public Student() {

	}

	public Student(long id, String name) {
		this.id = id;
		this.name = name;
		this.createdAt =new Date();//new Timestamp(new Date().getTime());
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
