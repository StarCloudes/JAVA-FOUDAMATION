package com.classroom.homework19;

import java.io.FileWriter;
import java.io.IOException;

//写出 输出流
public class Demo1 {
	public static void main(String[] args) {
//		FileWriter fWriter = new FileWriter("test1.txt");
//		fWriter.write("chenchen");//数据被临时放在流对象的的内部数组里
//		//fWriter.flush(); //数据放入磁盘
//		fWriter.append(" bingbing");
//		fWriter.write(" caicai");
//		fWriter.close();   //刷新并关闭文件
		
		//文件的续写 
		FileWriter fWriter2 = null;
		
		try {
			fWriter2 = new FileWriter("test1.txt",true);
          	fWriter2.write(" dada");
          	
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			if(fWriter2 != null) {
				try {
					fWriter2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	}

}
