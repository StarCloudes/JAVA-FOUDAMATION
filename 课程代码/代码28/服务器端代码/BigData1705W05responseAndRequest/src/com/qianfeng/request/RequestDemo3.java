package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		/*
		 * get方式下中文乱码的处理
		 * 
		 * 再编码再解码
		 * 注意点:编码的时候出问题没有办法解决,解码的时候出问题可以解决
		 */
		
		String name = request.getParameter("user");
		System.out.println(name);
		
		//再编码
		byte[] temp = name.getBytes("ISO8859-1");
		//在解码
		String newString = new String(temp,"utf-8");
		System.out.println(newString);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
