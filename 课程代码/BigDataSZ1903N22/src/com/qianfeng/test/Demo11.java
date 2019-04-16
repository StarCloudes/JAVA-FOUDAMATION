package com.qianfeng.test;

public class Demo11 {
	public static void main(String[] args) {
		/*
		 * 验证QQ
		 * 要求:1.全部是数字  2.首字母不能为0   3.位数是5-13
		 */
		String qq = "12334556676";
		boolean isQQ = isQQ(qq);
		System.out.println(isQQ);
		//使用正则表达式
		String regex = "[1-9]\\d{4,12}"; 
		boolean isQQ1 = qq.matches(regex);
		System.out.println(isQQ1);
	}
	//普通方式验证
	public static boolean isQQ(String qq) {
		if (qq.length()>=5 && qq.length()<=13) {
			char[] arr = qq.toCharArray();
			int a = 0;
			for (int i = 0; i < arr.length; i++) {
				if (!(arr[i] <= '9' && arr[i] >= '0')) {
					System.out.println("不全是数字");
				}else {
					a++;
				}
			}
			if (a==qq.length() ) {
				if ( !qq.startsWith("0")) {
					return true;
				}else {
					System.out.println("首字母为0了");
				}
			}
		}else {
			System.out.println("qq的位数超过了正常范围");
		}
		
		return false;
	}
}
