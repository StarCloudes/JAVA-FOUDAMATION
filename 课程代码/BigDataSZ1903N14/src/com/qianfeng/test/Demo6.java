package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 	 * 区分集合和数组
 * 数组:可以存储不同类型的多个数据,数据类型可以是简单数据类型也可以引用数据类型
 * 		缺点:创建的是一个定值,只能存储固定长度的数据,一旦存满了,就不能再继续存储.
 * 集合:可以存储不同类型的多个数据,但是只能存储引用数据类型.
 *      缺点:只能存储引用数据类型
 *      优点:存储空间会随着存储数据的增大而增大,所以可以更加合理的利用内存空间,方法很多,方便我们实现功能.
 *      
 * 分类:
 * Collection:---接口
 * 		>List---接口
 * 			>>ArrayList--类
 * 			>>Vector  ---类
 * 			>>LinkedList--类
 * 		>Set---接口
 * 			>>HashSet--类
 * 			>>TreeSet--类
 * Map:--接口
 * 		>HashMap--类
 * 		>TreeMap--类
 */
public class Demo6 {
	public static void main(String[] args) {
		//Collection中定义是整个Collection体系最共性的方法:
		Collection collection1 = new ArrayList<>();
		//1.添加：
		//boolean add(Object o) 
		//boolean addAll(Collection<? extends E> c)  
		collection1.add("java");
		collection1.add("html");
		collection1.add("python");
		System.out.println(collection1);//重写了toString方法
		Collection collection2 = new ArrayList<>();
		collection2.add("iOS");
		collection2.add("erlang");
		Collection collection3 = new ArrayList<>();
		collection3.add("erlang");
		collection3.add("iOS");
		
		collection1.addAll(collection2);
		System.out.println(collection1);
		//2.删除:
	    //boolean remove(Object o)  
//		collection1.remove("iOS");
//		System.out.println(collection1);
//	    //boolean removeAll(Collection<?> c)
//		collection1.removeAll(collection2);
//		System.out.println(collection1);//删除一批元素,但是collection1中不一定包括collection2的所有元素
//	    //void clear()   空集合!=null
//		collection1.clear();
//		System.out.println(collection1);
		//3.判断:
		//boolean contains(Object o) 
		//boolean containsAll(Collection<?> c)
		//boolean isEmpty() //判断集合是否为空集合
		System.out.println(collection1.isEmpty());
		//boolean equals(Object o) 
		//注意:判断两个集合相等,不仅元素要相同,元素的顺序也要一致
		System.out.println(collection2.equals(collection3));
		//4.获取：
		//Iterator<E> iterator() //获取集合中的对象
		test(collection1);
		//int size() //获取集合中对象的个数
		System.out.println(collection1.size());//
		//5.集合变数组：当我们希望集合的长度固定下来的时候
		//Object[] toArray()
		Object[] strings = collection1.toArray();
		for (Object string : strings) {
			System.out.println("string:"+(String)string);
		}
	}
	//4.获取：
	//Iterator<E> iterator() //获取集合中的对象
	/*
	 * Iterator:叫迭代器
	 * hasnext():判断当前位置是否有值,有返回true,没有false
	 * next():取出当前位置的值,并将指针指向下一个位置
	 */
	public static void test(Collection collection) {
		//1.先获取迭代器对象
		Iterator iterator = collection.iterator();
		//2.遍历
		while (iterator.hasNext()) {
			String value = (String)iterator.next();
			System.out.println("value:"+value);
		}
		//注意点:
		//1.直接再次使用第一次的iterator进行遍历,遍历失败.因为当前的指针已经指向了集合的最后.
		//再次使用hasnext会直接返回false.所以如果想再次遍历,要重新获取迭代器对象.
		while (iterator.hasNext()) {
			String value = (String)iterator.next();
			System.out.println("value1:"+value);
		}
		//2.同时存储多个不同类型的值
		collection.add(2);
		
		//3.再次遍历--当集合中同时存在不同类型的数据时,需要进行容错处理和向下转型.
		Iterator iterator1 = collection.iterator();
		while (iterator1.hasNext()) {
			Object value = iterator1.next();
			//容错处理
			if (value instanceof String) {
				System.out.println("value2:"+value);
			}
			
		}
	}
}
