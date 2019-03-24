package com.qianfeng.practice;

public class practice3 {
	public static void main(String[] args) {
		int x = 1;
		for (show('a'); show('b') && x < 3; show('c')) {
			show('d');
			x++;
		}
	}

	public static boolean show(char ch) {
		System.out.println(ch);
		return true;
	}

}

//for（表达式1;表达式2;表达式3）
//先执行“表达式1”，再进行“表达式2”的判断，判断为真
//则执行  “循环体”，循环体执行完以后执行表达式3.

//abdc bdc b