package com.designPattern.code;

//策略模式， 定义了一系列的算法，将每一种算法封装起来并可以相互替换使用
//策略模式可以使算法独立于使用他的客户应用二独立变化

public class Strategy {
	public static void main(String[] args) {
		BaseService user = new UserService();
		user.setISave(new FileSave()); //注入
		user.setISave(new NetSave());
		user.add("12345");
	}

}

//可变行为抽象出来，定义一系列算法。在使用的时候绑定的是接口，这样的好处是这些行为在可以真正使用的时候互相调用
interface ISave{
	public abstract void save(String data);
}

class FileSave implements ISave{
	public void save(String data) {
		System.out.println("Data save to file: " + data);
	}
}

class NetSave implements ISave{
	public void save(String data) {
		System.out.println("Data save to net: " + data);
	}
}

//1.面向接口编程  2.封装变化  3.多用组合，少用继承
abstract class BaseService{
	
	private ISave iSave;
	public void setISave(ISave iSave) {
		this.iSave = iSave;
	}
	
	public void add(String data) {
		System.out.println("Checking data ...");
		iSave.save(data);
		System.out.println("Success!");
		
	}
}

class UserService extends BaseService{
	
}