package com.qianfeng.hoemwork09;


//A
//B
class Fu
{
	boolean show(char a)
	{
		System.out.println(a);
		return true;
	}
}
class Demo1 extends Fu
{
	public static void main(String[] args)
	{
		int i=0;
		Fu f=new Demo1();
		Demo1 d=new Demo1();
		for(f.show('A'); f.show('B')&&(i<2);f.show('C'))
		{
			i++;
			d.show('D');
		}	
	}
	boolean show(char a) //子类重写了父类的方法，最后运行的是子类的方法
	{
		System.out.println(a);
		return false;
	}
}
