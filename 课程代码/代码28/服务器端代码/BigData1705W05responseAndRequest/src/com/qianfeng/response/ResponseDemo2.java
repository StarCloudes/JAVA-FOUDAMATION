package com.qianfeng.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {
 
	/*
	 * ֱ�ӽ�ͼƬ���ͻؿͻ���
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//����ͻ���ͼƬ��ʾ������,���Խ���ǰ�ı���ȥ��
		//response.setContentType("text/html;charset=utf-8");
		
		//��ͼƬ
		ServletContext sContext = getServletContext();
		String url = sContext.getRealPath("WEB-INF\\classes\\��Ů1.jpg");
		
		//��ȡͼƬ������
		int index = url.lastIndexOf("\\")+1;
		String filename = url.substring(index);
		
		//���ͼƬ�����������ĵĽ���취
		//����encode����       ��һ������:��Ҫ������ı�     �ڶ�������:ָ���ı���
		String newName = URLEncoder.encode(filename,"utf-8");
		
		//��ͼƬ���뵽�ڴ�
		FileInputStream fis = new FileInputStream(url);
		
		//��ͼƬд��������(�ͻ���)
		ServletOutputStream sos = response.getOutputStream();
		
		//���ÿͻ�������
		response.setHeader("content-disposition","attachment;filename="+newName);
		
		//ͼƬ�Ĵ���
		byte[] arr = new byte[1024];
		int num;
		while ((num = fis.read(arr))!= -1) {
			sos.write(arr,0,num);
			
			sos.flush();
		}
		
		fis.close();
		sos.close();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
	}

}
