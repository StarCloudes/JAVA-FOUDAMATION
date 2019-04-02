package com.qianfeng.test;
/*
 *  什么是自定义异常:自己定义的异常类,由于Exception已经有了异常的基本功能,所以一般写的是他的子类
 *  
 * 为什么要自定义异常?
 * 系统没有定义的异常需要我们自己来定义,我们要解决的是系统没有解决的问题
 * 
 * 分类:
 * 编译异常:发生在编译阶段.---对应的异常是除了RumtimeException之外的所有异常
 * 	  特点:对异常进行处理的所有工作都要我们手动完成
 * 运行时异常:发生在运行阶段.---RumtimeException
 * 	 特点:所有的工作我们都可以不管
 * 
 * 常见的自定义异常:订单异常      用户异常     负数异常
 * 
  * 以负数异常为例:
 * 对于编译异常需要我们进行处理的有:
 * 异常类的创建----FuShuException
 * 异常对象的创建---应该是在发生异常的位置
 * 异常对象的抛出---throw
 * 异常的声明(我们要给可能发生异常的方法进行异常的声明)----throws
 * 作用:告诉别人我有可能发生异常
 * 
  * 异常的处理方法
 * 1.异常的声明
 * 2.trycatch--真正的处理
 * 
  * 使用trycatch的位置:一般是调用可能发生异常的方法的位置
 */
//定义一个异常类
class FuShuException extends Exception{
	public FuShuException() {
	}
	public FuShuException(String message) {
		//注意:必须写
		super(message);
	}
}
public class Demo7 {
	public static void main(String[] args) //throws FuShuException
	{
		Math4 math1 = new Math4();
		try {
			int value = math1.div(4, -1);
			System.out.println("value:"+value);
		}catch (FuShuException e) {//e = new ArithmeticException()
			System.out.println("捕获后的处理");
			e.printStackTrace();
		}
		
		System.out.println("go on");//能执行,说明catch起作用了
	}
}

class Math4{
	//声明异常,告诉别人我是有可能发生这个异常.
	//当需要声明多个异常的时候,直接用,隔开
	public int div(int a,int b) throws FuShuException,ArithmeticException//这里没有处理异常的能力,继续向上抛
	{
		if (b<0) {
			throw new FuShuException("除数为负数了");
		}
		return a/b;//会自动创建一个叫除数为零的异常对象(new ArithmeticException()),这里没有处理异常的能力,
											//向上抛,抛给这行代码所在的方法
	}
}

