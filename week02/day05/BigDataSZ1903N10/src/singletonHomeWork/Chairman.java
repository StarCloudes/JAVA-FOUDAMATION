package singletonHomeWork;
/*
 *  公司的 大哥大--------只有一个，因此，给他来个单例模式！！！
 */

public class Chairman extends Employee {
	//先给定义一个 自身的对象的引用-----static关键字用来保证这个引用只有一个值
	//private用来保证外部不能直接通过"类名.成员变量名"来访问这个引用；
	private static Chairman ceo;
	
	//将 构造方法私有化-----保证外部不能直接通过"new"来创建对象
	private Chairman() {
		//继承父类Employee的带参构造方法
		super("Ma Yun", "male", 159.9, 999999.9);
	}

	//懒汉式的 单例模式，只有当没有 董事长的时候，才new一个
	public static Chairman getChairman() {
		if(ceo == null) {
			ceo = new Chairman();
		}
		return ceo;
	}
	
	//董事长自己有的方法（召开会议）
	public static void holdMeeting() {
		System.out.println("小王，你去通知一下，今天下班后，各部门总监留一下，18:00开个会。");
	}
	
	public void passchairmanA() {
		Passchairman passing = Passchairman.getInstance();
		passing.ceo = ceo;
	}
}
