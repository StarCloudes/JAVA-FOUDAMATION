package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 第三种创建servlet的方式
 * 默认的请求方式是get
 * 
 * ServletDemo3与HttpServlet之间是模板模式
 * 
 * ServletDemo3继承自HttpServlet--继承自GenericServlet--实现了Servlet
 */
public class ServletDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet3");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
