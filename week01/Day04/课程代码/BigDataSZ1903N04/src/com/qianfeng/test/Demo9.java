package com.qianfeng.test;

//导入头文件
import java.util.Scanner;

public class Demo9 {
	public static void main(String[] args) {
		/*
		 * 函数
		 * 
		 * 求两个数的和
		 * 
		 函数的构成:
		 * 修饰词  返回值类型   函数名(参数列表){
		 * 		函数的功能代码;
		 * 		return  返回值;
		 * }
		 * 修饰词:限定当前函数的可见范围的,暂时先忽略
		 * 返回值类型:可以有,也可以没有
		 * 函数名:必须有,命名规则:遵循小驼峰原则(当有多个单词组成名字的时候,除第一个单词外,所有单词的首字母大写)
		 * 函数名:要做到见名知意
		 * 参数列表:1.可以有,可以没有  2.如果有,可以有一个或多个,多个参数之间以,隔开
		 * return 返回值; 这里是一个动作,后面放的是要返回的数据,要求:返回值类型要与return后面的类型一致
		 * 			注意点:return后面只能放一个数据
		 * 			特点:有结束的意思
		 * 
		 * 注意:函数之间可以调用,但是不能嵌套
		 */
		//函数的调用:函数功能的发挥必须通过调用实现
		//函数调用规则:函数名+()
		sum1();
		sum1();
		sum1();
	}
	
	//函数的定义:装功能代码的地方
	//
	static void sum1(){
		Scanner scanner = new Scanner(System.in);//可以通过它接收用户的信息
		System.out.println("请输入第一个数:");
		int num1 =  scanner.nextInt();
		System.out.println("请输入第二个数:");
		int num2 =  scanner.nextInt();
		int sum = num1 + num2;
		System.out.println("sum:"+sum);
	}
}
