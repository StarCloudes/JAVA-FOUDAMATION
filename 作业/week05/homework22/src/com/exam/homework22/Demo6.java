package com.exam.homework22;

import java.util.Scanner;

public class Demo6 {
	public static void main(String[] args) {
		Student s1 = new Student("xiaoming", "01");
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生的考试成绩：");
		int examScore = MathUtil.abs(scanner.nextInt());
		System.out.println("请输入学生的平时成绩：");
		int score = MathUtil.abs(scanner.nextInt());
		System.out.println("学生的总成绩："+s1.sumScore(score,examScore));
		System.out.println(s1);
	}
}


class Student{
	//属性：姓名,班级，考试成绩，平时成绩，总成绩
	String nameString;
	String classString;
//	int score;
//	int examScore;
	int sumScore;
	
	public Student(String nameString,String classString) {
		this.nameString = nameString;
		this.classString = classString;
	}
	
	public int sumScore(int score,int examScore) {
		return sumScore = (int)(examScore*0.6+score*0.4);
	}

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", classString=" + classString + "]";
	}
	
}