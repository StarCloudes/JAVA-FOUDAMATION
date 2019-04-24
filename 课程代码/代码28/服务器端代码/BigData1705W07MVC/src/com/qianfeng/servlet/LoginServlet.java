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
		
		//��ȡ�˺�����
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		
		//����service��
		UserService uService = new UserServiceImpl();
		User user = uService.login(name,pwd);
		
		if (user != null) {//��¼�ɹ�
			//���û���Ϣ����session 
			request.getSession().setAttribute("user", user);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}else {//��¼ʧ��
			//���ص�¼����
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
