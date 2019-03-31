package com.qianfengg.code;

class Test 
{
	Test()
	{       
		System.out.println("Test");
	}
}
class Demo2 extends Test
{
	Demo2()
	{  
		System.out.println("Demo");
	}
	public static void main(String[] args)
	{
		new Demo2();
		new Test();
	}
}
