package com.classroom.homework19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Demo6 {
	public static void main(String[] args) throws IOException {
		//write();
		//read1();
		read2();
		//read3();
	}

	public static void write() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("test5.txt");
		fileOutputStream.write("bingbing".getBytes());
		fileOutputStream.close();
	}

	//one byte
	public static void read1() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("test5.txt");
		int num = 0;
		while((num = fileInputStream.read()) != -1) {
			System.out.println((char)num);
		}
		fileInputStream.close();

	}

	//sevearl bytes
	public static void read2() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("test5.txt");
		byte[] arr = new byte[3];
		int num = 0;
		while((num = fileInputStream.read(arr)) != -1) {
			System.out.print(new String(arr,0,num));
		}
		fileInputStream.close();
	}

	//all bytes
	public static void read3() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("test5.txt");
		int value = fileInputStream.available();
		byte[] arr = new byte[value];
		fileInputStream.read(arr);
		System.out.println(new String(arr));
		fileInputStream.close();
	}
}
