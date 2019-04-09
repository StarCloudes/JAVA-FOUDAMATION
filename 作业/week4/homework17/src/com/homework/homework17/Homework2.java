package com.homework.homework17;

//总经理今天很忙
//任务清单:
//开除那个不靠谱的副总经理;
//给各部门总监开会;
//陪VIP客户吃饭,打牌,KTV,桑拿,按摩...;
//去香港给妻子买个6 Plus作为生日礼物;
//去机场接女儿送到公司旁边的希尔顿饭店休息;
//陪老妈去医院看腰间盘突出;
//辅导儿子做作业
//请帮助总经理用多线程的方式完成今天的任务

public class Homework2 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("开除那个不靠谱的副总经理");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("给各部门总监开会");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("陪VIP客户吃饭,打牌,KTV,桑拿,按摩...");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("去香港给妻子买个6 Plus作为生日礼物");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("去机场接女儿送到公司旁边的希尔顿饭店休息");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("陪老妈去医院看腰间盘突出");
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("辅导儿子做作业");
			}
		}).start();
	}

}
