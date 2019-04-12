package com.qianfeng.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 文件:File类,用来操作文件和路径(目录)
 * 
 * 创建文件
 * 创建路径
 * 创建多路径
 * 
 * 判断是否是文件
 * 判断是否是路径
 * 判断是否隐藏
 * 
 * 获取根目录(路径)
 * 获取指定目录下的文件或文件夹
 */
public class Demo8 {
	public static void main(String[] args) throws IOException{
		//创建File对象的方法
		//第一种:通过完整的路径创建
		File file = new File("D:\\workspace\\BigDataSZ1903N20\\src\\com\\qianfeng\\test\\Demo1.java");
		//第二种:通过父目录,子目录拼接
		File file2 = new File("D:\\workspace\\BigDataSZ1903N20", "src\\com\\qianfeng\\test\\Demo1.java");
		//第三种:先创建父目录的File对象
		File file3 = new File("D:\\workspace\\BigDataSZ1903N20");
		File file4 = new File(file3, "src\\com\\qianfeng\\test\\Demo1.java");
		//创建文件:当检查到当前文件已经存在,不会进行覆盖
		File file5 = new File("D:\\workspace\\BigDataSZ1903N20\\test1.txt");
		file5.createNewFile();
		//创建目录--只能创建目录
		File file6 = new File("D:\\workspace\\BigDataSZ1903N20\\a\\b\\c\\test.txt");
		//默认只能创建单层目录
		file6.mkdir();
		//创建多层目录
		file6.mkdirs();
		
		//判断是否是文件
		System.out.println(file2.isFile());//true
		System.out.println(file2.isDirectory());//false
		System.out.println(file2.isHidden());//false
		
		//获取最后的修改时间
		long time = file6.lastModified();
		System.out.println(time);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = simpleDateFormat.format(new Date(time));
		System.out.println(stringDate);
		
		System.out.println("***************************************");
		
		//获取根目录--获取的是当前主机的根目录
		File[] files = File.listRoots();
		for (File file7 : files) {
			System.out.println(file7);
		}
		System.out.println("***************************************");
		
		//获取指定目录下的文件或文件夹---1.不包含子文件夹  2.只得到了文件或文件夹的名字,没有全路径
		File file8 = new File("D:\\workspace\\BigDataSZ1903N20");
		String[] strings = file8.list();
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println("***************************************");
		
		//获取指定目录下的文件或文件夹的全路径
		File[] files2 = file8.listFiles();
		for (File file7 : files2) {
			System.out.println(file7);
		}
		
		//功能:作业:要求遍历当前目录下的所有文件----利用递归实现
	}
}
