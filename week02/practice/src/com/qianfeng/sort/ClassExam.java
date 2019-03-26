package com.qianfeng.sort;

class Zombies{
	int height;
	int weight;
	Zombies baby = new Zombies();
	String kinds;
	String weapons;
	String name;
	boolean life;
	
	public void attack(String weapon) {
		System.out.println(kinds + "正在使用" + weapon + "攻击你");
	}
	
	public void getItsKind() {
		System.out.println(kinds+ "来了");
	}
	
	public void getItsBaby() {
		System.out.println(baby+ "僵尸宝宝");
	}
		
	public void getItslife() {
		if(!life)
		   System.out.println("僵尸" + name+ "快死了");
	}
	
	
}


public class ClassExam {
	public static void main(String[] args) {
		Zombies a = new Zombies();
		
		a.kinds = "大厉害";
		a.name = "小花";
		//a.baby = ;
	    a.getItsBaby();
		a.life = false;
		a.getItsKind();
		a.attack("锤子");
		a.getItslife();
		
	}
  
}
