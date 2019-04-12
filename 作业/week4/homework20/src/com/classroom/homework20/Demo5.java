package com.classroom.homework20;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo5 {
	public static void main(String[] args) {
		 ArrayList list = new ArrayList();
	        // 添加元素
	        list.add("hello");
	        list.add("world");
	        list.add("java");

	        Iterator lit = list.iterator();
	        while (lit.hasNext()) {
	            String s = (String) lit.next();
	            if ("world".equals(s)) {
	                list.add("javaee");
	            }
	        }
	}

}
