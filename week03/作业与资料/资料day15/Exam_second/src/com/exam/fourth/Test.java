package com.exam.fourth;

/*
 * 4.����һ����ͨ������Transport��Ϊ���� 
 * 1)���ԣ����͡���ɫ���۸� 
 * 2)������������ֹͣ�ķ��� 3)��������̳���Transport�� 
 * ������Freight Freight�Լ������ԣ��ػ��� ����̣�Owner owner�������ߣ� 
 * Freight��д�������������������XXX�ֶ��������ˣ���ֹͣ��������ʽ��XXXX���֮�󵽴���Ŀ�ĵؿ�ʼж�����ķ��� 
 * ����һ��show()������ӡ ��������������XXX���ó���ʻ������� ���ػ��� 
 * ������Ҫ��װһ��Ownerʵ���ࣺ ���ԣ�name age sex ������set/get 4)
 * ���������࣬�ֱ������Ϲ��������������Ķ��󣬲���ֵ����������������ֹͣ�ķ������۲��䲻ͬ��
 */
public class Test {
	 public static void main(String[] args) {
			Freight freight = new Freight("����", "��ɫ",100.0,1000,7.5,new Owner("����", 23, 1));
			Bus bus = new Bus("������", "��ɫ",2.0,60,30.2,new Owner("����", 43, 1));
			freight.start();
			freight.stop();
			freight.show();
			bus.start();
			bus.stop();
			bus.show();
		}
}
