package com.qianfeng.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * tomcat7及以下版本默认编码是ISO8859-1,所以必须进行中文乱码的处理,从8开始,是utf-8,不需要处理中文
 * 
 * request:从客户端到服务器
 * response:从服务器到客户端
 */
public class ResponseDemo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//第一种方式
		//这种方式只能设置服务器端的编码
		//response.setCharacterEncoding("utf-8");
		//第二种方式
		//可以同时设置服务器与客户端的编码,让客户端与服务器的编码保持一致--这是最常用的方法
		response.setContentType("text/html;charset=utf-8");
		//第三种方式
		//通过直接设置响应头属性的方式
		//response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("你好,朗普");//直接写回浏览器
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
