package com.qianfeng.single1;
/*
 * 第二种方法:
 * 让董事局主席类只作为董事局主席这个人
 * 单独创建单例类
 */

//单例类
class SingleInstance{
	//作为单例的功能
	private static SingleInstance singleInstance = 	null;
	private SingleInstance () {
		
	}
	public static SingleInstance getInstance() {
		if (singleInstance == null) {
			singleInstance = new SingleInstance();
		}
		return singleInstance;
	}
	
	//功能区
	private  ChairMan chairMan = new ChairMan();
	public ChairMan getChairMan() {
		return chairMan;
	}
	public void setChairMan(ChairMan chairMan) {
		this.chairMan = chairMan;
	}
}
class ChairMan{
	//作为单例的功能
//	private static ChairMan chairMan = null;
//	private ChairMan() {
//		
//	}
//	public static ChairMan getChariMan() {
//		if (chairMan == null) {
//			chairMan = new ChairMan();
//		}
//		return chairMan;
//	}
	
	//作为董事局主席这个人的功能
	String name;
	String sex;
	int height;
	int weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void show(){
		System.out.println("马云的信息");
     }	
}

class Demo2 //深圳
{
	public static void shenzhen() {
		SingleInstance singleInstance = SingleInstance.getInstance();
		ChairMan chairman = singleInstance.getChairMan();
		//第二次使用单例类--直接调取值出来使用
		chairman.show();
	}
}

class Demo3 //哈尔滨
{
	public static void shanghai() {
		SingleInstance singleInstance = SingleInstance.getInstance();
		ChairMan chairman = singleInstance.getChairMan();
		//第三次使用单例类--直接调取值出来使用
		chairman.show();
	}
}
public class SecondMethod //公司总部
{
	public static void main(String[] args) {
		SingleInstance singleInstance = SingleInstance.getInstance();
		//第一次使用单例类--首先完成赋值
		//chairman.setName("马云");
		ChairMan chairman = singleInstance.getChairMan();
		chairman.show();

		//这里是为了实现程序的模拟跳转
		Demo2.shenzhen();
		Demo3.shanghai();
	}
}

