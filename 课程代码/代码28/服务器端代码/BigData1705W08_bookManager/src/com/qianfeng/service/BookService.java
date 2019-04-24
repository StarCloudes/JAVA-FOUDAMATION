package com.qianfeng.service;

import java.util.List;

import com.qianfeng.domain.Book;
import com.qianfeng.domain.PageBook;
import com.qianfeng.domain.SearchBook;

public interface BookService {

	//�������е��鼮
	List<Book> findAllBooks();

	//���һ����
	int addBook(Book book);

	//����id��ѯ�鼮
	Book findBookById(String id);

	//����id�༭�鼮
	int updateBookById(Book book);

	//����idɾ��һ���鼮
	int delBookById(String id);
	//����idsɾ���౾�鼮
	int[] delBooksByIds(String[] ids);
	
	//��������ѯ
	List<Book> searchBook(SearchBook sBook);

	//��ҳΪ��λ��ѯ�鼮
	PageBook findBookByPage(int currentPage, int pageSize);

}
