package singletonHomeWork;
/*
 * 将公司的所有员工 抽象出来、形成一个超类（员工类）
 */
public class Employee {
	//员工的共有属性
	private String name;
	private String sex;
	private double height;
	private double salary;
	
	//私有成员对外反问接口-----set、get方法
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public double getHeight() {
		return height;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//无参构造方法
	public Employee() {
		super();
	}
	//带参构造方法
	public Employee(String name, String sex, double height, double salary) {
		super();
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.salary = salary;
	}

	
	
}

