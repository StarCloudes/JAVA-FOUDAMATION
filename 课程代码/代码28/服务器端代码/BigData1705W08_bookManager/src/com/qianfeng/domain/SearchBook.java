package com.qianfeng.domain;

public class SearchBook {
	private String id;
	private String name;
	private String category;
	private String maxprice;
	private String minprice;
	public SearchBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchBook(String id, String name, String category, String maxprice, String minprice) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.maxprice = maxprice;
		this.minprice = minprice;
	}
	@Override
	public String toString() {
		return "SearchBook [id=" + id + ", name=" + name + ", category=" + category + ", maxprice=" + maxprice
				+ ", minprice=" + minprice + "]";
	}
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(String maxprice) {
		this.maxprice = maxprice;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
}
