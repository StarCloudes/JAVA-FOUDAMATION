package com.hoemwork.homework20;

import java.io.File;

//2.删除指定目录下的文件及文件夹，包括子目录中的内容(当前的工程目录)
public class Demo2 {	
	public static void main(String[] args) {
		 // 删除功能：我要删除a.txt这个文件
        File file3 = new File("a.txt");
        System.out.println("delete:" + file3.delete());

        // 删除功能：我要删除ccc这个文件夹
        File file4 = new File("aaa\\bbb\\ccc");
        System.out.println("delete:" + file4.delete());
	}

}
