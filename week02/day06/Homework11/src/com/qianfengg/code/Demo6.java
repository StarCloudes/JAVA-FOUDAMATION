package com.qianfengg.code;

class Demo6
{	
	public void func()
	{
		//位置1；
		new  Inner();
		
	}

	class Inner{}

	public static void main(String[] args)
	{
		Demo6 d=new Demo6();
		// 位置2 
		//new Inner(); //不可以，因为Inter类是非静态的
		//new d.Inner(); //不可以，错误写法new new Demo().Inter()
		//new Demo.Inner();// 不可以，  正确的 new Demo().new Inner()
	}
}