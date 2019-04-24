package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Book;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class ShowBooksServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//����service
		BookService bService = new BookServiceImpl();
		List<Book> list = bService.findAllBooks();
		
		if (list != null) {//��ȡ���ݳɹ�
			//�����ݱ��浽�����
			request.setAttribute("books", list);
			
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}else {//ʧ��
			System.out.println("ʧ����");
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
