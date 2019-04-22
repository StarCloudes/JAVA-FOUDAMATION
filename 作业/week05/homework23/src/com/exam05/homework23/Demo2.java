package com.exam05.homework23;

//将一个给定的整型数组转置输出, 例如:源数组, 1 2 3 4 5 6 转置之后的数组, 6 5 4 3 2 1
public class Demo2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6};
		for (int i = arr.length - 1; i >= 0 ; i--) {
			System.out.print(arr[i]);
		}
	}

}
