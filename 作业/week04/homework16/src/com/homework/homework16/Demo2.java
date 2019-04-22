package com.homework.homework16;

import java.util.HashMap;
import java.util.Map;

//2.有两个班级，一班和二班，每个班级有若干学生，包含学号和姓名信息，
//要求能够完全保存班级和学生信息，遍历输出。

public class Demo2 {
    public static void main(String[] args) {
    	Map<String, Map<String, String>> map = new HashMap<>();
		Map<String, String> first = new HashMap<>();
		first.put("001", "小明");
		first.put("002", "李四");
		Map<String, String> second = new HashMap<>();
		second.put("001", "小张");
		second.put("002", "小红");
		map.put("01班级", first);
		map.put("02班级", second);
		
		for(String classname: map.keySet()) {
			System.out.println(classname);
			for(String num: map.get(classname).keySet()) {
				System.out.println(num + ":" + map.get(classname).get(num));
			}
		}
    }    
}
