package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.domain.Book;
import com.qianfeng.domain.SearchBook;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class SearchBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//��ȡ����
		SearchBook sBook = new SearchBook();
		try {
			BeanUtils.populate(sBook, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�Ƚ����пյ�ֵת���ɿ��ַ���
		if (sBook.getId() == null) {
			sBook.setId("");
		}
		if (sBook.getName() == null) {
			sBook.setName("");
		}
		if (sBook.getCategory() == null) {
			sBook.setCategory("");
		}
		if (sBook.getMaxprice() == null) {
			sBook.setMaxprice("");
		}
		if (sBook.getMinprice() == null) {
			sBook.setMinprice("");
		}
		
		//����service
		BookService bService = new BookServiceImpl();
		List<Book> books =  bService.searchBook(sBook);
		if (books != null) {
			request.setAttribute("books", books);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}else {
			//����list����
			System.out.println("��ѯʧ��");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
