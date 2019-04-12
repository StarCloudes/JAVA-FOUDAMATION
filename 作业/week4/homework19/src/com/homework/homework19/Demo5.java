package com.homework.homework19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


//2.有五个学生，每个学生有3门课的成绩，
//从键盘输入以上数据（包括姓名，三门课成绩），
//输入的格式：如：zhagnsan，30，40，60计算出总成绩，
//并把学生的信息和计算出的总分数高低顺序存放在磁盘文件"stud.txt"中。
public class Demo5 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bfWriter = new BufferedWriter(new FileWriter("stud.txt"));
		Scanner sc = new Scanner(System.in);

		
		String[] str = new String[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("请输入五个名字、成绩");
			str[i] = sc.nextLine();
		}
		
		Set set = new HashSet<String>();
		for(String s: str) {
			String name = s.split(",")[0];
			int math = Integer.parseInt(s.split(",")[1]);
			int english = Integer.parseInt(s.split(",")[2]);
			int chinese = Integer.parseInt(s.split(",")[3]);
			set.add(new Student(name,math,english,chinese));
		}
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			String str2 = (String) iterator.next();
			bfWriter.write(str2);
			bfWriter.newLine();
		}

		bfWriter.close();

	}
}

class Student implements Comparable {
	String name;
	int math;
	int english;
	int chinese;
	int sum;

	public Student(String name, int math, int english, int chinese) {
		// super();
		this.name = name;
		this.math = math;
		this.english = english;
		this.chinese = chinese;
		this.sum();
	}

	public int sum() {
		return sum = math + english + chinese;
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		return sum - s.sum == 0 ? 0 : (sum - s.sum);
	}
}
