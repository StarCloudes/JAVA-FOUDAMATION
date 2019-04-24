package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qianfeng.entity.User;

public class RequestDemo2 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *�о� Post:
		 * 
		 * �������˽��տͻ������ݵķ�ʽ
		 * getParameter(��ǩ��):��ȡ����һ����ǩ��Ӧ��һ��ֵ
		 * getparameterNames():��ȡ���еı�ǩ����
		 * getParameterMap()  :��ȡ���еı�ǩ����,Ȼ���Լ�ֵ�Ե���ʽ����map
		 */
		//�ÿͻ�����������˱���һ��
		response.setContentType("text/html;charset=utf-8");
		//�ͻ��˸��߷��������ҵı����ʽ---���Post�µ�������������
		request.setCharacterEncoding("utf-8");
		
		 //* getParameter(��ǩ��)
		//testParameter(request,response);
		 //* getparameterNames()
		//testParameterNames(request, response);
		 //* getParameterMap()
		testParameterMap(request, response);
		
	}
	//* getParameter(��ǩ��)
	public static void testParameter(HttpServletRequest request, HttpServletResponse response) {
		//�ӱ���ȡ������Ĭ�ϵ����Ͷ����ַ���
		String name = request.getParameter("user");
		User user = new User();
		user.setUser(name);
		user.setPwd(request.getParameter("pwd"));
		user.setSex(request.getParameter("sex"));
		user.setArea(request.getParameter("area"));
		user.setHobby(request.getParameterValues("hobby"));//���յ���һ��key(name)��Ӧ���value
		
		System.out.println(user);
		
		for (String string : user.getHobby()) {
			System.out.println("hobby:"+string);
		}
	}

	 //* getparameterNames()
	public static void testParameterNames(HttpServletRequest request, HttpServletResponse response) {
		//��ȡ������һ��ö����
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			//ÿ����ǩ������
			String name = (String) enumeration.nextElement();
			String[] values = request.getParameterValues(name);//�൱�ڽ�ֻ��һ��ֵ�����ݷų�������ĵ�һ��Ԫ��
			for (String string : values) {
				System.out.println(name+"    "+string);
			}
		}
	}
	 //* getParameterMap()
	//��һ��map����ʽ���ձ�������
	public static void testParameterMap(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map = request.getParameterMap();
		
		User user = new User();
		
		//��һ������:Ҫ�������ݵ�ģ��     �ڶ�������:��Ӧ��map����
		//ע��:ģ�͵�������������ı�ǩ���ֱ���һ��
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(user);
		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
