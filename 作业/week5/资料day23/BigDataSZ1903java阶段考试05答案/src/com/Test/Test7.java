package com.Test;

//��д���߳�Ӧ�ó���ģ������ͨ��һ��ɽ����ģ�⡣
//���ɽ��ÿ��ֻ��ͨ��һ���ˣ�ÿ����ͨ��ɽ����ʱ��Ϊ5�룬
//�������10���ˣ�ͬʱ׼������ɽ������ʾһ��ÿ��ͨ�� ɽ���˵�������
public class Test7 {
	public static void main(String[] args) {
		Pass pass = new Pass();
		Person person1 = new Person("����", pass);
		Person person2 = new Person("�ϴ���", pass);
		Person person3 = new Person("��׳׳", pass);
		Person person4 = new Person("Ҧ����", pass);
		Person person5 = new Person("�ľ�", pass);
		Person person6 = new Person("ʷ��ʢ", pass);
		Person person7 = new Person("���", pass);
		Person person8 = new Person("˾��", pass);
		Person person9 = new Person("����", pass);
		Person person10 = new Person("��Ԫ��", pass);
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

		System.out.println(name+"׼������ɽ��");
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"ͨ��ɽ��");
	}
}
