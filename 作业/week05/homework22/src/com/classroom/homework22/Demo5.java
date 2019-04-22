package com.classroom.homework22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
	public static void main(String[] args) {

//		 * 使用
//		 * 1.匹配
//		 * 使用的是String类中的boolean matches(String regex)方法
		// piPei();
//		 * 2.切割
//		 * 使用的是String类中的 String[] split(String regex)方法
//		 * 依据正则表达式的字符串来切割
		 //qieGe();
//		 * 3.替换
//		 * 使用的是String类中的 String replaceAll(String regex, String replacement)  
//		 * 把字符串中符合正则表达式的内容替换成第二个参数的内容
		//tiHuan();
//		 * 4.获取
		huoQu();

	}

	// 匹配
	public static void piPei() {
		// 实例:可以在h和l之间有0个或多个o
//		String s = "schooooooool";
//		String regex = "scho*l";//o*:代表0个或多个o     o+:代表1个或多个o
//                                  //o?:至多一个0
		// 实例:匹配手机号码:18910909090
		String s = "18910909090";
		String regex = "1[345789]\\d{9}";

		boolean b = s.matches(regex);
		System.out.println(b);
	}

	// 切割
	public static void qieGe() {
		// 实例:使用,进行切割
//		String s = "axogj,owjgoiwrj,sgoiwrjoigjw,orisjgwr,jog34wjr";
//		String regex = ",";
//		String[] strings = s.split(regex);

		// 要求按照空格切割
//		String s = "sdjof sjfsj      rjgojj          jgoj      jfoesjew  sd";
//		String regex = " +";
//		String[] strings = s.split(regex);

		// 要求使用.进行切割
		String s = "sdjof.srj.gojjg.ofoe.sjesd";
		String regex = "\\.";// .默认代表任意字符,要想使用.需要进行转义\\.
		String[] strings = s.split(regex);

		for (String string : strings) {
			System.out.println("string:" + string);
		}
	}

	// 替换
	public static void tiHuan() {
		// 要求:将连续超过三个数字的部分进行替换---****
		String s = "sjfwfj4444sajose645sdgsjgrj3329889jsfjgowjsg888888888jsfjs";
		String regex = "\\d{4,}";
		String place = "****";

		String newString = s.replaceAll(regex, place);
		System.out.println(newString);
	}

	// 获取
	public static void huoQu() {
		// 要求:获取连续超过四个字母的子字符串
		String s = "sjoiffs   sjfj   sdfgjj       sdjijs    djd    d    jwejfe";
		String regex = "[a-zA-Z]{5,}";
		// 相当于将正则表达式进行了简单的转化,但是Pattern本身不具有获取数据的能力
		Pattern pattern = Pattern.compile(regex);

		// 具有获取数据的能力
		Matcher matcher = pattern.matcher(s);

//		matcher.find();//判断是否有符合当前表达式的内容
//		matcher.group();//是获取内容
		while (matcher.find()) {
			String string = matcher.group();
			System.out.println(string);
		}
	}
}
