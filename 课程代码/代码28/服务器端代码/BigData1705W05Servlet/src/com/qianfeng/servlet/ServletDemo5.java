package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ServletConfig:一个servlet对象对应一个config,通过config只能访问当前servlet内部的数据(局部的数据)
 * ServletContext:一个应用对应一个context对象,通过他可以获取全局的数据
 * 
 * 
 * ServletConfig的使用
 * 1.在init方法中获取对象
 * 2.在doget中使用
 */
public class ServletDemo5 extends HttpServlet {
	ServletConfig sConfig = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);//这行代码必须写
    	//config也是由tomcat服务器创建的
    	sConfig = config;
    }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String mycode = sConfig.getInitParameter("code");
		out.print(mycode);
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
