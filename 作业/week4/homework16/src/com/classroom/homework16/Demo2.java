package com.classroom.homework16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Demo2 {
    public static void main(String[] args) {
		//存储多个数据、可排序、可重复
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("java");
    	list.add("python");
    	list.add("html");
    	list.add("java");
    	list.add("js");
    	
    	//1.默认字典排序
    	Collections.sort(list);
    	
    	//2.长短
    	comWithLength length= new comWithLength();
    	Collections. sort(list,length);

    	//3.从长到短
    	Comparator<String> comparator = Collections.reverseOrder(length);
    	Collections.sort(list,comparator);
    	
    	//4 字典倒叙
    	Comparator<String> comparator2 = Collections.reverseOrder();
    	Collections.sort(list,comparator2);
    	
    	//5 现有顺序倒叙
    	Collections.reverse(list);
    	
    	//Max 字典顺序
    	String value = Collections.max(list);
    		
    	System.out.println(list);
    	
    	int[] a = {2,3,4};
    	//List<int> list = Arrays.asList(a);
    	
	}
}

class comWithLength implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		int num = o1.length() - o2.length();
		return num == 0 ? o1.compareTo(o2):num;
	}
}


