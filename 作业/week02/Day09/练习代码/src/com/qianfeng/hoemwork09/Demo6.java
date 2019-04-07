package com.qianfeng.hoemwork09;

class Super2
{
	int i=0;	
	public Super2(String s)
	{
		i=1;	
	}
}
class Demo6 extends Super2
{
	public Demo6(String s)
	{
		super(s);
		//i=2;			
	}
	public static void main(String[] args)
	{
		Demo6 d=new Demo6("yes");
		System.out.println(d.i);
	}
}

