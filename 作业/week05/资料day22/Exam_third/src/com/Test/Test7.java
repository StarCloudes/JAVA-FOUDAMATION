package com.Test;
//��Ʒ���, ʵ������: ���100�������е�����
public class Test7 {
	public static void main(String[] args) {
		getZs();
	}
	public static void getZs() {
		int num = 100;
		for(int i = 1; i <= num; i++) {
			
			int j = 2;
			
			for(; j < i/2; j++) {
				if(i % j == 0 ) break;
			}
			
			if(j == i/2 || i == 1 || i == 2) {
				System.out.println(i);
			}
			
		}
	}
}
