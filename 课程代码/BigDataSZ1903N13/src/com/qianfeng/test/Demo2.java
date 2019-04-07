package com.qianfeng.test;
/*
 * 1.字符串的基础
 * 2.不可变字符串的常用方法
 * 3.可变字符串的常用方法
 * 4.网址
 */
public class Demo2 {
	public static void main(String[] args) {
		//字符串的基础
		//什么叫字符串:String类.java将与字符串相关的功能面向对象了,形成了对应的类--字符串类,表示方法是:""
		//分类:
		//不可变字符串:----String.字符串本身不能发生改变,与指向字符串的引用无关.
		//可变字符串:----StringBuilder/StringBuffer.字符串本身可以发生变化,与指向可变字符串的引用无关
		
		//学习不可变字符串:---直接使用"",创建的不可变字符串
		//对于不可变字符串本身是一个常量,保存在常量区.是存储在了堆区中一块儿特殊的区域里.
		//字符串常量的特点:同一个字符串常量在常量区只允许存储一个.
		String s = "1000phone";//不可变字符串
		StringBuffer stringBuffer = new StringBuffer("1000phone");//可变字符串
		
		/*
		 * 当执行s1的时候,会到常量区找叫1000phone的字符串,如果有直接让s1保存他的地址,如果没有,会在常量区开辟一块儿
		 * 空间存1000phone.
		 * 执行s2是同理s1
		 * 执行s3时,由于进行了new,一定会现在堆中开辟一块儿空间,而1000phone是作为参数传给了对象.保存在了对象的一个String
		 * 类型的成员变量内,所以直接判断s1与s3不相同.
		 * 执行s4同理s3
		 */
		String s1 = "1000phone";
		String s2 = "1000phone";
		String s3 = new String("1000phone");
		String s4 = new String("1000phone");
		
		System.out.println(s1 == s2);//true
		System.out.println(s1 == s3);//false
		System.out.println(s3 == s4);//false
		
		//使用equals
		//String默认重写了Object的equals方法,重新制定了比较规则,变成了让s1与s3属性的地址比较
		System.out.println(s1.equals(s3)); //true
		System.out.println(s1.contains(s3)); 
		//总结:以后尽量使用equals进行String的比较
	}
}
