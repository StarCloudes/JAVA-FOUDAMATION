package com.exam.third;

public class Auto {
	protected int tireNums;
	protected String color;
	protected double weight;
	protected double speed;
	public Auto() {	}
	public Auto(int tireNums, String color, double weight, double speed) {
		super();
		this.tireNums = tireNums;
		this.color = color;
		this.weight = weight;
		this.speed = speed;
	}
	
	public void speedUp() {
		speed += 1;
	}
	public void speedDown() {
		speed -= 1;
	}
	public void stop() {
		speed = 0;
	}
}
