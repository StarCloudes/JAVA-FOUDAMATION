package com.qianfeng.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符缓冲流(字符缓冲区)
 * 
 * 定义:为了提高读写的能力,本身没有读写的能力,要想进行读写就必须借助于字符流实现.
 * 
 * 可以将缓冲流类比于催化剂或者高速的小车
 * 
 * 字符缓冲流分类:
 * 字符缓冲读入流:BufferedReader   没有读的能力
 * 字符缓冲写出流:BufferedWriter   没有写的能力
 */
public class Demo7 {
    public static void main(String[] args) throws IOException {
		//先研究字符缓冲写出流
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test3.txt"));
    	
    	//进行写操作
    	bufferedWriter.write("bingbing");
    	//windows系统   换行符   \r\n    linux/unix  换行符   \n
    	//bufferedWriter.write("\r\n");//换行
    	bufferedWriter.newLine();//换行---可以跨平台
    	//System.out.println();//换行---默认当输入到控制台时换行
    	bufferedWriter.write("chenchen");
    	
    	//关闭缓冲流,同时会自动将写出流关闭,同时自动刷新
    	bufferedWriter.close();
	}
}
