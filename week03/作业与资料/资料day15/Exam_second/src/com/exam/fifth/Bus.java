package com.exam.fifth;

public class Bus implements Vehicle{
	@Override
	public void start() {
		System.out.println("公交车开车");
	}

	@Override
	public void stop() {
		System.out.println("公交车停车");
	}
}
