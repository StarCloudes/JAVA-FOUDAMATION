package com.qianfeng.test;

import java.util.Arrays;
import java.util.List;

/*
 * Arrays:数组工具类,内部封装了大量操作数组的方法----方法都是静态的
 */
public class Demo8 {
	public static void main(String[] args) {
		//简单数据类型数组转字符串---方便我们对数组的内容进行查看
		int[] arr1 = {4,5,8,9};
		System.out.println(Arrays.toString(arr1));
		//数组转集合----因为集合的方法多
		//简单数据类型数组转集合
		List<int[]> list = Arrays.asList(arr1);
		System.out.println(list.size());//返回值: 1     将整个简单数据类型的数组作为了集合的一个元素
		//引用类型数组转集合
		String[] strings = {"java","php","ok"};
		List<String> list2 = Arrays.asList(strings);
		System.out.println(list2.size());//返回值: 3  //引用类型数组中的一个元素对应集合中的一个元素
		
		//注意点:
		//转过来的集合长度是固定,所以不能执行增加,删除.但是可以执行修改,更改,遍历
		//list2.add("iOS");//会报异常:UnsupportedOperationException
		list2.set(0, "html");
		
		//二分查找 数组必须是有序的
		int[] arr3 = {4,6,90,22};
		System.out.println(Arrays.binarySearch(arr3, 6));
	}
}
