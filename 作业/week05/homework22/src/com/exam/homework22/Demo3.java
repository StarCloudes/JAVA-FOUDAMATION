package com.exam.homework22;

//声明一个char型的数组，在此数组的单元格中放入”我爱你”三个字符，
//然后使用循环将它反序输出。如”你爱我”
public class Demo3 {
	public static void main(String[] args) {
		char[] arr = {'我','爱','你'};
		for(int i = arr.length -1 ; i>=0; i--) {
			System.out.print((char)arr[i]);
		}
	}

}
