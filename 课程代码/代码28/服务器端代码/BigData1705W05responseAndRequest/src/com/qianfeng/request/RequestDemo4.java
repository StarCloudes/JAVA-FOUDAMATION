package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo4 extends HttpServlet {

	/*
	 * �ض���������ת��
	 * 
	 * ��ͬ��:������ʵ������������л�
	 * 
	 * ��ͬ��:
	 * �ض���:
	 * 1.�ͻ���Ҫ��������
	 * 2.��ַ����ʾ������ַ
	 * 3.���β��������ɿͻ�����ɵ�
	 * 4.���Է����ⲿ��ַ(��ַ)
	 * 5.���ʹ����µ�servlet����ʱ,��������:request.getContextPath()+����·��
	 * 6.����ͨ��request����ʵ������������֮�䴫ֵ
	 * ����ת��:
	 * 1.�ͻ���ֻ��Ҫ����һ��
	 * 2.��ַ����ʾһ����ַ
	 * 3.һ�οͻ���,һ�η�������
	 * 4.ֻ����Ӧ���ڷ���
	 * 5.��������:����·��
	 * 6.����ʵ������������֮�䴫ֵ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//ʵ���ض���
		//testDirect(request, response);
		//ʵ������ת��	
		testForword(request, response);
	
	}
	
	//ʵ���ض���
	public static void testDirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * �û�:����   �������Ǯ
		 * 
		 *  demo4:��û��Ǯ,��ȥ��demo5���
			demo4:��ϲ���Ǯ�ɹ�
			demo5:û����,����,�ҽ����10��
		 */
		
		System.out.println("demo4:��û��Ǯ,��ȥ��demo5���");
		
		//�ض���
		//����:Ҫ������ת����ַ---demo5�ķ��ʵ�ַ
		//��Ϊ�����Ǵӿͻ������·���������,����Ҫдȫ��ַ  http://localhost:8081/BigData1705W05responseAndRequest/RequestDemo5
		//�������� ����ʡ��:http://localhost:8081.��Ϊ��ͬһ������������
		//BigData1705W05responseAndRequest����Դ�ڷ������ϵ�·��,��Ϊ�ض��������½�������,Ӧ���ⲿ������,���Ե�ǰ��·��������ʡ��
		//getContextPath():��Դ�ڷ������ϵ�·��
		//response.sendRedirect(request.getContextPath()+"/RequestDemo5");
		
		System.out.println("demo4:��ϲ���Ǯ�ɹ�");
		
		//���ʰٶȵĵ�ַ
		response.sendRedirect("http://www.baidu.com");
	}
	//ʵ������ת��
	public static void testForword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /*
		  * demo4:��û��Ǯ,��ȥ��demo5���
			demo5:û����,����,�ҽ����10��
			demo4:��ϲ���Ǯ�ɹ�
		  */
		System.out.println("demo4:��û��Ǯ,��ȥ��demo5���");
		//����ת��--ʵ�ַ���demo5:������Ϊʼ��û�г���ǰ��Ӧ��,����ֻ��ҪдӦ���ڵķ���·������
		//forward:ʵ�ֵ��Ƕ�request��response����Ĵ���
		
		//ͨ��requestʵ�ִ�ֵ:��ֵ�󶨵�request������
		request.setAttribute("01", "bingbing");
		
		// http://localhost:8081/BigData1705W05responseAndRequest����ʡ��
		request.getRequestDispatcher("/RequestDemo5").forward(request, response);;
		
		System.out.println("demo4:��ϲ���Ǯ�ɹ�");
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
