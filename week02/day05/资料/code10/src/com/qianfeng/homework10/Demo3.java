package com.qianfeng.homework10;

public class Demo3 {
	public static void main(String[] args) {
	    String string = "I Love Sky";
	    reverseSentence(string);
	}
	
	public static String reverse(String str){
		char[] array = str.toCharArray();
		for(int i = 0;i<(array.length)/2;i++){
			char temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-i-1]=temp;
		}
		return String.valueOf(array);
	}
	public static void reverseSentence(String sentence){
		if(sentence == null)
			return;
		String sentenceReverse = reverse(sentence);
		String[] splitStrings = sentenceReverse.split(" ");
		String resultBuffer = "";
		for(String s:splitStrings)
			resultBuffer = resultBuffer+reverse(s)+" ";
		System.out.println(resultBuffer);
	}
}