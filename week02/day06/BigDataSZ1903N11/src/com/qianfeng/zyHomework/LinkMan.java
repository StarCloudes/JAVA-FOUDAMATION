package com.qianfeng.zyHomework;

public class LinkMan {
	private String name;
	private int age;
	private String sex;
	private String phoneNum;
	
	public LinkMan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkMan(String name, int age, String sex, String phoneNum) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phoneNum = phoneNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "LinkMan [name=" + name + ", age=" + age + ", sex=" + sex + ", phoneNum=" + phoneNum + "]";
	}
	
}
