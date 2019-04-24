package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.qianfeng.domain.User;
import com.qianfeng.service.UserService;
import com.qianfeng.service.impl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		//���������ݷ���ģ��
		User user = new User();
		
		try {
			//��BeanUtils����һ��StringתDate��ת����
			//��һ������:ת����     �ڶ�������:ת֮�����
			ConvertUtils.register(new Converter() {
				public Object convert(Class arg0, Object arg1) {
					String strDate = (String) arg1;
					Date date = null;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					
					if (strDate instanceof String) {
						try {
							date = sdf.parse(strDate);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return date;
				}
			}, Date.class);
			
			BeanUtils.populate(user, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����service��
		UserService uService = new UserServiceImpl();
		int num =  uService.register(user);
		
		if (num >0) {
			//ע��ɹ�
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//ע��ʧ��
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
