package com.exam.homework22;

//编写程序，统计出字符串“I wish you become better and better”中字母e的出现次数
public class Demo4 {
    public static void main(String[] args) {
		String string = "I wish you become better and better";
		char[] arr = string.toCharArray();
		int count =0;
		for(char str: arr) {
			if(str == 'e') count ++;
		}
		System.out.println(count);
	}
}
