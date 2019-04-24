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
		
		
		//将表单的数据放入模型
		User user = new User();
		
		try {
			//给BeanUtils增加一个String转Date的转换器
			//第一个参数:转换器     第二个参数:转之后的类
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
		
		//访问service层
		UserService uService = new UserServiceImpl();
		int num =  uService.register(user);
		
		if (num >0) {
			//注册成功
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			//注册失败
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
