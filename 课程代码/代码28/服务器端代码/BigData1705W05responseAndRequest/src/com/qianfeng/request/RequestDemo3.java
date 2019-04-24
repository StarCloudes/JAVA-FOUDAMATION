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
		 * get��ʽ����������Ĵ���
		 * 
		 * �ٱ����ٽ���
		 * ע���:�����ʱ�������û�а취���,�����ʱ���������Խ��
		 */
		
		String name = request.getParameter("user");
		System.out.println(name);
		
		//�ٱ���
		byte[] temp = name.getBytes("ISO8859-1");
		//�ڽ���
		String newString = new String(temp,"utf-8");
		System.out.println(newString);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
