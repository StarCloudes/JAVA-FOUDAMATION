package com.qianfeng.hoemwork09;

class Super
{
	int i=0;
	public Super(String a)
	{
		System.out.println("A");
		i=1;	
	}
	public Super()
	{
		System.out.println("B");
		i+=2;
	}
}

class Demo3 extends Super
{   int i = 7;
	public Demo3(String a)
	{
		//super(); //默认调用父类的无参构造方法
		System.out.println("C");
		i=5;				
	}
	public static void main(String[] args)
	{
		int i=4;  //局部变量
		Super d=new Demo3("A"); //
		System.out.println(d.i);//2 引用调用的成员变量 多态下成员变量同名看父类
		//System.out.println(i);//4 就近原则
	}
}
