package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * �ڶ��ִ���servlet�ķ���
 * ����ServletDemo2�̳���GenericServlet ,ʵ����Servlet�ӿ�
 * ��GenericServlet����,�Ѿ���Servlet�����з�����ʵ����,������ʵ�ֹ��ܵ�ʱ��,ֻ��Ҫ����
 * GenericServlet������,��������д������Ҫ�ķ�������.���ǰ�����ģʽ��������ģʽ
 */
public class ServletDemo2 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service2");

	}

}
