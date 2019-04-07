package com.classroom.homework13;

public class StringIsNum {
	public static void main(String[] args) {
		String string = "12356y78";
		isNum(string);
        
	}

	public static boolean isNum(String str) {
		boolean result = true;
		for (int i = 0; i < str.length(); i++) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
				result = false;
		}
		System.out.println(result);
		return result;

	}
}
