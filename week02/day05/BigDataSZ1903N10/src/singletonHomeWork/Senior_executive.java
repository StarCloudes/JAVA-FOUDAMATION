package singletonHomeWork;

public class Senior_executive extends Employee {
	
	//因为需要知道老大的各种属性才能介绍老大
	Chairman ceo;
	
	//高管的构造方法
	public Senior_executive(){
		//继承父类Employee的带参构造方法
		super("Ya Nan", "female", 175.5, 20000);
	}
	
	//高管介绍方法。
	public void introducing() {
		
		System.out.println("Welcome to our company！my friend, you can call me "+ this.getName() + ". Today I am  your guider.");
		System.out.println("The chairman of our company is "+ceo.getName() + ",He is "+ceo.getHeight()
							+" centimeters tall and " + ceo.getSex()+ ",His salary is " + ceo.getSalary()+" monthly.");
		//悄悄告诉你，我们的董事长是真的好，对员工好，对合作企业也非常好。你来我们这儿投资绝对没错的！
		System.out.println("To tell you quietly, our Ma ge is really good, good for employees, and very friendly for cooperative enterprises.");
		System.out.println("You're absolutely right to invest in us! ");
	}
	
	//用于单例传值
	public void passchairmanB() {
		Passchairman passing = Passchairman.getInstance();
		ceo = passing.ceo;
	}
}
