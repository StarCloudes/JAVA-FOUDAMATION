package com.qianfeng.sort;


class Hardware{
	private String brand;
	private int price;
	
	public Hardware(String brand,int price) {
		this.brand = brand;
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}

class Computer extends Hardware{
	GraphCard graphCard;
	
	public Computer(String brand,int price) {
		super(brand,price);
	}
	
	public void application() {
		System.out.print("渲染图形、");
	}
	
	public void playGame() {
		System.out.print("运行游戏、");
	}
	
	public void playVedio() {
		System.out.println("播放视频");
	}
	
	public void getcard(GraphCard graphCard) {
		this.graphCard = graphCard;	
		System.out.println("更换——" + graphCard.getBrand() +"显卡");
	}
	
	
    
}

class GraphCard extends Hardware{
	private String solution;

	public GraphCard(String brand,int price,String solution) {
		super(brand,price);
		this.solution = solution;
	}
	
	public String getSolution() {
		return solution;
	}
	
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	public void render() {
		System.out.println("渲染");
	}

}

class Programmer{
	private String name;
	private Computer c;

	public Programmer(String name) {
       this.setName(name);
       System.out.print("程序员"+ name);
	}
	
	public void buyComputer(Computer c) {
		this.c = c;
		System.out.println("购买——" + c.getBrand() +"电脑");
	}
	
	public void playComputer() {
		System.out.print("玩电脑：");
		c.application();
		c.playGame();
		c.playVedio();
	}
	
	public void changeCard(GraphCard graphCard) {
		c.getcard(graphCard);
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}


public class homework07 {
	public static void main(String[] args) {
		Programmer p = new Programmer("小张");
		Computer c = new Computer("联想",10000);
		GraphCard g1 = new GraphCard("Geforce", 3000 ,"2k");
		GraphCard g2 = new GraphCard("Anti", 6000 ,"4k");
		p.buyComputer(c);
		p.playComputer();
		p.changeCard(g1);
		p.changeCard(g2);
	}

}
