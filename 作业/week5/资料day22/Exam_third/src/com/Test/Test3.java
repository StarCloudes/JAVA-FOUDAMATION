package com.Test;

import java.util.Arrays;

//���ڸ�����������: ������ A :�� 1, 7, 9, 11, 13, 15, 17, 19:; 
//������ b :�� 2, 4, 6, 8, 10�� ��������ϲ�Ϊ���� c ,���������С�
public class Test3 {
	public static void main(String[] args) {
		int[] a = {1, 7, 9, 11, 13, 15, 17, 19};
		int[] b = {2, 4, 6, 8, 10};
		System.out.println(Arrays.toString(getSumArr(a, b)));
	}
	public static int[] getSumArr(int[] a , int[] b) {
		int[] sum = new int[a.length+b.length];
		int i = 0;
		for(;i < a.length; i++) {
			sum[i] = a[i];
		}
		for (int j = 0; j < b.length; j++) {
			sum[i] = b[j];
			i++;
		}
		sort(sum);
		return sum;
	}
	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					arr[i] = arr[i] ^ arr[j];
					arr[j] = arr[i] ^ arr[j];
					arr[i] = arr[i] ^ arr[j];
				}
			}
		}
	}
}
