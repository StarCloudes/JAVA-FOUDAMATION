package com.qianfeng.homework10;

import java.util.Arrays;
import java.util.Random;

public class Demo4 {

	public static void main(String[] args) {
		
		Random r=new Random();
		int[] aa=new int[10];
		for(int i=0;i<10;i++)
		{
			aa[i]=r.nextInt(221)+2;  //随即整数0～220
		}
		System.out.println(Arrays.toString(aa));
	}

}

