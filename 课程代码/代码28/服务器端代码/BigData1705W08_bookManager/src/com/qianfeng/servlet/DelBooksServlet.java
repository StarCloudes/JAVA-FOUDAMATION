package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.service.BookService;
import com.qianfeng.service.impl.BookServiceImpl;

public class DelBooksServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取id
		String[] ids = request.getParameterValues("ids");
		
		//访问service
		BookService bService = new BookServiceImpl();
		int[] nums =  bService.delBooksByIds(ids);
		if (nums != null) {
			
			request.getRequestDispatcher("/ShowBooksServlet").forward(request, response);
		}else {
			//跳回list界面
			System.out.println("删除失败");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
