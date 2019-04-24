package com.qianfeng.Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie cookie = new Cookie("mytime", "");
		cookie.setMaxAge(0);//立即删除
		cookie.setPath(request.getContextPath()+"/CookieDemo");//与CookieDemo中使用的cookie的路径一致
		
		response.addCookie(cookie);//传回客户端  :因为当前的cookie与前面的cookie路径一致,所以认为是一个cookie,它将前面的cookie覆盖了
		
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
