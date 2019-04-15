package com.qianfeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class HomeWork2 {
	static String deesktop = "C:\\Users\\bihai\\Desktop\\";// 桌面
	public static void main(String[] args) {
		//exercise1(new File(deesktop + "show - 副本"));
		//exercise2(new File(deesktop + "show - 副本"));
		exercise3(new File("D:\\workspace\\BigDataSZ1903N21"));
	}

	/**
	 * 1.列出指定目录下满足指定条件的文件的清单，包括子目录(当前的工程目录)
	 * 
	 * @param path
	 */
	public static void exercise1(File path) {
		if (path.isDirectory()) {
			for (File each : path.listFiles()) {
				exercise1(each);
			}
		} else {
			System.out.println(path.getAbsolutePath());
			if (path.getName().endsWith(".png")) {// 如果包含就删除
				System.out.println(path.getName());
				path.delete();
			}

		}
	}

	/**
	 * 2.删除指定目录下的文件及文件夹，包括子目录中的内容(当前的工程目录)
	 * 
	 * @param path
	 */
	public static boolean exercise2(File path) {
		if (path.isDirectory()) {
			String[] children = path.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = exercise2(new File(path, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		System.out.println("目录：             " + path.getName());
		// 目录此时为空，可以删除
		return path.delete();
	}

	/**
	 * 3.将当前的工程目录中后缀名为.txt的文件找出,并将内容添加到名字叫zong.txt的文件中,并将该文件重新放到工程目录/day21/zuoye
	 * /third/下面.
	 * 
	 * @param path
	 */
	public static boolean exercise3(File path) {
		StringBuffer stringBuffer = new StringBuffer();
		if (path.isDirectory()) {
			for (File each : path.listFiles()) {
				exercise3(each);
			}
		} else {
			if (path.getName().endsWith(".txt")) {// 如果包含
				System.out.println(path.getName());
				BufferedReader bufferedReader = null;
				PrintWriter printWriter = null;
				try {
					bufferedReader = new BufferedReader(new FileReader(path));// 读
					File file = new File(deesktop + "zong.txt");
					System.out.println("文件是否存在：      " + file.exists());
					if (file.exists()) {
						file.createNewFile();
					}
					printWriter = new PrintWriter(new FileWriter(file, true));// 打印流
//					while (bufferedReader.readLine()=null) {
//						
//					}
					printWriter.println(bufferedReader.readLine());// 写
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (bufferedReader != null) {
							printWriter.close();
							bufferedReader.close();
						}
					} catch (IOException e) {
						//
						e.printStackTrace();
					}
				}

			}
		}
		return true;
	}

}
