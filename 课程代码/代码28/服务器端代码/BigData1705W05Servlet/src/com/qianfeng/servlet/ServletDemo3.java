package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * �����ִ���servlet�ķ�ʽ
 * Ĭ�ϵ�����ʽ��get
 * 
 * ServletDemo3��HttpServlet֮����ģ��ģʽ
 * 
 * ServletDemo3�̳���HttpServlet--�̳���GenericServlet--ʵ����Servlet
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
