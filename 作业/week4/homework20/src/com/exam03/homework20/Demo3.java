package com.exam03.homework20;

import java.util.Arrays;

//现在给出两个数组: ·数组 A :“ 1, 7, 9, 11, 13, 15, 17, 19:; 
//·数组 b :“ 2, 4, 6, 8, 10” 两个数组合
//并为数组 c ,按升序排列。

public class Demo3 {
	public static void main(String[] args) {
		int[] a = {1, 7, 9, 11, 13, 15, 17, 19};
		int[] b = {2, 4, 6, 8, 10};
		int[] c = new int[13];
		int i = 0,j = 0,z = 0; 
		while(true) {
			if(a[i] < b[j] && i < a.length-1 && j>a.length-1) {
				c[z] = a[i];
				i++;
			} else {
				c[z] = b[j];
				j++;
			}
			
			if(i>a.length-1) {
				c[z] = b[j];
				j++;
			}
			
			if(j>b.length-1) {
				c[z] = a[j];
				j++;
			}
			
            z++;	
			
			if(z > 13) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(c));
	}
}
