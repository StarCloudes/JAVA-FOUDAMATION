package com.qianfeng.service;

import java.util.List;

import com.qianfeng.domain.Book;
import com.qianfeng.domain.PageBook;
import com.qianfeng.domain.SearchBook;

public interface BookService {

	//查找所有的书籍
	List<Book> findAllBooks();

	//添加一本书
	int addBook(Book book);

	//根据id查询书籍
	Book findBookById(String id);

	//根据id编辑书籍
	int updateBookById(Book book);

	//根据id删除一本书籍
	int delBookById(String id);
	//根据ids删除多本书籍
	int[] delBooksByIds(String[] ids);
	
	//多条件查询
	List<Book> searchBook(SearchBook sBook);

	//以页为单位查询书籍
	PageBook findBookByPage(int currentPage, int pageSize);

}
