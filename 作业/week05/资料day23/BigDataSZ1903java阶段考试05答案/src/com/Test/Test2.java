package com.Test;

import java.util.Arrays;

//���ڸ�����������: ������ A :�� 1, 7, 9, 11, 13, 15, 17, 19:; ��
//���� b :�� 2, 4, 6, 8, 10�� ��������ϲ�Ϊ���� c ,����������
public class Test2 {
	public static void main(String[] args) {
		int[] a = {1, 7, 9, 11, 13, 15, 17, 19};
		int[] b = {2, 4, 6, 8, 10};
		System.out.println(Arrays.toString(getNewArr(a, b)));
	}
	public static int[] getNewArr(int[] a , int[] b ) {
		int[] newArr = new int[a.length + b.length];
		int i = 0;
		for (; i < a.length; i++) {
			newArr[i] = a[i];
		}
		for (int j = 0; j < b.length; j++) {
			newArr[i] = b[j];
			i++;
		}
		sort(newArr);
		return newArr;
	}
	public static void sort(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {
					a[j] = a[j] ^ a[j+1];
					a[j+1] = a[j] ^ a[j+1];
					a[j] = a[j] ^ a[j+1];
				}
			}
		}
	}
}
