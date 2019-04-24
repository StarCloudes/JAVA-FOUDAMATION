package com.qianfeng.domain;

import java.util.List;

public class PageBook {
	private int currentPage;//��ǰ��ҳ��
	private int pagesize;//��ǰҳ���鼮����
	private int totalPage;//��ҳ��
	private int totalSize;//������
	private List<Book> books;//��ǰҳ���鼮����
	public PageBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBook(int currentPage, int pagesize, int totalPage, int totalSize, List<Book> books) {
		super();
		this.currentPage = currentPage;
		this.pagesize = pagesize;
		this.totalPage = totalPage;
		this.totalSize = totalSize;
		this.books = books;
	}
	@Override
	public String toString() {
		return "PageBook [currentPage=" + currentPage + ", pagesize=" + pagesize + ", totalPage=" + totalPage
				+ ", totalSize=" + totalSize + ", books=" + books + "]";
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
