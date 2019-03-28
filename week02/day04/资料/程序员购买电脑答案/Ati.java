package T4;

public class Ati extends Hardware{
	private String name="Ati";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ati() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Ati(String brand, int price, String resolution) {
		super(brand, price, resolution);
	}

	public void getRendering(){
		System.out.println("使用Ati显卡开始渲染");
	}

}
