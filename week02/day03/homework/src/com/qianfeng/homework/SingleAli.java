package com.qianfeng.homework;

//介绍阿里懂事长

class Chairman{
	
}

class Single{
	private static Single s = null;
	
	Single() {}
	
	public static Single getSingle() {
		if(s ==null) {
			s = new Single();
		} 
		return s;
	}
	
	//功能区属性与方法
	String name;
	String sex;
	int height;
	int salary;
	
	public void setInfo(String name, String sex, int height, int salary) {
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.salary = salary;
	}
	
	
    public void introduce() {
    	System.out.println("阿里主席" +this.name +  "，性别" + this.sex + "，身高" + this.height
    	+ "，薪水" + this.salary + "元");
    }
}


public class SingleAli {
	
	public static void main(String[] args) {
		
		Single s1 = Single.getSingle();
		Single s2 = Single.getSingle();
		
		System.out.println(s1 == s2);
		
//		s1.setInfo("马云", "男", 170, 1);
//		s1.introduce();
//		s2.introduce();
	}	

}
