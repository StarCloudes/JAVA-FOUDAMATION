package com.qianfeng.test;
/*
 * 拆箱:从包装类对象中取出简单数据类型数据的过程
 * 装箱:将数据装入对应的包装类对象的过程
 * 
 * 明天:
 * 1.字符串
 * 	String  不可变字符串
 * 	StringBuilder/StringBuffer  可变字符串
 * 2.网址
 * 3.Date
 * 4.Math
 * 5.修饰符
 */
public class Demo12 {
	public static void main(String[] args) {
		//装箱
		int a = 5;
		Integer integer = new Integer(a);
		System.out.println(integer);//重写了toString
		//拆箱
		int aa = integer.intValue();
		short aaa = integer.shortValue();//方法内部进行了强制类型转换
		System.out.println(aaa);
		
		//从jdk1.5开始可以实现自动拆箱,装箱
		Integer integer2 = new Integer(6);
		//先对integer2进行了自动拆箱,取出了6,然后跟4相加得到10.又进行的自动装箱
		Integer integer3 = integer2+4;
		System.out.println(integer3);
		
		//注意点:
		//注意点:在一个字节范围内前面定义好的,后面再定义,直接使用前面的.
//		Integer integer4 = 100;
//		Integer integer5 = 100;
//		System.out.println(integer4 == integer5);
		//如果超过了一个字节的范围,就认为是两个数,要独立占用两块儿内存空间.
		Integer integer4 = 1000;
		Integer integer5 = 1000;
		System.out.println(integer4 == integer5);
	}
}
