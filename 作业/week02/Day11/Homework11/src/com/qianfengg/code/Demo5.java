package com.qianfengg.code;

class Demo5
{	
	public static void func()
	{
		try
		{
			throw  new Exception();
			//System.out.println("A"); 抛出异常后面不能接语句
		}
		catch(Exception e)
		{
			System.out.println("B");
		}
	}
	public static void main(String[] args)
	{
		try
		{
			func();
		}
		catch(Exception e)
		{
			System.out.println("C");
		}
		System.out.println("D");
	}
}