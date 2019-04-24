package com.qianfeng.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.dao.BookDao;
import com.qianfeng.dao.impl.BookDaoImpl;
import com.qianfeng.domain.Book;
import com.qianfeng.domain.PageBook;
import com.qianfeng.domain.SearchBook;
import com.qianfeng.service.BookService;

public class BookServiceImpl implements BookService {
	BookDao bDao = new BookDaoImpl();
	
	public List<Book> findAllBooks() {
		List<Book> list = null;
		try {
			list = bDao.findAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int addBook(Book book) {
		int num = 0;
		try {
			num = bDao.addBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Book findBookById(String id) {
		Book book = null;
		try {
			book = bDao.findBookById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	@Override
	public int updateBookById(Book book) {
		int num = 0;
		try {
			num = bDao.updateBookByid(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int delBookById(String id) {
		int num = 0;
		try {
			num = bDao.delBookByid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}
	
	@Override
	public int[] delBooksByIds(String[] ids) {
		int[] nums = null;
		try {
			nums = bDao.delBooksByIds(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nums;
	}
	
	@Override
	public List<Book> searchBook(SearchBook sBook) {
		List<Book> list = null;
		try {
			list = bDao.searchBook(sBook);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public PageBook findBookByPage(int currentPage, int pageSize) {
		//1.当前的页数  
		//2.当前页的书籍数量
		//3.总的书籍数量
		int totalCount = 0;
		try {
			totalCount = bDao.getCount();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//4.总页数
		int totalPage = (int)Math.ceil(totalCount*1.0/pageSize);
		//5.当前页的所有书籍信息
		List<Book> books = null;
		try {
			books = bDao.findBookByPage(currentPage,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PageBook pBook = new PageBook();
		
		pBook.setBooks(books);
		pBook.setCurrentPage(currentPage);
		pBook.setPagesize(pageSize);
		pBook.setTotalPage(totalPage);;
		pBook.setTotalSize(totalCount);
		
		return pBook;
	}
}
