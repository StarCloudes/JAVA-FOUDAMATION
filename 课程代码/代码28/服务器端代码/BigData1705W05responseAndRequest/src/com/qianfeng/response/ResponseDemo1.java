package com.qianfeng.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * tomcat7�����°汾Ĭ�ϱ�����ISO8859-1,���Ա��������������Ĵ���,��8��ʼ,��utf-8,����Ҫ��������
 * 
 * request:�ӿͻ��˵�������
 * response:�ӷ��������ͻ���
 */
public class ResponseDemo1 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//��һ�ַ�ʽ
		//���ַ�ʽֻ�����÷������˵ı���
		//response.setCharacterEncoding("utf-8");
		//�ڶ��ַ�ʽ
		//����ͬʱ���÷�������ͻ��˵ı���,�ÿͻ�����������ı��뱣��һ��--������õķ���
		response.setContentType("text/html;charset=utf-8");
		//�����ַ�ʽ
		//ͨ��ֱ��������Ӧͷ���Եķ�ʽ
		//response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write("���,����");//ֱ��д�������
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
