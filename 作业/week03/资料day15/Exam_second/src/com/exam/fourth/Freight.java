package com.exam.fourth;

public class Freight extends Transport{
	private int capacity;
	private double mileage;
	private Owner owner;
	public Freight(String type, String color, double price, int capacity, double mileage, Owner owner) {
		super(type, color, price);
		this.capacity = capacity;
		this.mileage = mileage;
		this.owner = owner;
	}
	@Override
	void start() {
		System.out.println("货车载着"+capacity+"吨东西出发了");		
	}
	@Override
	void stop() {
		System.out.println("货车行驶了"+mileage+"里程之后到达了目的地开始卸货");
	}
	void show() {
		System.out.println("货车主人是："+owner.getName());
	}
}
