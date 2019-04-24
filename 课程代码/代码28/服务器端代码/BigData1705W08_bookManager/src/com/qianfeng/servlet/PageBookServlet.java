package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Book;
import com.qianfeng.domain.PageBook;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class PageBookServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//��ȡ��ǰ��ҳ��
		String cupageString = request.getParameter("currentPage");
		int currentPage = Integer.parseInt(cupageString);
		//����ÿҳ���鼮����
		int pageSize = 4;
		
		//����service
		BookService bService = new BookServiceImpl();
		PageBook pBook =  bService.findBookByPage(currentPage,pageSize);
		if (pBook.getBooks() != null) {
			request.setAttribute("pbook", pBook);
			request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		}else {
			//����list����
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
