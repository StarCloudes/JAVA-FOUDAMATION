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
		
		//��ȡid
		String[] ids = request.getParameterValues("ids");
		
		//����service
		BookService bService = new BookServiceImpl();
		int[] nums =  bService.delBooksByIds(ids);
		if (nums != null) {
			
			request.getRequestDispatcher("/ShowBooksServlet").forward(request, response);
		}else {
			//����list����
			System.out.println("ɾ��ʧ��");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
