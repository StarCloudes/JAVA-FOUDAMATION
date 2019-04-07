package T4;

public class Geforce extends Hardware{
	private String name="Geforce";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Geforce() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Geforce(String brand, int price, String resolution) {
		super(brand, price, resolution);
	}

	public void getRendering(){
		System.out.println("使用Geforce显卡开始渲染");
	}

}
