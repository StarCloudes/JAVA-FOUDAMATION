package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ServletContext:
 * 1.获取全局变量
 * 2.共享数据
 * 3.通过资源在服务器上应用内的相对路径获取绝对路径
 * 
 * 
 * 比较:与config的共同点:都是由tomcat服务器创建
 */
public class ServletDemo6 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取context对象
		ServletContext sContext = getServletContext();
		
		 //* 1.获取全局变量
		out.println(sContext.getInitParameter("code"));
		 //* 2.共享数据
		out.println(sContext.getAttribute("天宫一号"));
		out.println(sContext.getAttribute("天宫二号"));
		 //* 3.通过资源在服务器上应用内的相对路径获取绝对路径
		//这里的相对路径,指的是从当前的工程开始的路径
		//区分两个路径:a.资源的原始路径      D:\javawork\BigData1705W05Servlet\src\com\qianfeng\servlet\b.properties
		//b.资源在服务器上的路径  D:\javawork\.metadata\.me_tcat7\webapps\BigData1705W05Servlet\WEB-INF\classes\com\qianfeng\servlet\b.properties
		String url = sContext.getRealPath("WEB-INF\\classes\\com\\qianfeng\\servlet\\b.properties");
		out.println(url);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
