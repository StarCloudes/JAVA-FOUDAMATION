package singletonHomeWork;

public class Test_singleton {
	public static void main(String[] args) {
		//单例------通过getgetChairman()来获取Chairman的 唯一对象
		Chairman ceo = Chairman.getChairman();
		
		//正常类，直接new对象
		Senior_executive se = new Senior_executive();
		
		//通过单例传值
		ceo.passchairmanA();
		se.passchairmanB();
		
		//高管的介绍方法
		se.introducing();
	}
}
