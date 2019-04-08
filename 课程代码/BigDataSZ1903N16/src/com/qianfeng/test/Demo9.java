package com.qianfeng.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Collections:集合工具类,内部封装了大量操作集合(Collection)的方法.
 */
public class Demo9 {
	public static void main(String[] args) {
		//要求:存储多个数据,可排序,可重复
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("java");
		list.add("php");
		list.add("python");
		list.add("xOS");
		list.add("html");
		list.add(".net");
		System.out.println(list);
		
		//使用Collections进行排序
		//第一种排序:默认按照字典进行排序
		//注意:要想list中的元素可以按照字典排序,元素必须实现Comparable接口
		Collections.sort(list);
		System.out.println("字典排序:"+list);
		
		//第二种:按照从短到长排序
		//自己创建比较器
		ComStringWithLength comStringWithLength = new ComStringWithLength();
		Collections.sort(list, comStringWithLength);
		System.out.println("按照从短到长排序:"+list);
		
		//第三种:按照从长到短排序
		Comparator<String> comparator = Collections.reverseOrder(comStringWithLength);
		Collections.sort(list, comparator);
		System.out.println("按照从长到短排序:"+list);
		
		//第四种:按照字典排序倒叙
		Comparator<String> comparator1 = Collections.reverseOrder();
		Collections.sort(list, comparator1);
		System.out.println("按照字典排序倒叙:"+list);
		
		//第五种:现有顺序倒叙
		Collections.reverse(list);
		System.out.println("现有顺序倒叙:"+list);
		
		//求字典顺序最大值
		String value = Collections.max(list);
		System.out.println("字典顺序最大值:"+value);
	}
}

class ComStringWithLength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int num = o1.length()-o2.length();
		return num==0?o1.compareTo(o2):num;
	}
	
}
