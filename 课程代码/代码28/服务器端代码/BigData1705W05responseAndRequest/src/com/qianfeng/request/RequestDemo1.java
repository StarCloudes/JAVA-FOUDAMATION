package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {
	/*
	 * ����֪ʶ�ܽ�:
	 * 1.servlet
	 * 		>servlet��4�д�����ʽ
	 * 			ʵ��servlet�ӿ�
	 * 			�̳�GenericServlet��            ������ģʽ
	 * 			�̳�HttpServlet��                    ģ�����ģʽ
	 * 			ͨ��ֱ�Ӵ���servlet���͵��ļ�ʵ��(�������һ��)
	 *       ��ǰ������Ҫ��web.xml����ɵ�ǰservlet��ע��
	 *       >��������:��servlet�Ĵ���������         
	 *          service  �������úܶ��   �����ķ���ֻ����һ��
	 *       >ServletConfig     ��Ӧ��������:��ǰ��servlet����
	 *       >ServletContext              ��ǰ��Ӧ��
	 *       	��ȡȫ�ֵ�����
	 *       	��������
	 *       	ͨ�����·����ȡ����·��
	 *       servlet,config,context����Ĵ��������ٶ�����tomcat������ʵ�ֵ�
	 *       >·��ƥ��
	 *       	���������
	 *       	*
	 *        	*.����(*.do)
	 *        ���ȼ�   ���ν���
	 * 2.http
	 * 		>����
	 * 			������Ϣ��         
	 * 				����ʽ       �������Դ·��
	 * 			������Ϣͷ
	 * 				������Ϣ
	 * 			������Ϣ��
	 * 				��Post����ʽ�µ���������
	 * 		>��Ӧ
	 * 			��Ӧ��Ϣ��
	 * 				״̬��
	 * 			��Ӧ��Ϣͷ
	 * 				������Ϣ  : �Ƿ������������     ,����,ˢ��
	 * 			��Ӧ��Ϣ��
	 * 				����
	 * 3.get��post������
	 * 4.response
	 * 		>����  ���ַ�ʽ
	 * 		ע���:�ȱ����ٻ�ȡ��
	 * 		>����ͼƬ--ʹ���ֽ���
	 * 		>��֤��ͼƬ����������
	 * 
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ϣ��
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println(request.getMethod());//���󷽷�
		System.out.println(request.getContextPath());//��Դ�ڷ������ϵ�·��
		System.out.println(request.getRequestURI());//��Դ�ڷ������ϵķ���·��
		System.out.println(request.getRequestURL());//ȫ·��
		System.out.println(request.getQueryString());//?����Ĳ���
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
