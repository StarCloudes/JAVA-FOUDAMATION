package com.qianfeng.test;
/*
 * 开发中的编码
 * 常用的字符集:一个汉字:GBK:2个字节       ISO8859-1:1个字节       utf-8:3个字节    unicode:2个字节(内部编码)
 * 
 * 说明:GBK,UTF-8是支持中文的,ISO8859-1不支持中文
 * 
 *  * 编码:
		 * byte[] getBytes() //对于中文  默认的格式
		使用平台的默认字符集将此 String 编码为 byte 序列，
		并将结果存储到一个新的 byte 数组中。 

		byte[] getBytes(Charset charset) 
		使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。 

		解码:
		String(byte[] bytes) //对于中文  默认是格式
		通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String。

		String(byte[] bytes, Charset charset) 
		通过使用指定的 charset 解码指定的 byte 数组，构造一个新的 String。
 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo7 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		//使用GBK编码,GBK解码
		String str1 = "你好";
		byte[] str1b = str1.getBytes("GBK");
		System.out.println(new String(str1b,"GBK"));//你好
		System.out.println(Arrays.toString(str1b));//[-60, -29, -70, -61]
		//使用utf-8编码,utf-8解码
		String str2 = "你好";
		byte[] str2b = str2.getBytes();
		System.out.println(new String(str2b));//你好
		System.out.println(Arrays.toString(str2b));//[-28, -67, -96, -27, -91, -67]
		//使用ISO8859-1编码,解码
		String str3 = "你好";
		byte[] str3b = str3.getBytes("ISO8859-1");
		System.out.println(new String(str3b,"ISO8859-1"));//??
		System.out.println(Arrays.toString(str3b));//[63, 63]
	}
}
