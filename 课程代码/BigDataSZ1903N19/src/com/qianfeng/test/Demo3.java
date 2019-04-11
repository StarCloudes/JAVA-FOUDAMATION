package com.qianfeng.test;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 文件的续写:FileWriter(String file,boolean value)
 * 当value位true的时候,不会将原来的内容覆盖,会接着写
 */
public class Demo3 {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("test2.txt", true);
			fileWriter.write("lisi");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
