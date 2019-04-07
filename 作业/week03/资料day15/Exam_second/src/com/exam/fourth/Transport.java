package com.exam.fourth;

public abstract class Transport {
	private String type;
	private String color;
	private double price;
	public Transport(String type, String color, double price) {
		super();
		this.type = type;
		this.color = color;
		this.price = price;
	}
	abstract void start();
	abstract void stop();
}
