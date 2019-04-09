package com.qianfeng.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HomeWork1 {
	public static void main(String[] args) throws CharException {
	//练习题二: 1.josgjsjagwajsogiseafgjwsjgvoier
	// 要求:1.转化成字符串 :  a(字符的个数)b()c()..   2.区分大小写   3.只读取字母	
		String s="josgjsjagwajsogiseafgjwsjgvoierAA";
		char[] a=s.toCharArray();
		TreeMap<Character,Integer> map=new TreeMap<>();
		for(int i=0;i<=a.length-1;i++){
			if(!Character.isLetter(a[i])){
				throw new CharException();
			}else if(!map.containsKey(a[i])){
				map.put(a[i],1);
			}else{
				map.put(a[i],map.get(a[i])+1);
			}
		}
		//遍历方法1
		Set<Map.Entry<Character,Integer>> map2=map.entrySet();
		Iterator<Entry<Character,Integer>> iterator=map2.iterator();
		while(iterator.hasNext()){
			Map.Entry<Character,Integer> entry=iterator.next();
			System.out.print(entry.getKey()+"("+entry.getValue()+")");
			
		}
		System.out.println();
		//遍历方法2
		Set<Character> set=map.keySet();
		Iterator<Character> iterator1=set.iterator();
		while(iterator1.hasNext()){
			Character key=iterator1.next();
			System.out.print(key+"("+map.get(key)+")");
		}
	}       
}
class CharException extends Exception{
	
	public CharException() {
		
	}
	
}
