package com.exam.seventh;

import java.util.Scanner;

/*
 * 设计方法, 实现需求: 从控制台输入一个整型数字, 计算这个数字的二进制原码(只考虑正数)
 */
public class Demo {
	public static void main(String[] args) {
		System.out.println("please input a number:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String result = method1(n);
		System.out.println(result);
		
		String result2 = method2(n);
		System.out.println(result2);
	}
	
	static String method1(int n) {
		String result = "";
		while(true){
            int remainder = ( n % 2 == 0) ? 0 : 1;
            //将余数保存在结果中
            result = remainder + result;
            n /= 2;
            if(n == 0){
                break;
            }
        }
		for (int i = 0; i < 32-result.length(); i++) {
			result = 0 + result;
		}
		return result;
	}
	
	static String method2(int n) {
		String result = "";
		 while (n > 0) {
	         int t = n % 2;
	         result = String.valueOf(t) + result;
	         n = n / 2;
	     }
		 for (int i = 0; i < 32-result.length(); i++) {
				result = 0 + result;
			}
		 return result;
	}
}
