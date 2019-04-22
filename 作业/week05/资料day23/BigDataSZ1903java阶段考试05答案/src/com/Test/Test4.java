package com.Test;
//将一个给定的整型数组转置输出, 例如:源数组, 1 2 3 4 5 6 转置之后的数组, 6 5 4 3 2 1

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6};
		for (int i = 0,j=a.length-1; i <= j; i++,j--) {
			int temp = 0;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		System.out.println(Arrays.toString(a));
	}
	
}

