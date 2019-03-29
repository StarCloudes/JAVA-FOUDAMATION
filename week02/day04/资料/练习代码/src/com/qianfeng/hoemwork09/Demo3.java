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
{
	public Demo3(String a)
	{
		//super();
		System.out.println("C");
		i=5;				
	}
	public static void main(String[] args)
	{
		int i=4;
		Super d=new Demo3("A");
		System.out.println(d.i);
	}
}
