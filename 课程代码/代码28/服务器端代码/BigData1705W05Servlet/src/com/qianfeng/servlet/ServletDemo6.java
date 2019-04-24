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
 * 1.��ȡȫ�ֱ���
 * 2.��������
 * 3.ͨ����Դ�ڷ�������Ӧ���ڵ����·����ȡ����·��
 * 
 * 
 * �Ƚ�:��config�Ĺ�ͬ��:������tomcat����������
 */
public class ServletDemo6 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//��ȡcontext����
		ServletContext sContext = getServletContext();
		
		 //* 1.��ȡȫ�ֱ���
		out.println(sContext.getInitParameter("code"));
		 //* 2.��������
		out.println(sContext.getAttribute("�칬һ��"));
		out.println(sContext.getAttribute("�칬����"));
		 //* 3.ͨ����Դ�ڷ�������Ӧ���ڵ����·����ȡ����·��
		//��������·��,ָ���Ǵӵ�ǰ�Ĺ��̿�ʼ��·��
		//��������·��:a.��Դ��ԭʼ·��      D:\javawork\BigData1705W05Servlet\src\com\qianfeng\servlet\b.properties
		//b.��Դ�ڷ������ϵ�·��  D:\javawork\.metadata\.me_tcat7\webapps\BigData1705W05Servlet\WEB-INF\classes\com\qianfeng\servlet\b.properties
		String url = sContext.getRealPath("WEB-INF\\classes\\com\\qianfeng\\servlet\\b.properties");
		out.println(url);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
