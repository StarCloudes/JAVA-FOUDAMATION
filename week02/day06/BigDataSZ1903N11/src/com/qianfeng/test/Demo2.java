package com.qianfeng.test;

public class Demo2 {
	public static void main(String[] args) {
		/*
		 * Object
		 */
		//实例:根据轮子个数比较两辆车
		Car car1 = new Car(5);
		Car car2 = new Car(4);
		boolean b = car1.equalsWithWheels(car2);
		System.out.println(b);
		
		//使用equals方法比较两个对象
		//默认比较的是两个对象的地址,我们可以通过重写这个方法,实现按照自己的规则比较
		boolean b1 = car1.equals(car2);
		System.out.println(b1);
		
		//hashCode:获取对象的哈希码值---我们可以理解成是当前对象的身份证(唯一标识)
		System.out.println(car1.hashCode());//2018699554  默认是一个十进制的值
		System.out.println(Integer.toHexString(car1.hashCode()));//7852e922  十六进制的数
		System.out.println(car1.hashCode() == car2.hashCode());//false,如果重写了hashCode方法,
															//结果是true,因为相当于把Car类的所有对象的哈希码值写死了.
		
		//toString():直接打印引用,默认调用的是toString()
		System.out.println(car1);//com.qianfeng.test.Car@1   这是包名+类名+@+哈希码值
		System.out.println(car1.toString());
		//重写toString
		
		//getClass---了解
		//获取当前对象的字节码文件--.class文件,一个类只有一个.class文件
		//Class是一个具体的类,它就是字节码文件抽象后形成类
		//字节码文件本身就是对象,相当于将系统处理当前类(Car)的工作面向对象了,形成的类就是Class类
		Class cla1 = car1.getClass();
		System.out.println(cla1.getName());
		System.out.println(cla1.getSimpleName());
		
		//重现默认的toString
		System.out.println(cla1.getName()+"@"+Integer.toHexString(car1.hashCode()));
		
	}
}

class Car{
	int wheelNumber;
	String name;
	int age;
	public Car(int wheelNumber) {
		this.wheelNumber = wheelNumber;
	}
	
	public boolean equalsWithWheels(Car car) {
		return this.wheelNumber > car.wheelNumber;
	}
	
	//重写equals方法,实现轮子个数的比较
    //这个方法的参数不能随意改动,改了就不是重写了
	public boolean equals(Object obj) {
		//容错处理
		if (!(obj instanceof Car)) {
			System.out.println("类型转化错误");
			System.exit(-1);//退出程序
		}
		//向下转型
		Car car = (Car)obj;
		return this.wheelNumber > car.wheelNumber;
	}
	
	//重写hashCode方法
	@Override
	public int hashCode() {
		return 1;
	}


	//重写toString
//	public String toString() {
//		return ""+wheelNumber;
//	}
	@Override
	public String toString() {
		return "Car [wheelNumber=" + wheelNumber + ", name=" + name + ", age=" + age + "]";
	}
}
