package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Book;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class FindBookByIdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取id
		String id = request.getParameter("id");
		
		//访问service
		BookService bService = new BookServiceImpl();
		Book book =  bService.findBookById(id);
		if (book != null) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
		}else {
			//跳回list界面
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
