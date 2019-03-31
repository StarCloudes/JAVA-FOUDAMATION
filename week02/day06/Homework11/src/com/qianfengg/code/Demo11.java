package com.qianfengg.code;

class Demo11
{
	public static void main(String[] args)
	{
		char[] b={'a','b','c','d','e'};
		char a='c';
		try
		{
			int Index =getIndex(b,a);
			System.out.print(Index);
			
		}
		catch (Exception e)
		{
			System.out.print("你输入的字符为空");
		}
	}

public static int getIndex(char arr[],char r)
{
	if (arr==null)
	{
		throw  new IllegalArgumentException();
	}
    else
	for (int i=0;i<arr.length ;i++ )
	{
		if(r==arr[i])
		{
			return i;
		}
		
	}
	return -1;
}
}
