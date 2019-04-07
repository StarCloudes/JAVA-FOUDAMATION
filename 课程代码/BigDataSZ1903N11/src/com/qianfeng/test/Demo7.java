package com.qianfeng.test;
/*
 * 了解:
 */
public class Demo7 {
	public static void main(String[] args) {
//		Out out = new Out();
//		Out.Inn inn = out.new Inn();
		//创建静态内部类对象
		//构成:  new  +  外部类名字.内部类的构造方法
		 Out.Inn inn =  new Out.Inn();
		 //调用方法
		 inn.play();
		 //调用静态方法
		// inn.show();
		 Out.Inn.show();
	}
}


class Out{
	static int age;
	//静态内部类不一定有静态方法,有静态方法的一定是静态内部类
	static class Inn{//静态内部类
		public void play() {
			System.out.println("play");
		}
		public static void show() {
			System.out.println("show");
		}
	}
}

