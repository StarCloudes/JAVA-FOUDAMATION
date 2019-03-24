package com.qianfeng.practice;

// break结束循环，continue结束本次循环，return结束方法
public class pratice8 {
	public static void main(String[] args) {
		for (int x = 0; x < 10; x++) {
			if (x == 2) {
				System.out.println("退出");
				// break;
				// continue;
				return;
			}

			System.out.println(x);
		}

		System.out.println("over");
	}

}
