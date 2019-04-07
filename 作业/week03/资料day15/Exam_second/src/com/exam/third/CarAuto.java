package com.exam.third;

public class CarAuto extends Auto{
	private int airCondition;
	private int cd;
	
	public CarAuto() {
		super();
	}
	public CarAuto(int tireNums, String color, double weight, double speed) {
		super(tireNums, color, weight, speed);
	}
	public CarAuto(int airCondition, int cd) {
		super();
		this.airCondition = airCondition;
		this.cd = cd;
	}
	@Override
		public void speedUp() {
			speed += 2;
		}
	@Override
		public void speedDown() {
			speed -= 2;
		}
}
