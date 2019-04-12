package com.qianfeng.test;
/*
 * 实例:求1-10之间的偶数的积与奇数的积的差---利用递归
 */
public class Demo10 {
	public static void main(String[] args) {
		System.out.println(getValue());
	}
	static int jishuji = 1,oushuji = 1,i=1;
	public static int getValue(){
		//求偶数的积
		if (i%2==0) {
			oushuji*=i;
		}
		//求奇数的积
		if (i%2!=0) {
			jishuji*=i;
		}
		//得到差值
		if (i++ == 3) {
			return oushuji-jishuji;
		}
		//自己调用自己
		int a = getValue();
		return a;
	}
}
