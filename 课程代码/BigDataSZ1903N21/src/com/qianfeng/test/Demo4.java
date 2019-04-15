package com.qianfeng.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo4 {
	/*
	 * 数据流:字节流
	 * DataInputStream:  数据输入流
	 * DataOutputStream:  数据输出流
	 * 
	 * 注意:数据流要与字节输入流,输出流配合使用
	 */
	public static void main(String[] args) throws IOException {
		
		//写
		writeData();
		
		//读
		readData();
	}
	
	public static void writeData() throws IOException {
		DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("temp3.txt"));
		
		//写
		dataOutputStream.writeInt(97);//4个字节      00000000 00000000 000000000 011000001  00000001
		dataOutputStream.writeBoolean(true);//1个   
		dataOutputStream.write(33);//1个
		dataOutputStream.writeDouble(34.56);//8个
		
		//关闭流
		dataOutputStream.close();
	}
	
	public static void readData() throws IOException {
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream("temp3.txt"));
		
		//这里的boolean型和int型的数据,在读的时候由于与之前写的顺序相反了,所以读取的数据错误
		/*
		 * 注意点:1.读的顺序要与写的顺序一致   2.类型保持一致
		 */
		System.out.println(dataInputStream.readBoolean());// 00000000
		System.out.println(dataInputStream.readInt());//00000000 000000000 011000001  00000001
		
		System.out.println(dataInputStream.readByte());
		System.out.println(dataInputStream.readDouble());
		
		dataInputStream.close();
	}
	
	
}
