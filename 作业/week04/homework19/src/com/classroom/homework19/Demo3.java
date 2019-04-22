package com.classroom.homework19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws IOException  {
 	   //文档复制
 	   FileReader fReader = new FileReader("test2.txt");
 	   FileWriter fWriter = new FileWriter("test2copy.txt",true);
 	  
 	   char[] c = new char[2];
 	   int num ;  
 	   while ((num = fReader.read(c)) != -1) {
 		   System.out.println(new String(c,0,num) + "   num:" + num); 
    	   fWriter.write(c,0,num);     	   
 	   }
 	   fWriter.close(); 
 	   fReader.close();
	}
}
