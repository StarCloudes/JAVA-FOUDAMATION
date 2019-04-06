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
		System.out.println("公交车载着"+capacity+"人出发了");		
	}
	@Override
	void stop() {
		System.out.println("公交车行驶了"+mileage+"里程之后到达了目的地开始下车");
	}
	void show() {
	System.out.println("公交车车主人是："+owner.getName());
	}
}
