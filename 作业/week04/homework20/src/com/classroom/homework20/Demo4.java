package com.classroom.homework20;

//10内偶数的乘机与奇数乘机的差

//n 1   
//n  2  2-1 
//n  3   2-1*3
//n  4    2*4 - 1*3
//n  5    2*4 - 1*3*5
//n  n    n*
public class Demo4 {
	public static void main(String[] args) {
        
	}

	//奇数的积
	public static int fac(int n) {
		int i;
		if (n == 1) {
			i = 1;
		} else {
			i = fac(n - 2) * n;
		}
		return i;

	}

	//偶数的积
	public static int fac2(int n) {
		int i;
		if (n == 2) {
			i = 2;
		} else {
			i = fac2(n - 2) * n;
		}
		return i;
	}

}
