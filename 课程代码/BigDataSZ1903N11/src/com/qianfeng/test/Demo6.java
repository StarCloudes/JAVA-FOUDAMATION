package com.qianfeng.test;

public class Demo6 {
	public static void main(String[] args) {
		Outer4 outer4 = new Outer4();
		outer4.show();
		outer4.eat();
		
	}
}

//模拟jdk1.7时局部变量前面有final修饰的时候的情况
class Outer4{
	Object object = null;
	public void show() {
		/*
		 * 了解内容:
		 * 
		 * final:被final修饰的变量会被放在常量区,而常量区的值的存在时间要大于当前的方法,相当于扩大了原来局部变量的作用域,
		 * 即方法执行完了,变量也不会被释放
		 * 
		 * 
		 * 只要将下面的结论记住就可以
		 * 
		 * 前提:方法中使用了局部内部类
		 * 在jdk1.7之前,要想保住这个值必须手动添加final
		 * 在jdk1.8及之后,java的内部机制已经在变量的前面默认添加了final
		 */
		int  age = 6;
		class Inner{//局部内部类
			
			public void run() {
				System.out.println("跑"+age);
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "toString    "+age;
			}
		}
		
		//show的内部使用局部内部类
		object = new Inner();//多态
	
	}
	
	public void eat(){
		System.out.println(object.toString());
		System.out.println("eat");
	}
}

