package com.qianfeng.homework;

import java.util.Scanner;

public class DVDStore {

	public static void main(String[] args) {
		DVDManager dvd = new DVDManager();
		dvd.init();
		Menu.showMenu(dvd);
		
	}

}

class Menu {
	// 主界面显示
	public static void showMenu(DVDManager dvd) {
		System.out.println("\t欢迎使用迷你DVD管理器");
		System.out.println("------------------------------------");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退出DVD");
		System.out.println("------------------------------------");

		choiceDVD(dvd);
	}

	public static void choiceDVD(DVDManager dvd) {
		System.out.print("请选择: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		switch (input) {
		case 1:
			dvd.addDVD();
			backMenu(dvd);
			break;

		case 2:
			dvd.getDVD();
			backMenu(dvd);
			break;

		case 3:
			dvd.deleteDVD();
			backMenu(dvd);
			break;

		case 4:
			dvd.borrowDVD();
			backMenu(dvd);
			break;
		case 5:
			dvd.returnDVD();
			backMenu(dvd);
			break;
		case 6:
			dvd.exitDVD();
			backMenu(dvd);
			break;
		}
	}

	public static void backMenu(DVDManager dvd) {
		System.out.print("请输入0返回: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("");
			showMenu(dvd);
		} else {
			System.out.println("输入错误！");
		}
	}
}

class DVD {
	private String name;
	private int state;
	private String date;
	private int count;

	public DVD(String name, int state, String date, int count) {
		this.name = name;
		this.state = state;
		this.date = date;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

}

class DVDManager {
	public DVD[] dvds = new DVD[5];

	public void init() {
		dvds[0] = new DVD("罗马假日", 0, "2010-7-1", 15);
       
	}

	public void addDVD() {
		System.out.println("---->新增DVD");
		System.out.println("-----------------------------------");
	}

	public void getDVD() {
		String name = dvds[0].getName();
		System.out.println("---->查看DVD");
		System.out.println("-----------------------------------");
		System.out.println(name);
	}

	public void deleteDVD() {
		System.out.println("---->删除DVD");
		System.out.println("-----------------------------------");
	}

	public void borrowDVD() {
		System.out.println("---->借出DVD");
		System.out.println("-----------------------------------");
	}

	public void returnDVD() {
		System.out.println("---->归还DVD");
		System.out.println("-----------------------------------");
	}

	public void exitDVD() {
		System.out.println("---->退出DVD");
		System.out.println("-----------------------------------");
	}

}
