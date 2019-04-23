package com.jdbc.javabean;

public class Emp {// 与表名一致
	private int id; // 与表字段一致
	private String name;
	private String gender;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}

}
