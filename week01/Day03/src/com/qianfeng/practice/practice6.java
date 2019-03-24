package com.qianfeng.practice;
import java.util.Scanner;

//判断闰年
//输入一个年份，判断是否是闰年(能被4整除并且不能被100整除或
//能被400整除的就是闰年？
public class practice6 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入年份：");
    	int year = sc.nextInt();
    	if( (year % 4 == 0 && year % 100 != 100) || year % 400 == 0 ) {
    		System.out.println("该年是闰年");
    	}
    	else {
    		System.out.println("该年不是闰年");
    	}
    	
    }
}
