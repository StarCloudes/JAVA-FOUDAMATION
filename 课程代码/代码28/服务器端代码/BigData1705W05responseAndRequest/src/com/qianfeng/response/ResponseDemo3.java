package com.qianfeng.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class ResponseDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		
		//��֪�ͻ��˲�����ķ���һ
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		//������:ֱ��ÿ�ζ�����ַ�����仯  http://localhost:8081/BigDat1705W05responseAndRequest/ResponseDemo3?time=���ڵ�ʱ��
		
		//���������֤��ͼƬa
		//1.�Լ�����-��Ҫ��ͼ��֪ʶ
		//2.���������ܰ�
		//��һ������:ͼƬ�Ŀ��      �߶�       ���ֵĸ���      �����ߵ�����
		ValidateCode code = new ValidateCode(100,25,4,26);
		
		//ͨ��response���������ͼƬд�����ͻ���
	    code.write(response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
