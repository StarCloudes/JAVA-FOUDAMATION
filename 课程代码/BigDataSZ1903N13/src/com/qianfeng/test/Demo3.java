package com.qianfeng.test;

import java.util.Arrays;

/*
 * 2.不可变字符串的常用方法
 */
public class Demo3 {
	public static void main(String[] args) {
		String s1 = "1000phone";
		//1.判断：
	    //判断是否包含一个子字符串
		//boolean contains(CharSequence s) 
		System.out.println(s1.contains("1000"));//true
	    //判断两个字符串的内容是否相同
		//boolean equals(Object anObject) 
		//String重写了这个方法,所以现在变成了判断内容
	    //忽略大小写判断两个字符串的内容是否相同
		//boolean equalsIgnoreCase(String anotherString) 
		System.out.println(s1.equalsIgnoreCase("1000PHONE"));//true
	    //判断是否以某字符串开头
		//boolean startsWith(String prefix)
		System.out.println(s1.startsWith("1000"));//true
		//判断是否以某字符串结尾
		//boolean endsWith(String suffix) 
		System.out.println(s1.endsWith("phone"));//true
		
		
	    //2.转换：将字符数组转换成字符串
		//1:使用构造方法
		//String(char[] value) 
		//String(char[] value, int offset, int count) 
		char[] arr1 = {'a','b','c','d'};
		String s4 = new String(arr1);
		System.out.println("s4:"+s4+"e");
		System.out.println("s44:"+new String(arr1,1,2));
		//2:使用静态方法
		//static String copyValueOf(char[] data) 
		//static String copyValueOf(char[] data, int offset, int count) 
		//将字符串转成字符数组
	    //char[] toCharArray() 
		char[] arr2 = s1.toCharArray();
		for (char c : arr2) {
			System.out.println("c:"+c);
		}
		//将字节数组转成字符串
	    //String(byte[] bytes) 如果没有指定编码,使用默认编码,可以通过选中当前的文件-查看属性获取
	    //String(byte[] bytes, int offset, int length)
	    //String(byte[] bytes, String charsetName)//使用指定的编码将字节数组转换成字符成
		byte[] arr3 = {97,98,99,100};
		String s5 = new String(arr3);
		System.out.println("s5:"+s5);
		//将字符串转成字节数组
	    //byte[] getBytes() 
		byte[] arr4 = "哈哈".getBytes();
		System.out.println("arr4:"+Arrays.toString(arr4));
		//将基本数据类型转换成字符串
	    //String.valueOf()
		 System.out.println(String.valueOf(1) + 1);
		
	    //3.替换：
		//String replace(char oldChar, char newChar) 
		
		System.out.println(s1.replace("1000", "ok")+"     s1:"+s1);
		//子串:
		//字符串类似于数组,下标从0开始
		//String substring(int beginIndex)  
		System.out.println(s1.substring(1));
	    //String substring(int beginIndex, int endIndex) //包含起始位置，不包含结束位置，到结束位置的前一位
		System.out.println(s1.substring(1, 4));
		//转换，去除空格，比较:
		//大小写转换
		//String toLowerCase() 
		String s2 = "PHONE";
		System.out.println(s2.toLowerCase());
	    //String toUpperCase()
		System.out.println(s1.toUpperCase());
	    //将字符串两端的空格去掉
		//注意:只能取出两边的空格
	    //String trim() 
		String s3 = "   hello world  ";
		System.out.println(s3.trim()+"a");
		
		//4.按字典顺序比较两个字符串
		/*
		 * 字典顺序:按照ASCII表比较当前的两个字符,ASCII码大的认为是大的字符
		 * 规则:从左边第一个字符开始比较
		 * 如果当前的字符不相同,直接认为ASCII大的字符串是大字符串,后面的字符停止比较
		 * 当前字符比较的具体规则:使用前面的字符-后面的字符,返回差值.如果是负数,说明前面的字符串小于后面的.反之前面的大.
		 * 如果当前的字符相同,再去比较第二个字符,依次往后推,如果比到最后都相同,则认为两个字符串相等,差值返回0.
		 */
	    //int compareTo(String anotherString)
		System.out.println(s1.compareTo("9000phone"));
		
		//5..切割: String[] split(String) 参数:刀,刀作为原字符串的一部分,作为刀后,就不会再被作为内容
		String s6 = "a,b,c,,d,e";
		String[] arr5 = s6.split(",");
		for (String string : arr5) {
			System.out.println("arr5:"+string);
		}
		String s7 = "abcde";
		String[] arr6 = s7.split("");
		for (String string : arr6) {
			System.out.println("arr6:"+string);
		}
		
		//获取单个字符
		char cha = s1.charAt(0);
	}
}
