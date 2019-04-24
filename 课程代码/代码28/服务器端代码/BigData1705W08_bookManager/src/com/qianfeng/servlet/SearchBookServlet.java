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
		
		//获取数据
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
		
		//先将所有空的值转化成空字符串
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
		
		//访问service
		BookService bService = new BookServiceImpl();
		List<Book> books =  bService.searchBook(sBook);
		if (books != null) {
			request.setAttribute("books", books);
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}else {
			//跳回list界面
			System.out.println("查询失败");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
