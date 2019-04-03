package com.qianfeng.lianxi;
/*
 * 早晨默写
 */
public class Demo1 {
	public static void main(String[] args) {
		
	}
	
	public String test1() {
		String string = "hello world";
		StringBuffer sBuffer = new StringBuffer(string);
		for (int i = 0,j = sBuffer.length()-1; i < j; i++,j--) {
			char a = sBuffer.charAt(i);
			char b = sBuffer.charAt(j);
			sBuffer.setCharAt(i, b);
			sBuffer.setCharAt(j, a);
		}
		
		String string2 = sBuffer.toString();
		return string2;
	}
	
	public String test2() {
		String string = "hello world";
		char[] arr = string.toCharArray();
		for (int i = 0,j=arr.length-1; i < j; i++,j--) {
			//这里是强转
			arr[i] ^=  arr[j];
			arr[j] = (char)(arr[i] ^ arr[j]);
			arr[i] = (char)(arr[i] ^ arr[j]);
		}
		return new String(arr);
	}
}
