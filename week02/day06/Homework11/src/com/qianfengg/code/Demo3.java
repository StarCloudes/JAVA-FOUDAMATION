package com.qianfengg.code;

class TD
{
	int y=6;
	class Inner
	{
		int y=3;  

		void show()
		{
			System.out.println(y);  //就近
			//System.out.println(this.y);
			System.out.println(TD.this.y);
		}
	}
}
class Demo3
{
	public static void main(String[] args)
	{
		TD.Inner ti = new TD().new Inner();
		ti.show();
	}
}