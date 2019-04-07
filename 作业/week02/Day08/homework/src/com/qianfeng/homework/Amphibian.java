package com.qianfeng.homework;

//两栖动物
public class Amphibian {
	public static void main(String[] args) {
		Frog frog = new Frog(1,false);

		System.out.println(frog.sayHello());
		System.out.println(frog.sayHello(2));
		System.out.println(frog.sayHello(5));
	}

}

abstract class Animal {
	public final int HAPPY = 1;
	public final int SAD = 2;
	private boolean mama;
	private int mood;

	public abstract String sayHello();

	public abstract String sayHello(int mood);

	public void setMood(int mood) {
		this.mood = mood;
	}

	public int getMood() {
		return mood;
	}

	public void isMama(boolean mama) {
		this.mama = mama;
	}

	public boolean getMama() {
		return mama;
	}
}

interface land {
	public abstract String isLand();
}

interface water {
	public abstract String isWater();
}

class Frog extends Animal implements land, water {
	Frog() {

	}

	Frog(int mood, boolean mama) {
		this.setMood(mood);
		this.isMama(mama);
	}

	public String sayHello() {
		return "呱呱叫";
	};

	public String sayHello(int mood) {
		String str = null;
		switch (mood) {
		case HAPPY:
			str = "呱呱呱";
			break;
		case SAD:
			str = "扑通一声跳入水中";
			break;
		default:
			str = "呱呱叫";
			break;
		}
		return str;

	};

	public String isLand() {
		return "陆生动物";

	}

	public String isWater() {
		return "水生动物";

	}
}
