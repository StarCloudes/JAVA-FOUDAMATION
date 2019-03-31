package com.qianfengg.code;

class Exc0 extends Exception{}
class Exc1 extends Exc0{}

class Demo7
{
	public static void main(String[] args)
	{
		try
		{
			throw new Exc1();
		}		
//		catch(Exception e)	//已经包含了所有异常，往下会重复捕捉
//						    //子类异常写在了父类异常的上面
//		{
//			System.out.println("Exception");
//		}
		catch(Exc0 e)
		{
			System.out.println("Exc0");
		}
	}
}
