package com.qianfeng.array;

import java.util.*;

public class calendar {
//	public static void main(String[] args) {
//	    Calendar nowc = Calendar.getInstance();
//	    System.out.println(nowc.get(Calendar.YEAR)); // 当前年份
//	    System.out.println(nowc.get(Calendar.MONTH));// 当前月份（从0开始)
//	    System.out.println(nowc.get(Calendar.DAY_OF_MONTH)); //　当前日期
//	    System.out.println(nowc.get(Calendar.DAY_OF_WEEK));  //当前星期几（从1表示星期日开始） 
//	}

	// 判断是否是闰年
	public static boolean isLeap(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		}
		return false;
	}

	// 计算本月天数
	public static int getDays(int year, int month) {
		int days = 0;
		switch(month) {
		   case 1: case 3: case 5: case 7: case 8: case 10: case 12: 
			   days= 31;
			   break; 
		   case 4: case 6: case 9: case 11: 
			   days= 30;
			   break; 
		   case 2:
			   days = isLeap(year)? 29 : 28; // 判断是否闰年
		   default: 
			   break; 
		}
		return days;
	}

	// 计算本月第一天星期几
	public static int getfirstWeek(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1); // 设置日期为本月一号
		int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return week;
	}

	// 打印标题
	public static void printTitle(int year, int month) {
		System.out.printf("%32s\n", year + " 年　" + month + " 月　");
		System.out.println("-----------------------------------------------------");
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		for (int index = 0; index < weeks.length; ++index) {
			System.out.printf("%-6s", weeks[index]);
		}
		System.out.println();
	}

	// 打印内容
	public static void printBody(int year, int month) {
		int week = getfirstWeek(year, month);
		for (int index = 0; index < week; ++index) {
			String blank = " ";// 空字符串占位
			System.out.printf("%-8s", blank);
		}
		int days = getDays(year, month);
		for (int index = week + 1, day = 1; index < days + week + 1; ++index, day++) {
			if (index % 7 == 0) {
				System.out.printf("%-8d\n", day); // 换行
			} else {
				System.out.printf("%-8d", day);
			}
		}
	}

	// 打印万年历
	public static void main(String[] args) {
		// 控制台输入年份和月份
		Scanner input = new Scanner(System.in);

		System.out.println("请输入年份：");
		int year = input.nextInt();

		System.out.println("请输入月份：");
		int month = input.nextInt();

		// 打印标题
		printTitle(year, month);

		// 打印内容
		printBody(year, month);
	}

}
