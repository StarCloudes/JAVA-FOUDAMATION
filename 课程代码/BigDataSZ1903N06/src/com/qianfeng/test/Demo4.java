package com.qianfeng.test;
/*
 * 一维数组:直接存储了一组数的数组
 * 二维数组:直接存储的是多个一维数组(的地址)的数组
 * 
 * 数组的空间都是连续的,并且是固定的.
 */
public class Demo4 {
	public static void main(String[] args) {
		//创建二维数组
		//组成:new + 数据类型+[一维数组的个数]+[每个一维数组中元素的个数]
		//注意点:第一个[]中的数不能省,第二个[]中的数可以省略.写了,代表每个一维数组中元素的个数.不过这个数是一个估值.
		int[][] arr = new int[4][4];
		
		//赋值
		arr[0] = new int[4];
		arr[1] = new int[3];
		arr[2] = new int[6];
		
		arr[0][0] = 4;
		
		//遍历
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		//另外的创建方式
//		new int[] {4,5,6}; 这种方式二维数组没有
		//有这种
		int[][] arr2 = {{4,5},{5,6,7}};
	}
}
