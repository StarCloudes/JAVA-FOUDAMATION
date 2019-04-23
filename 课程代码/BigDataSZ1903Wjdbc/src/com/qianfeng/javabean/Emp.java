package com.qianfeng.javabean;
/*
 * 创建模型的4步
 * 1.要有属性
 * 2.要有get,set
 * 3.要有构造方法(空参,有参)
 * 4.重写toString
 */
public class Emp {//一般让模型的类名与表名一致
	private String empno;//一般让模型的属性名字与表的字段名字一致,方便操作
	private String ename;
	private String job;
	private double sal;
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + "]";
	}
	public Emp(String empno, String ename, String job, double sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}

}
