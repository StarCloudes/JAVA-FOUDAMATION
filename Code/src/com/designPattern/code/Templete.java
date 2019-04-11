package com.designPattern.code;

//定义算法的骨架，将可变部分的实现延迟到子类当中。模板方法模式可以不改变一个算法的结构即
//可重新定义该算法的某些特定的步骤。
//举🌰，煎饼果子里面的馅可由别人根据自己的口味定义
public class Templete {
	public static void main(String[] args) {
		UserManager uManager = new UserManager();
		uManager.action("admin", "add");
		uManager.action("test", "add");
	}

}
abstract class BaseManager{
	public void action(String name,String method) {
		if(name.equals("admin")) {
			excute(method);
		}else {
			System.out.println("Not Admin User!");
		}
	}
	
	public abstract void excute(String method);
}
class UserManager extends BaseManager{
	public void excute(String method) {
		if("add".equals(method)) {
			System.out.println("Add operation");
		}else if("del".equals(method)) {
			System.out.println("Del operation");
		}
	}
}