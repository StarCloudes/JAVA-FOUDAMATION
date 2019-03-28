package com.qianfeng.sort;

public class homework08 {
	public static void main(String[] args) {
		Dog1 dog = new Dog1(1, true);
		System.out.println(dog.sayHello());
		System.out.println(dog.sayHello(1));
		System.out.println(dog.isLand());

	}
}

//protected:的作用范围是当前类和子类
abstract class Animal1 {
	// 属性
	public final int HAPPY = 1;// 情绪高兴
	public final int UNHAPPY = 2;// 情绪烦躁
	protected boolean mamma;// 是否是哺乳
	protected int mood;// 情绪
	// 行为

	public abstract String sayHello();// 普通打招呼

	public abstract String sayHello(int mood);// 带情绪打招呼

	public void setMood(int mood) {
		this.mood = mood;
	}

	public int getMood() {
		return mood;
	}

	public void isMamma(boolean mamma) {
		this.mamma = mamma;
	}

	public boolean getMamma() {
		return this.mamma;
	}
}

//陆生
interface Land {
	public abstract String isLand();
}

//水生
interface Water {
	public abstract String isWater();
}

class Dog1 extends Animal1 implements Land {
	Dog1() {

	}

	Dog1(int mood, boolean mamma) {
		this.setMood(mood);
		this.mamma = mamma;
	}

	public String sayHello() {
		return "摇尾巴";
	}

	public String sayHello(int mood) {
		String tempStr = null;
		switch (mood) {
		case HAPPY:
			tempStr = "汪汪叫";
			break;
		case UNHAPPY:
			tempStr = "呜呜";
			break;
		default:
			tempStr = "摇尾巴";
			break;
		}

		return tempStr;
	}

	public String isLand() {
		return "狗是陆生生物";
	}
}
