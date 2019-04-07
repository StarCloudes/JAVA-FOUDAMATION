package com.qianfeng.test;
/*
 * 包装类:专门将简单数据类型的数据进行封装,形成的对应的类.
* 简单数据类型		包装类
* byte				Byte
* short				Short
* int				Integer
* long				Long
* float				Float
* double			Double
* boolean 			Boolean
* char				Character
*/
public class Demo11 {
    public static void main(String[] args) {
//    	* 1.基本类型转成字符串类型
//        static String Integer.toString(int i)
//        static String Double.toString(double d)
    	String aString = Integer.toString(3);
    	System.out.println(aString+1);
//           字符串类型转基本类型
//        int     Integer.parseInt("23")
//    	double  Double.parseDouble("3.45")
    	//只能是数值型的字符串才能被转成简单数据类型
    	int b = Integer.parseInt("12345");
   
    	System.out.println(b+1);
//    	2.把十进制转成其它进制
//       Integer.toHexString()  转成十六进制
//       Integer.toOctalString()    八进制
//       Integer.toBinaryString()   二进制
    	System.out.println(Integer.toHexString(17));
    	System.out.println(Integer.toOctalString(17));
    	System.out.println(Integer.toBinaryString(17));
//    	3.把其它进制转十进制
//      	Integer.parseInt(数据,进制) 第一个参数:字符串形式的数据   第二个参数:转之前的进制
    	System.out.println(Integer.parseInt("1111",8));
	}
}
