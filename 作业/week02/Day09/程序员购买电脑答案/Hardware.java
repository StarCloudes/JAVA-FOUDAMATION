package T4;

public class Hardware {
	private String brand;
	private int price;
	private String name="";
	private String resolution;
	
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public Hardware(String brand, int price, String resolution) {
		super();
		this.brand = brand;
		this.price = price;
		this.resolution = resolution;
	}
	public Hardware() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void getRendering (){
	}
}
