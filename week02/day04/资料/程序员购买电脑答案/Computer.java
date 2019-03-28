package T4;

public class Computer {
	private String brand="戴尔";
	private int price=5000;
	//private Hardware h=new Hardware();
	string morenxianka = jichengxianka;
	Geforce g;
	Ati a;
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
	
	

	public Computer(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void play (){
		if(h.getName()==""){
			System.out.println("玩lol,一路俯冲青铜5");
			System.out.println("对人生产生了怀疑,开始升级配置");
			System.out.println("------------配置升级中-----------");
		}
		if(h.getName()=="Geforce"){
			System.out.println("游戏体验有了明显提升,但还不够酸爽");
			System.out.println("------------配置升级中-----------");
		}
		if(h.getName()=="Ati"){
			System.out.println("一顿操作,妈妈我上大师了");
		}				
	}
	public void work (){
		if(h.getName()==""){
			System.out.println("正在使用原装配置敲代码,突然蓝屏");
		}
		if(h.getName()=="Geforce"){
			System.out.println("更换了Geforce独立显卡,花了"+h.getPrice()+"元,虽然卡顿,但可以忍耐");
		}
		if(h.getName()=="Ati"){
			System.out.println("更换了Ati独立显卡,花了"+h.getPrice()+"元,飞一般的感觉,神一样的流畅度,感觉自己要上天");
		}				
	}
}
