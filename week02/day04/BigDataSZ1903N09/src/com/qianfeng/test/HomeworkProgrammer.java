package com.qianfeng.test;

public class HomeworkProgrammer {
	public static void main(String[] args) {
		String name;//属性名:name
		name="凯哥";
		HomeworkProgrammer pro=new HomeworkProgrammer();//创建对象
		Computer computer = new Computer();
		computer.brand="A品牌";//将电脑品牌设置为A品牌
		computer.price=10000;
		
		//pro.buyComputer(name,Computer.brand,10000);	//调用buyComputer方法
		pro.useComputer();//调用useComputer方法
		System.out.println("他使用了一段时间,觉得显卡不够给那里");
		
		
		Geforce gef=new Geforce("A品牌","1366x768",2000);//给Gefore显卡的属性赋值
		pro.changeGpu(gef.brand,gef.price,gef.screenResolution);
		pro.useComputer();//调用useComputer方法
		System.out.println("使用了一段时间,他又发现了更好的显卡");
		
		Ati ati=new Ati("B品牌","1900x1600",4000);//给Ati显卡赋值
		pro.changeGpu(ati.brand, ati.price, ati.screenResolution);
		pro.useComputer();//调用useComputer方法
		

		
	
		
		

	}
	
	public  void buyComputer(String name,String brand,int price) {
		
		System.out.println(name+"去电脑店买了一台"+price+"元"+brand+"的电脑");
	}
	public void useComputer() {
		System.out.print("他使用电脑");
		Computer.runProgram();
		Computer.playGame();
		Computer.playVideo();		
	}
	public void changeGpu(String brand,int price,String screenResolution) {
		System.out.println("最后他换了品牌为"+brand+"价格为"+price+"分辨率为"+screenResolution+"显卡");
	}
	}	


class Computer{
	 String brand;//电脑品牌
	 int price;//电脑的价格
	
	public static void runProgram() {//3种行为
		System.out.print("  运行程序");
	}
	public static  void playGame() {
		System.out.print("  玩游戏");
	}
	public static void playVideo() {
		System.out.println("  播放视频");
		
	}
	
}


class Gpu{
	 String brand;
	 int price;
	 String screenResolution;//分辨率
	 public Gpu(String brand,String screenResolution,int price) {
		this.brand=brand; 
		this.price=price;
		this.screenResolution=screenResolution;
		System.out.println("价格为"+this.price+",分辨率为"+"的"+this.brand+"显卡渲染图片效果更好");
	}
	
}



class Geforce extends Gpu{

	public Geforce(String brand, String screenResolution, int price) {
		super(brand, screenResolution, price);//表示使用父类的brand,screenResolution,price属性
		// TODO Auto-generated constructor stub
	}
	
	
}
class Ati extends Gpu{

	public Ati(String brand, String screenResolution, int price) {
	super(brand, screenResolution, price);
		
		// TODO Auto-generated constructor stub
	}
	
}