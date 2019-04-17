package com.Test;

//编写多线程应用程序，模拟多个人通过一个山洞的模拟。
//这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
//随机生成10个人，同时准备过此山洞，显示一下每次通过 山洞人的姓名。
public class Test7 {
	public static void main(String[] args) {
		Pass pass = new Pass();
		Person person1 = new Person("韩冬", pass);
		Person person2 = new Person("毕传鑫", pass);
		Person person3 = new Person("李壮壮", pass);
		Person person4 = new Person("姚蕊蕊", pass);
		Person person5 = new Person("夏军", pass);
		Person person6 = new Person("史昌盛", pass);
		Person person7 = new Person("杨航天", pass);
		Person person8 = new Person("司翔", pass);
		Person person9 = new Person("刘浩", pass);
		Person person10 = new Person("段元淳", pass);
		person1.start();
		person2.start();
		person3.start();
		person4.start();
		person5.start();
		person6.start();
		person7.start();
		person8.start();
		person9.start();
		person10.start();
		
	}
}
class Person extends Thread{
	String name;
	Pass pass;
	public Person(String name, Pass pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	@Override
	public void run() {
		pass.passHole(name);
	}
}
class Pass {
	abstract class a{
		
	}
	public synchronized void passHole(String name ) {

		System.out.println(name+"准备进入山洞");
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"通过山洞");
	}
}
