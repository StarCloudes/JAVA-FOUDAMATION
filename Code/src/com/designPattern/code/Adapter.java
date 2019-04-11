package com.designPattern.code;

//适配器模式：将一个类的接口转换成客户希望的应外一个接口，适配器可以让它兼容。

public class Adapter {
    public static void main(String[] args) {
		PowerA powerA = new PowerAImp();
		work(powerA);
		
		PowerB powerB = new PowerBImp();
		PowerAdapter adapter = new PowerAdapter(powerB);
		work(adapter);
		
	}
    public static void work(PowerA a) {
		System.out.println("Connecting...");
		a.insert();
		System.out.println("Stop working");
		System.out.println();
	}
}

interface PowerA{
	public void insert() ;
}

interface PowerB{
	public void connect();
}

class PowerAImp implements PowerA{	
	public void insert() {
		System.out.println("PowerA is working....");		
	}
}

class PowerBImp implements PowerB{	
	public void connect() {
		System.out.println("PowerB is working....");		
	}
}

class PowerAdapter implements PowerA{
	private PowerB powerB;
	
	public PowerAdapter(PowerB powerB) {
		this.powerB= powerB;
	}
	@Override
	public void insert() { //重写不兼容的方法
		powerB.connect();		
	}
}
