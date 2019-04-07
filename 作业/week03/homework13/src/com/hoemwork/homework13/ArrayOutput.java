package com.hoemwork.homework13;

//出现一个奇数
public class ArrayOutput {
	public static void main(String[] args) {
		int[] a = {1,4,6,1,6};
		FindData(a,a.length);
	}
	
	public static int FindData(int arr[], int len)
	{
	    int num = arr[0];
	    for (int i = 1; i < len; i++)
	    {
	        num ^= arr[i];
	    }
	    System.out.println(num);
	    return num;
	}

}
