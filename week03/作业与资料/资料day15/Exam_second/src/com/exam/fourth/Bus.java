package com.exam.fourth;

public class Bus extends Transport{
	private int capacity;
	private double mileage;
	private Owner owner;
	public Bus(String type, String color, double price, int capacity, double mileage, Owner owner) {
		super(type, color, price);
		this.capacity = capacity;
		this.mileage = mileage;
		this.owner = owner;
	}
	@Override
	void start() {
		System.out.println("����������"+capacity+"�˳�����");		
	}
	@Override
	void stop() {
		System.out.println("��������ʻ��"+mileage+"���֮�󵽴���Ŀ�ĵؿ�ʼ�³�");
	}
	void show() {
	System.out.println("�������������ǣ�"+owner.getName());
	}
}
