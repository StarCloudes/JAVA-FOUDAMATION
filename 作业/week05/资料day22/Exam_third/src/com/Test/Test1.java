package com.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//�ڳ�����дһ��"HelloJavaWorld�������"���������ϵͳ�ļ�Hello.txt�ļ���
public class Test1 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Hello.txt"));
		bufferedWriter.write("HelloJavaWorld�������");
		bufferedWriter.close();
	}
}
