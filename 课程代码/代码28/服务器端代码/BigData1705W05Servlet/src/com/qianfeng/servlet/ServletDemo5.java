package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ServletConfig:һ��servlet�����Ӧһ��config,ͨ��configֻ�ܷ��ʵ�ǰservlet�ڲ�������(�ֲ�������)
 * ServletContext:һ��Ӧ�ö�Ӧһ��context����,ͨ�������Ի�ȡȫ�ֵ�����
 * 
 * 
 * ServletConfig��ʹ��
 * 1.��init�����л�ȡ����
 * 2.��doget��ʹ��
 */
public class ServletDemo5 extends HttpServlet {
	ServletConfig sConfig = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);//���д������д
    	//configҲ����tomcat������������
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
