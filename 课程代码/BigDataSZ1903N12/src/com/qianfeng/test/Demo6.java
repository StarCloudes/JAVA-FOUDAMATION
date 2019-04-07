package com.qianfeng.test;
/*
 * try{
 * 		可能发生异常的代码
 * }catch(Exception  e){ //捕获异常    e就是要捕获的异常
 * 		对当前异常的处理
 * }finally{
 * 		//必须执行的代码:主要用于资源的释放:比如关闭数据库,关闭流,关闭锁等
 * }
 * 
 * 这个结构跟异常没有关系
 * try{
 * 		获取资源
 * }finally{
 * 		释放资源
 * }
 */
public class Demo6 {
	public static void main(String[] args) {
		Math3 math1 = new Math3();
		try {
			int value = math1.div(4, 0);
			System.out.println("value:"+value);
		}catch (ArithmeticException e) {//e = new ArithmeticException()
			System.out.println("捕获后的处理");
			//return ;//结束当前的函数,finally还能执行
			System.exit(-1);//退出程序,finally不能执行了
		}finally {
			System.out.println("finally");
		}
		
		System.out.println("go on");//能执行,说明catch起作用了
	}
}

class Math3{
	public int div(int a,int b) //这里没有处理异常的能力,继续向上抛
	{
		return a/b;//会自动创建一个叫除数为零的异常对象(new ArithmeticException()),这里没有处理异常的能力,
											//向上抛,抛给这行代码所在的方法
	}
}
