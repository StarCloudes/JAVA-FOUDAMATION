package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  * 泛型:通过<数据类型>接收一种数据类型,在编译的时候会使用这种数据类型检测集合中的元素,如果元素不是<>中规定的类型,
 *    就不允许添加到当前的集合中(编译失败)
 *    
 * 泛型作用:1.使用了泛型不再需要进行容错处理,向下转型,强制类型转换----简化代码
 * 2.将运行阶段的问题提前到编译阶段检查,提高了代码的安全性和编程效率
 * 
 * 泛型可以修饰的地方:
 * 类,方法,接口
 * */
public class Demo7 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("java");
		list.add("htmp");
		list.add("python");
		list.add("haha");
		//list.add(3);//因为通过指定泛型,已经确定参数的类型是String,所以Integer不行了
		
		System.out.println(list);
		
		//进行遍历
		//让作用域迭代器的泛型与对应的集合保持一致
		Iterator<String> iterator = list.iterator();
		//使用泛型前
//		while (iterator.hasNext()) {
//			Object object = (Object) iterator.next();
//			//容错处理
//			if (object instanceof String) {
//				System.out.println("是字符串"+object);
//			}else {
//				System.out.println("不是字符串");
//			}
//		}
		
		//使用泛型后
		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string);
		}
	}
}
