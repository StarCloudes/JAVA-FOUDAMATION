package com.qianfeng.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Demo5 {
	public static void main(String[] args) throws IOException {
		/*
		 * 内存流(byte数组流):
		 * ByteArrayInputStream:写入内存,在内部有一个数组,数据被放在这里面
		 * ByteArrayOutputStream:将数据取出,放在字节数组里面
		 */
		
		//创建输入流,关联一个byte型的数组,作为缓冲区数据
		ByteArrayInputStream bais = new ByteArrayInputStream("hello world".getBytes());
		
		//创建输出流-不需要指定参数
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		byte[] arr = new byte[1024];
		int num;
		while ((num = bais.read(arr)) != -1) {
			baos.write(arr, 0, num);
		}
		
		System.out.println(new String(arr));
		
		bais.close();
		baos.close();
		
		//注意:将流关闭了之后,还可以调用方法,不会报错.
		baos.write(45);
	}
}
