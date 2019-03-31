package com.qianfengg.code;

class Demo1
{	
	public static void func() throws Exception
	{
		try
		{
			throw  new Exception();
		}
		finally
		{
			System.out.println("B");
		}                                                                                                                               
	}
	public static void main(String[] args)
	{
		try
		{
			func();
			System.out.println("A");
		}
		    catch(Exception e)		//Exception e=new Exception;
		{
			System.out.println("C");
		}
		    System.out.println("D");
	}
}