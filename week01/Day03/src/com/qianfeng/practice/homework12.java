package com.qianfeng.practice;
import java.util.Scanner;

//判断n是不是一个质数（质数是只能被1和它自身整除的数）
public class homework12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数字");
		long num = sc.nextLong();
	    if (num <= 3) 
	    	System.out.println("请属于大于3的数");
	    
	    int sqrt = (int)Math.sqrt(num);
	    for (int i = 2; i <= sqrt; i++) {
	        if(num % i == 0) {
	        	System.out.println("该数不是一个质数");
	        	break;
	        }
	        else if(i >= sqrt)
	        	System.out.println("该数是一个质数");
	    }
	
	}
}
