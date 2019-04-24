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
		
		//访问service
		BookService bService = new BookServiceImpl();
		List<Book> list = bService.findAllBooks();
		
		if (list != null) {//获取数据成功
			//将数据保存到域对象
			request.setAttribute("books", list);
			
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}else {//失败
			System.out.println("失败了");
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
