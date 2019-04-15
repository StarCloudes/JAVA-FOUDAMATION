//作业:要求遍历当前目录下的所有文件----利用递归实现
package com.qianfeng.test;
import java.io.File;

public class HomeWork1 {
	public static void main(String[] args) {
		travel(new File("D:\\workspace\\BigDataSZ1903N21"));
	}

	public static void travel(File path){
		if(path.isDirectory()){//判斷是否是文件夾
			for(File files:path.listFiles()){//获取该目录下的文件或文件夹的全路径
				travel(files);//调用自己进行递归
			}
		}else{
			System.out.println(path.getAbsolutePath());//获取文件的绝对路径
		}
	}
}