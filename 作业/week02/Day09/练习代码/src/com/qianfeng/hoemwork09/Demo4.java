package com.qianfeng.hoemwork09;

class Fu1
{
	int num=4;
	void show()
	{
		System.out.println("showFu");
	}
}
class Zi1 extends Fu1
{
	int num=5;
	void show()
	{
		System.out.println("showZi");
	}
}
class Demo4
{
	public static void main(String[] args)
	{
		Fu1 f=new Zi1();
		Zi1 z=new Zi1();
		System.out.println(f.num); 
		System.out.println(z.num); 
		f.show();
		z.show(); 
	}
}

