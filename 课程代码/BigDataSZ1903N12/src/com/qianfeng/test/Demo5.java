package com.qianfeng.test;
/*
 * 多异常处理
 * catch会对try里面的代码进行监听,如果try里面的代码没有发生异常,catch不会执行,会直接执行后面的代码.
 * 如果try里面的代码发生了异常,catch会立刻捕获(效果:try里面的代码会立刻终端,直接执行catch)
 * try{
 * 		可能发生异常的代码
 * }catch(异常一  e){ //捕获异常    e就是要捕获的异常
 * 		对当前异常的处理
 * }catch(异常二  e){ //捕获异常    e就是要捕获的异常
 * 		对当前异常的处理
 * }catch(Exception  e){ //捕获异常    e就是要捕获的异常
 * 		对当前异常的处理
 * }
 * 
 * go on
 */
//public class Demo5 {
//	public static void main(String[] args) {
//		Math2 math1 = new Math2();
//		try {
//			int value = math1.div(4, 0);
//			//注意:只要try内部的代码发生了异常,catch会立刻捕获异常,马上执行catch,所以发生异常后的代码不会执行.
//			//只有try里面的代码没有发生异常,这里的代码才能执行
//			System.out.println("value:"+value);
//		}catch (Exception e) {//e = new ArithmeticException()
//			e.printStackTrace();
//			System.out.println("捕获后的处理");
//			if (e instanceof ArithmeticException) {
//				System.out.println("除数为零异常");
//			}else if (e instanceof ArrayIndexOutOfBoundsException) {
//				System.out.println("数组下标越界异常");
//			}
//		}
//		
//		System.out.println("go on");//能执行,说明catch起作用了
//	}
//}

public class Demo5 {
	public static void main(String[] args) {
		Math2 math1 = new Math2();
		try {
			int value = math1.div(4, 0);
			//注意:只要try内部的代码发生了异常,catch会立刻捕获异常,马上执行catch,所以发生异常后的代码不会执行.
			//只有try里面的代码没有发生异常,这里的代码才能执行
			System.out.println("value:"+value);
		}catch (ArithmeticException e) {//e = new ArithmeticException()
			e.printStackTrace();
			System.out.println("捕获后的处理-除数为零异常");
			
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("捕获后的处理-数组下标越界异常");
		}catch ( Exception e) {//注意:Exception异常必须放在最后一个catch
			e.printStackTrace();
		}
		
		System.out.println("go on");//能执行,说明catch起作用了
	}
}

class Math2{
	public int div(int a,int b) //这里没有处理异常的能力,继续向上抛
	{
		int[] arr = {4,56,7};
		System.out.println(arr[10]);
		return a/b;//会自动创建一个叫除数为零的异常对象(new ArithmeticException()),这里没有处理异常的能力,
											//向上抛,抛给这行代码所在的方法
	}
}
