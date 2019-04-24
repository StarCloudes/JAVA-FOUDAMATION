package com.qianfeng.dao;

import java.sql.SQLException;
import java.util.List;

import com.qianfeng.domain.Book;
import com.qianfeng.domain.SearchBook;

public interface BookDao {
	
	List<Book> findAllBooks() throws SQLException;

	int addBook(Book book)throws SQLException;

	Book findBookById(String id)throws SQLException;

	int updateBookByid(Book book)throws SQLException;

	int delBookByid(String id)throws SQLException;

	int[] delBooksByIds(String[] ids)throws SQLException;

	List<Book> searchBook(SearchBook sBook)throws SQLException;

	int getCount()throws SQLException;

	List<Book> findBookByPage(int currentPage, int pageSize)throws SQLException;

}
