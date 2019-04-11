package com.qianfeng.test;

import java.io.FileWriter;
import java.io.IOException;

/*
 * IO流(input/output):作用:实现两个设备之间数据的传递
 * 
 * 设备:磁盘(硬盘),内存,键盘,文件,网络,控制台
 * 网络:当前主机之外的网上资源
 * 
 * 分类:
 * 根据操作的方式:输入流和输出流
 * 根据数据的类型:字节流和字符流
 * 
 * 字节流:传输的是字节,可以操作任意类型的数据     ------音频,视频,文件,图片等
 * 字符流:传输的是字节,不同点是在传输过程中加入了编码的操作,让我们的操作更方便------文本
 * 
  * 因内存为参考
 * 字节流:
 * 字节输入流:InputStream
 * 字节输出流:OutputStream
 * 
 * 字符流的两个父类:
 * 字符读入流(将数据输入内存):Reader
 * 字符写出流(将数据从内存取出):Writer
 * 
 * 实例:研究字符流
 * 以磁盘的数据存储为例,将数据写入文件
 * 分析:因为操作的是文本,所以使用字符流
 * 		写入文件-----写出流------FileWriter
 */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		//1.创建FileWriter的对象并关联对应的文件
		//注意点:
		//一:如果只写文件的名字,不写具体路径,默认路径是当前的工程
		//二:对于关联的文件,如果之前不存在,程序会自动创建一个,如果存在,会将原来的内容覆盖
		//三:可以自己指定路径,但是必须保证路径是真实存在的,否则报异常---FileNotFountException(系统找不到指定的路径。)
		FileWriter fileWriter = new FileWriter("test1.txt");
		//调用写入方法
		//注意点四:在执行write方法时,数据被临时放到了流对象的内部数组中,这个数组是一个字节数组,会默认去查编码表
		fileWriter.write("晨晨");
		//刷新---将临时数组中的数据放入磁盘
		//fileWriter.flush();
		//4.关闭流--两个功能:a:关闭流  b:刷新
		//第五个注意点:流对象使用完后必须关闭
		fileWriter.close();
		//第六个注意点:当流对象关闭之后,不能再进行操作,否则会报异常:Stream closed
		//fileWriter.write("haha");
	}
}
