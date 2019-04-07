package com.qianfeng.homework10;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		
		int[]a = {11,22,1,33,1,1,44,55,66,1,77,1,1,88};
		int num=0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=1)
				num++; //获取当前非1数组的元素个数
		}
		
		int[] b = new int[num];
		
		for(int i=0,n = 0;i<a.length;i++)
		{
			if(a[i]!=1)
				b[n++] = a[i]; 
		}
		
		System.out.println(Arrays.toString(b));

	}

}
