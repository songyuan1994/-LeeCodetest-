package com.example.demo.entity;

public class Teacher {
	private Long id;
	private String name;
	private String classes;
	private String ageId;
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getAgeId() {
		return ageId;
	}
	public void setAgeId(String ageId) {
		this.ageId = ageId;
	}
	public Teacher() {
	}
	
	
	
	
}
