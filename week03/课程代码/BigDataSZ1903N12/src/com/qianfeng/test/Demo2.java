package com.qianfeng.test;
/*
 * 异常:程序中出现的不正常的情况
 * 异常的由来:程序在运行时出现了不正常的情况,java提取了对应的属性,名字,原因等,形成了异常对象,进而形成了各种的异常类
 * 
 * 异常的分类:
 *  * 异常的分类:(throwable)
 * 1.Error:(错误):运行中出现的严重错误,不需要我们进行更改.
 * 2.Exception:运行中出现的不严重的错误,我们可以尝试去更改.
 * 
 * Exception:分类:
 * 第一种分类:系统异常:系统提前定义好的,我们直接使用
 * 			自定义异常:需要我们自己定义.
 * 第二种分类:编译异常:在编译阶段抛出异常,处理异常
 *           运行时异常:在运行阶段抛出异常,处理异常.
 */
public class Demo2 {
    public static void main(String[] args) //这里没有处理异常的能力,继续向上抛,抛给JVM,
    										//调用异常对象的打印方法,将异常信息打印到控制台
    {
		Math math = new Math();
		int value = math.div(3, 0);//这里没有处理异常的能力,继续向上抛
		System.out.println(value);
	}
}
class Math{
	public int div(int a,int b) //这里没有处理异常的能力,继续向上抛
	{
		return a/b;//会自动创建一个叫除数为零的异常对象(new ArithmeticException()),这里没有处理异常的能力,
											//向上抛,抛给这行代码所在的方法
	}
}
