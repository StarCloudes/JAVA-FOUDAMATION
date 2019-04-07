package com.hoemwork.homework13;

public class ValidationNum {
	public static void main(String[] args) {
		String string = "3145790134562";
		validate(string);
	}

	private static void validate(String s) {
		char[] arr = s.toCharArray();
		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < 12; i++) {
			if (i % 2 == 0) {
				sum1 = sum1 + (arr[i] - '0');
			} else {
				sum2 = sum2 + (arr[i] - '0');
			}
		}

		int sum3 = (sum1 + sum2) % 10;
		sum3 = 10 - sum3;

		if (sum3 == (arr[12] - '0')) {
			System.out.println("验证码正确");
		} else {
			System.out.println("验证码错误");
		}
	}

}
