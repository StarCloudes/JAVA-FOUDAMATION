package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qianfeng.domain.Book;
import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class AddBookToCartServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		BookService bService = new BookServiceImpl();
		Book book = bService.findBookById(id);
		
		HttpSession hSession = request.getSession();
		//获取购物车
		Map<Book, Integer> map = (Map<Book, Integer>)hSession.getAttribute("cart");
		
		int num = 1;
		
		//如果没有购物车,就创建一个
		if (map == null) {
			map = new HashMap<Book, Integer>();
		}
		//看购物车中是否包含当前的书,如果包含,就将数量+1
		if (map.containsKey(book)) {
			num = map.get(book)+1;
		}
		//用现在书籍的数量覆盖原来的数量
		map.put(book, num);
		
		//将购物车放回session
		hSession.setAttribute("cart", map);
		
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
		
//		out.println("<a href='"+request.getContextPath()+"/PageBookServlet?currentPage=1'>继续购物</a>");
//		out.println("<a href='"+request.getContextPath()+"/cart.jsp'>到购物车</a>");
		
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
