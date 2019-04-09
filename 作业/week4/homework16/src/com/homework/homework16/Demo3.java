package com.homework.homework16;

import java.util.HashMap;
import java.util.Map;

//1. 有长度为5的字符串数组，数组中的每个元素均为一个标准英文句子，要求借助Map
//集合统计每个单词出现的次数。

public class Demo3 {
	
	public static void main(String[] args) {
		String[] text = new String[5];
		text[0] = "today is a good day";
		text[1] = "how are you";
		text[2] = "you are beautiful";
		text[3] = "good weather";
		text[4] = "day day up";
		
		Map<String, Integer> map = new HashMap<>();
		for(String line: text) {
			for(String word : line.split(" ")) {
				if(map.get(word) == null) {
					map.put(word, 1);
				}else {
					map.put(word, map.get(word) + 1);
				}
			}
		}
		
		for(String word: map.keySet()) {
			System.out.println("{word:" + word+ ", counts:" + map.get(word)+"}");
		}
	}

}
