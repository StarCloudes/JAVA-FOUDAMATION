package com.hoemwork.homework20;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//3.将当前的工程目录中后缀名为.txt的文件找出,并将内容添加到名字叫zong.txt的文件中,
//并将该文件重新放到工程目录/day21/zuoye/third/下面.

public class Demo3 {
	public static void main(String[] args) throws IOException {

		File file = new File("/Users/star/code练习/java/JAVA-FOUDAMATION/作业/week4/homework20");
		
		//FileWriter fWriter = new FileWriter("text.txt");
		//fWriter.write("chenchen");
		
		FileWriter fWriter = new FileWriter("zong.txt");	
		String[] strings = file.list();
		for (String string : strings) {
			if(string.endsWith(".txt")) {
				FileReader fReader = new FileReader(string);
				
				char[] c = new char[2];
				int num;
				while((num = fReader.read(c)) != -1) {
				      fWriter.write(c,0,c.length);
				}
				 fReader.close();
			}
		}		
	   fWriter.close();
	   
	   File file2 = new File(file,"/day21/zuoye/third/");
	   file2.mkdirs();
	   
	  
	   //并将该文件重新放到工程目录/day21/zuoye/third/下面
	   FileReader fReader2 = new FileReader("zong.txt");
	   //System.out.println(file2.getAbsolutePath());
	   FileWriter fWriter2 = new FileWriter(file2.getAbsolutePath()+"/zong.txt",true);

	   char[] c = new char[2];
	   int num ;  
	   while ((num = fReader2.read(c)) != -1) {
	       fWriter2.write(c,0,num);     	   
	   }
	   fWriter2.close(); 
	   fReader2.close();
	}

}
