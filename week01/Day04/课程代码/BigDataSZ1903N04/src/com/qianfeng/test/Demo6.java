package com.qianfeng.test;

import java.time.Month;

public class Demo6 {
	public static void main(String[] args) {
		/*
		 * 分支语句:switch case
	     * switch(n){
		 * 	case 1:
		 * 		执行语句1;
		 * 		break;
		 * 	case 2:
		 * 		执行语句2;
		 * 		break;
		 *  defalut:
		 *  	执行语句n
		 *      break;
		 * }
		 */
		
		//实例展示
		//case后面只能是一个数字或者字母或者字符串
		//break:默认是结束switch的意思.
		//如果不写break,执行完当前的case会继续执行后面的case,不会跳出switch.一直到遇到break跳出switch,
		//或者将所有的内容执行完自然结束,我们将这种行为成为break的穿透性.
		//注意点:1.可以在case后面加{}
		//2.switch后面的()中可以放入的内容:整型,字符,字符串,枚举.字符串是在jdk1.8开始可以使用的.
		int month = 14;
		switch (month) {
		case 3:case 4:case 5:
		{
			System.out.println("春");
			System.out.println("ddd");
		}
			break;
		case 6:case 7:case 8:
			System.out.println("夏");
			break;
		case 9:case 10:case 11:
			System.out.println("秋");
			break;
		default:
			System.out.println("冬");
			break;
		}
	}
}
