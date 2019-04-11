package com.qianfeng.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * 模拟字符缓冲读入流:BufferedReader
 * 
 * 分析:
 * 1.要属于流的体系
 * 2.要有一个Reader类型的成员变量
 * 3.要有一个带参数的构造方法接收外部传入的流对象
 * 4.模拟readLine(),实现读一行的功能
 * 5.关闭流
 */
public class Demo10 {
	public static void main(String[] args) throws IOException {
		MyBufferedReader myBufferedReader = new MyBufferedReader(new FileReader("test3.txt"));
		
		String data = null;
		while ((data = myBufferedReader.readline()) != null) {
			System.out.println(data);
		}
		myBufferedReader.close();
	}
}

class MyBufferedReader extends Reader{
	Reader reader;
	public MyBufferedReader(Reader reader) {
		this.reader = reader;
	}
	public String readline() throws IOException {
		//a:准备临时的可变字符串用于存储一行数据
		StringBuffer stringBuffer = new StringBuffer();
		//b:使用read()读字符
		int num=0;
		while ((num = this.reader.read()) != -1) {
			if (num == '\r') {
				continue;
			}else if (num == '\n') {
				return stringBuffer.toString();
			}else {
				stringBuffer.append((char)num);
			}
		}
		
		//当文档是空的时候
		if (stringBuffer.length() == 0) {
			return null;
		}
		
		//当只有一行数据--没有换行符
		return stringBuffer.toString();
		
		//这里写提高效率的代码
	}	
	@Override
	public void close() throws IOException {
		//关闭流
		this.reader.close();
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
}

/*
 * 装饰设计模式:基于已经实现的功能,提供增强的功能.
 * 装饰设计模式的由来就来自于对缓冲流的实现.
 * 
 * 特点:从缓冲流的角度讲解
 * 1.使流原来的继承体更加的简单
 * 2.提高了效率
 * 3.由于是在原有的基础上提高增强的功能,所以他还要属于原来的体系
 * 
 * 演示:如果自己设计装饰设计模式,怎么处理?
 * 1.原来的类  Test---Reader
 * 2.装饰类   BTest----MyBufferedReader
 * 
 * 
 * 步骤:
 * 1.让BTest 继承自Test
 * 2.在BTest内有一个Test类型的成员变量
 * 3.通过BTest内一个带参数的构造方法接收外部传入的一个Test类型的对象,交给内部的Test的属性
 * 4.在实现功能的时候,调用传入的Test类型的对象实现原有的功能,自己实现增强的功能.
 * 
* 适配器设计模式:通常可以变相的理解成装饰设计模式
 * 实例:要求在子类中只使用play方法
 *
 * 分析:Dog是继承了ZiMidel类,ZiMidel类实现了Inter接口
 * 当Dog类想要实现Inter接口的一个方法的时候,如果直接实现Inter接口,就必须将所有的方法都实现,
 * 如果在Dog类与Inter接口之间插入一个类,让这个类去实现Inter接口的所有方法,作为这个类的子类只需要实现自己需要的方法
 * 
 * 我们将中间的这个类就可以成为适配器类
 * 
 */


interface Inter{
	public void play();
	public void song();
	public void run();
	public void eat();
	public void jump();
}
//适配器类
class ZiMidel implements Inter{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void song() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		
	}
	
}


//创建狗类,我只想让她实现play方法?
class Dog extends ZiMidel{
	public void play() {
		// TODO Auto-generated method stub
		
	}
}

class Cat extends ZiMidel{
	public void song() {
		
	}
}
