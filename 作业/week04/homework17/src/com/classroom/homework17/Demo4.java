package com.classroom.homework17;

//打印机模拟 
public class Demo4 {
	public static void main(String[] args) {
		Des des = new Des();
		Input input = new Input(des);
		Output output = new Output(des);
		Thread thread1 = new Thread(input);
		Thread thread2 = new Thread(output);
		thread1.start();
		thread2.start();
	}
}
class Des{
	String name;
	String sex;
	
}
class Input implements Runnable{
	Des des;
	
	public Input(Des des) {
		super();
		this.des = des;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		des.name = "Mike";
		des.sex = "man";
	}
}

class Output implements Runnable{
	Des des;
	
	public Output(Des des) {
		super();
		this.des = des;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("name: "+des.name+"    sex: "+des.sex);
	}

}