package com.qianfeng.test;


import java.lang.reflect.Field;

//3.给属性赋值(通过从属性中提取出来的类--Field)
public class Demo4 {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		//通过普通的方式
		Person person = new Person();
		person.setName("bingbing");
//		person.name = "bingbing";  因为name是私有的,所以不能直接调用成员变量
		
		//通过反射实现--通过字节码文件创建对象调用
		//1.得到字节码文件
		Class<?> class1 = Class.forName("com.qianfeng.test.Person");
		
		//2.调用Filed相关方法得到属性
		//参数就是哪个实际的属性
		//Field field = class1.getField("name");
		
		//忽略权限
		Field field = class1.getDeclaredField("name");
		
		//解释:当属性是私有的,我们要通过反射进行访问,可以做的方法:
		//首先使用getDeclaredField()   ,然后再调用setAccessible(),并将参数设置成true.
		field.setAccessible(true);
		
		//3.通过字节码文件创建Person类型的实例对象
		Object per = class1.newInstance();
		
		//4.将field属性指定给当前的实例对象并完成赋值
		//第一个参数:绑定的具体的实例对象   第二个参数:给他赋的值
		field.set(per, "冰冰");//per.name = "冰冰"
		//打印值
		System.out.println(field.get(per));
		
		//5.通过字节码文件再创建一个对象
		Object per1 = class1.newInstance();
		field.set(per1, "晨晨");
		System.out.println(field.get(per1));
	}
}

