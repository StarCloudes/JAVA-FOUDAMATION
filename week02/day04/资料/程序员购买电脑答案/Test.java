package T4;


public class Test {
	public static void main(String[] args) {
		//Hardware h=new Hardware();
		Geforce h1=new Geforce("TCL",1500,"2048x1536");
		Ati h2=new Ati("德力西",2300,"2560x1600");
		Computer c=new Computer();
		//买电脑
		Test t=new Test();
		t.buyComputer(c);
		//电脑开始工作
		c.work();
		c.play();
		//第一次换显卡---Geforce牌的显卡
		t.buy(h1);
		c.setH(h1);
		t.showResolution(h1);
		h1.getRendering();
		c.work();
		c.play();
        //第二次换显卡---Ati牌的显卡
		t.buy(h2);
		c.setH(h2);
		t.showResolution(h2);
		h2.getRendering();
		c.work();
		c.play();
	}
	public void buyComputer(Computer c){
		System.out.println("购买了"+c.getBrand()+"电脑,花了"+c.getPrice()+"元");
	}
	public void useHardware(Geforce h){
		h.getRendering();
	}
	public void buy(Geforce h){
		System.out.println("花了"+h.getPrice()+"元买了"+h.getBrand()+"牌的独立显卡");
	}
	public void useHardware(Ati h){
		h.getRendering();
	}
	public void buy(Ati h){
		System.out.println("花了"+h.getPrice()+"元买了"+h.getBrand()+"牌的独立显卡");
	}
	public void showResolution(Geforce h){
		System.out.println("显卡分辨率"+h.getResolution());
	}
	public void showResolution(Ati h){
		System.out.println("显卡分辨率"+h.getResolution());
	}

}
