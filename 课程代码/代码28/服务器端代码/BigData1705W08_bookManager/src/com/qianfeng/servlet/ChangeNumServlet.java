package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.Book;

public class ChangeNumServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		//创建一个对象,指定id即可
		Book book = new Book();
		book.setId(id);
		
		Map<Book, Integer> map = (Map<Book, Integer>)request.getSession().getAttribute("cart");
		
		//将书从map中删除
		if (num.equals("0")) {
			
			map.remove(book);
		}
		
		//当num>0时,处理其他情况
		Integer num1 = Integer.parseInt(num);
		if (num1>0) {
			map.put(book, num1);
		}
		
		request.getSession().setAttribute("cart", map);
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
