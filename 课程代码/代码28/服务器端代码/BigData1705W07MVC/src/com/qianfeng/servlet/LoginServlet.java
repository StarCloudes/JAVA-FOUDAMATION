package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.domain.User;
import com.qianfeng.service.UserService;
import com.qianfeng.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//获取账号密码
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		
		//访问service层
		UserService uService = new UserServiceImpl();
		User user = uService.login(name,pwd);
		
		if (user != null) {//登录成功
			//将用户信息存入session 
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {//登录失败
			//返回登录界面
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
