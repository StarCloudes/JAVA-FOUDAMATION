package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * servlet:�Ƿ������˵�һ��СӦ�ó���(.java�ļ�),�������һ������Ĺ���
 * servlet����������:��servlet���� ���������ٵĹ���
 * servlet����tomcat������������,Ҳ����tomcat���������ٵ�
 * 
 * servlet�������������:
 * 1.ServletDemo1(���췽��)  ִ��һ��   
 * 2.init(��ʼ������)   ִ��һ��   
 * 3.service(�ṩ����ķ���)    ִ�ж��
 * 4.destroy(���ٵķ���)  ִ��һ��   
 * 
 * sevlet���ص�:
 * 1.service����ִ�ж��
 * 2.serlvet����һ��,ʹ�ö��.�ô�:��ʡ�ڴ�
 * 3.servlet���������ŷ������Ĺرն�����
 * 4.���еķ��������Զ������õ�
 */

/*
 * ��һ�ִ���servlet�ķ���
 */
public class ServletDemo1 implements Servlet {
	//���췽��
	public  ServletDemo1() {
		System.out.println("SevletDemo1");
	}

	//����ǰ���������
	@Override
	public void destroy() {
		System.out.println("destroy");

	}


	//��ʼ������
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");

	}

	//������ṩ����ķ���(�����ķ���)
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}

	//�õ����ö���
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	//�õ�һЩservlet����Ϣ
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
