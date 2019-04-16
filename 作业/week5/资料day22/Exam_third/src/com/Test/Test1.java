package com.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中
public class Test1 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Hello.txt"));
		bufferedWriter.write("HelloJavaWorld你好世界");
		bufferedWriter.close();
	}
}
