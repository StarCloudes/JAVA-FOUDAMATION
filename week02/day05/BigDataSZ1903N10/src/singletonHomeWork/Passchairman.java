package singletonHomeWork;

public class Passchairman {
	private static Passchairman instance;

	
	private Passchairman(){
		
	}
	
	public static Passchairman getInstance() {
		if(instance == null) {
			instance = new Passchairman();
		}
		return instance;
	}
	
	//单例的功能区
	//放置单例的 属性（非静态、公有）
	public Chairman ceo;
	
}
