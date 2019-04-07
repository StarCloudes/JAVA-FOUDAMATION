package com.qianfeng.hoemwork09;

class Super3
{
	public int get()
	{return 4;}
}
class Demo7 extends Super3
{
      
	public int get(){return 5;}
		
	public static void main(String[] args)
	{
		Super3 s= new Demo7();
		System.out.println(s.get());
	}
}