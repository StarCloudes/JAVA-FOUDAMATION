package com.qianfeng.test;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * 中文乱码出现的情况研究
 * 注意点:乱码解决的办法是再编码再解码
 * 但是如果是编码出错了,无法解决.如果是解码出错了,可以利用再编码再解码
 * 
 * 
 * 编码 					解码  				结果
 * GBK					utf8				不可以(GBK2个字节,utf83个字节)
 * GBK					ISO8859-1   	        可以
 * utf8					GBK					有时可以
 * utf8					ISO8859-1			可以
 * ISO8859-1			GBK                 不可以(编码就出错了)   
 * ISO8859-1			utf8				不可以(编码就出错了)
 */
public class Demo8 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//1.GBK编码         utf8解码
//		String s1 = "你好";
//		byte[] s1b = s1.getBytes("GBK");
//		String sr1b = new String(s1b,"utf-8");
//		System.out.println("utf8解码:"+sr1b);//???
//		
//		//再编码
//		byte[] s1bb = sr1b.getBytes("utf-8");
//		//再解码
//		System.out.println("GBK再编码:"+new String(s1bb,"GBK"));//锟斤拷锟?
	
		
		//2.GBK编码         ISO8859-1解码
//		String s1 = "你好";
//		byte[] s1b = s1.getBytes("GBK");
//		String sr1b = new String(s1b,"ISO8859-1");
//		System.out.println("ISO8859-1解码:"+sr1b);//????
//		
//		//再编码
//		byte[] s1bb = sr1b.getBytes("ISO8859-1");
//		//再解码
//		System.out.println("GBK再编码:"+new String(s1bb,"GBK"));//你好
		
		//3.utf8编码         GBK解码
		String s1 = "你好啊";
		byte[] s1b = s1.getBytes("utf-8");
		String sr1b = new String(s1b,"GBK");
		System.out.println("GBK解码:"+sr1b);//浣犲ソ鍙?
		
		//再编码
		byte[] s1bb = sr1b.getBytes("GBK");
		//再解码
		System.out.println("utf8再编码:"+new String(s1bb,"utf-8"));//你好??
		//4.utf8编码         ISO8859-1解码
//		String s1 = "你好号";
//		byte[] s1b = s1.getBytes("utf-8");
//		String sr1b = new String(s1b,"ISO8859-1");
//		System.out.println("ISO8859-1解码:"+sr1b);//????????·
//		
//		//再编码
//		byte[] s1bb = sr1b.getBytes("ISO8859-1");
//		//再解码
//		System.out.println("utf8再编码:"+new String(s1bb,"utf-8"));//你好号
		
	}
	
	
}

