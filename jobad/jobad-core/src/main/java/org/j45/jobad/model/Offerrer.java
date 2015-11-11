package org.j45.jobad.model;

import java.io.Serializable;

public class Offerrer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Offerrer(OffererType type, String name) {
		super();
		this.id = (long) Math.random() * 10000000;
		this.type = type;
		this.name = name;
	}
	private long id;
	private OffererType type;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public OffererType getType() {
		return type;
	}
	public void setType(OffererType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// this should be on DB, matched basing on name
}
