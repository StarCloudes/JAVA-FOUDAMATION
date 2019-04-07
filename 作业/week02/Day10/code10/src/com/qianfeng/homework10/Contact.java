package com.qianfeng.homework10;

interface Operation {
	public abstract Contact[] addLinkMan(Contact linkMan, Contact[] Linkmans);

	public abstract Contact[] deleteLinkManByName(Contact name, Contact[] Linkmans);

	public abstract Contact[] deleteLinkManByNumber(Contact number, Contact[] Linkmans);

	public abstract Contact[] setLinkMan(String name, String number, Contact[] Linkmans);

	public abstract Contact[] searchLinkMan(String name, Contact[] Linkmans);

	public abstract void searchAll(Contact[] Linkmans);

}

abstract class LinkMan implements Operation {

	private String name;
	private int year;
	private String sex;
	private String number;

	public LinkMan() {

	}

	public LinkMan(String name,int year,String sex,String number) {
       this.name = name;
       this.year = year;
       this.sex = sex;
       this.number= number;
	}

	
}


public class Contact{
	
	public static void main(String[] args) {
		
	}
	
}

