package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Upload1 extends HttpServlet {
/*
 * ʹ���ύ���ķ�ʽ����ͼƬ��ע������:
 * 1.����ʹ��file���͵�input��ǩ
 * 2.����enctype�������ͱ������ó�:multipart/form-data(���������ֽ���)
 * 3.���������ݵķ�ʽ������post
 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		//��ΪͼƬ���ֽ���,��getParameterֻ�ܽ����ַ���,������ڽ���ͼƬ,
		//ֻ�ܽ��յ�����·��,��:C:\Users\Administrator\Desktop\��������\ͼƬ\120.jpg
		//ע��:��Щ��������Խ���ȫ·��,��Щ�����ֻ�ܽ��յ��ļ�������
		String file = request.getParameter("file");
		
	
		
		System.out.println(name+"   "+file);
		
		//ʹ���ֽ�����������
		//��ȡ�ֽ�������
		ServletInputStream sis = request.getInputStream();
		
		byte[] arr = new byte[1024];
		int num = 0;
		while ((num = sis.read(arr)) != -1) {
			//������д�뵽����̨
			System.out.print(new String(arr,0,num));
		}
		
		sis.close();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
