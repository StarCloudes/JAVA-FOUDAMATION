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
		//��ȡ���ﳵ
		Map<Book, Integer> map = (Map<Book, Integer>)hSession.getAttribute("cart");
		
		int num = 1;
		
		//���û�й��ﳵ,�ʹ���һ��
		if (map == null) {
			map = new HashMap<Book, Integer>();
		}
		//�����ﳵ���Ƿ������ǰ����,�������,�ͽ�����+1
		if (map.containsKey(book)) {
			num = map.get(book)+1;
		}
		//�������鼮����������ԭ��������
		map.put(book, num);
		
		//�����ﳵ�Ż�session
		hSession.setAttribute("cart", map);
		
		
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
		
//		out.println("<a href='"+request.getContextPath()+"/PageBookServlet?currentPage=1'>��������</a>");
//		out.println("<a href='"+request.getContextPath()+"/cart.jsp'>�����ﳵ</a>");
		
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
