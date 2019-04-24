package com.qianfeng.domain;

public class Book {
	private String id;
	private String name;
	private int price;
	private int pnum;
	private String category;
	private String description;
	private String img_url;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", pnum=" + pnum + ", category=" + category
				+ ", description=" + description + ", img_url=" + img_url + "]";
	}
	
	//重写hashcode方法
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return id.hashCode();
	}
	
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) {
			throw new RuntimeException("与Book类型不匹配");
		}
		
		Book book = (Book)obj;
		return id.equals(book.id);
	}
	
}
