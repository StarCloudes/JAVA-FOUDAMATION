package com.qianfeng.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		//�ڶ��η���
		Cookie[] cookies = request.getCookies();
		//System.out.println(cookies.length);
		if (cookies != null) {//�ж��Ƿ��ǵ�һ�η��ʷ�����
			//ȡ������Ҫ��cookie
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String key = cookie.getName();
				String value = cookie.getValue();
				if (key.equals("mytime")) {//˵�������ǵ�cookie
					 System.out.println(value);
					 
					 //д�ؿͻ���
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 long time = Long.parseLong(value);
					 String newtime = sdf.format(new Date(time));
					 out.write("���ϴε�¼��ʱ����:"+newtime);
					 out.write("<a href='"+request.getContextPath()+"/ClearServlet'>clear</a>");
				}
			}
			
		}
		
		//��һ�η���
		//����cookie����,�Լ�ֵ�Ե���ʽ��ֵ--ֻ�ܴ洢�ַ���
		Cookie cookie = new Cookie("mytime",new Date().getTime()+"");
		System.out.println("ok");
		//���Ĵ��ʱ��--��Զ���
		/*
		 * setMaxAge(num)
		 * num=0  �������
		 * num=һ����   ���������cookie�Ĵ��ʱ��
		 * num=�����     ��Զ����
		 * num=-1   Ĭ��ֵ,���Ự������ʱ��,cookie�����
		 */
		//cookie.setMaxAge(60*10);//600��
		cookie.setMaxAge(Integer.MAX_VALUE);
		//����ǰ��cookie��������·��
		cookie.setPath(request.getContextPath()+"/CookieDemo");
		//cookie.setPath(request.getContextPath());//һ�����ó�����
		//�ڶ��ε�ʱ��,��Ϊ��ǰ��cookie��ǰ���cookie·��һ��,������Ϊ��һ��cookie,����ǰ���cookie������
		response.addCookie(cookie);
		
		request.getSession().setMaxInactiveInterval(interval);
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
