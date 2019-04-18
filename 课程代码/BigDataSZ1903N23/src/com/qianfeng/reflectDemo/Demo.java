package com.qianfeng.reflectDemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * 我们运行笔记本
 * 使用鼠标
 * 使用键盘
 * 
 * 再添加音响,U盘
 * 
 * 
 * 总结:通过反射可以在不改变功能类(Demo)的前提下,实现新增功能的添加,我们只需要创建对应的工具类(UPan,Mouse等).
 * 再通过一个配置文件进行简单的配置即可.
 * 
 * 
 * 明天内容:
 * 1.课程总结
 * 2.动态代理
 * 3.其他知识讲解
 * 4.作业讲解
 * 5.自己复习
 */
public class Demo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		//测试
//		Mouse mouse = new Mouse();
//		Keyboard keyboard = new Keyboard();
		NoteBook noteBook = new NoteBook();
		
		noteBook.run();
//		noteBook.useMouse(mouse);
//		noteBook.useMouse(keyboard);
		
		//利用反射实现在不改变当前类的代码前提下,实现新增功能的添加
		//先读取properties文件
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		//properties.size():键值对的个数
		for (int i = 0; i < properties.size(); i++) {
			String key = "usb"+i;
			String value = properties.getProperty(key);
			//利用反射
			Class<?> class1 = Class.forName(value);
			USB usb = (USB)class1.newInstance();
			usb.startUse();
			usb.endUse();
		}
		
		char[] arr = new char[4];
		arr[0] = 444;
		System.out.println(arr);
	}
}
