package com.qianfengg.code;

class Test 
{
	Test(int a)
	{       
		System.out.println("Test "+a);
	}
}
class Demo2 extends Test
{
	Demo2()
	{   super(2);
		System.out.println("Demo ");
	}
	public static void main(String[] args)
	{
		new Demo2();
		new Test(1);
	}
}
