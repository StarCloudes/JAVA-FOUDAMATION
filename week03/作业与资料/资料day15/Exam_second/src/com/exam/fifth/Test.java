package com.exam.fifth;
/*
 * 5.�ӿ� ����һ������ΪVehicle�Ľӿ� �ڽӿ��������������һ�������ķ���start()��stop()��
 * ���������Ʒֱ�ΪBike��Bus������ʵ��Vehicle�ӿڡ�
 * ����һ������ΪinterfaceDemo���� ��interfaceDemo��main()�����д���Bike��Bus���� ������start()��stop()����
 */
public class Test {
	public static void main(String[] args) {
		Bike bike = new Bike();
		Bus bus = new Bus();
		bike.start();
		bike.stop();
		bus.start();
		bus.stop();
	}
}
