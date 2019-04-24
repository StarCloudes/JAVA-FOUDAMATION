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
		 *研究 Post:
		 * 
		 * 服务器端接收客户端数据的方式
		 * getParameter(标签名):获取的是一个标签对应的一个值
		 * getparameterNames():获取所有的标签名字
		 * getParameterMap()  :获取所有的标签数据,然后以键值对的形式放入map
		 */
		//让客户端与服务器端保持一致
		response.setContentType("text/html;charset=utf-8");
		//客户端告诉服务器端我的编码格式---解决Post下的中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		 //* getParameter(标签名)
		//testParameter(request,response);
		 //* getparameterNames()
		//testParameterNames(request, response);
		 //* getParameterMap()
		testParameterMap(request, response);
		
	}
	//* getParameter(标签名)
	public static void testParameter(HttpServletRequest request, HttpServletResponse response) {
		//从表单获取的数据默认的类型都是字符串
		String name = request.getParameter("user");
		User user = new User();
		user.setUser(name);
		user.setPwd(request.getParameter("pwd"));
		user.setSex(request.getParameter("sex"));
		user.setArea(request.getParameter("area"));
		user.setHobby(request.getParameterValues("hobby"));//接收的是一个key(name)对应多个value
		
		System.out.println(user);
		
		for (String string : user.getHobby()) {
			System.out.println("hobby:"+string);
		}
	}

	 //* getparameterNames()
	public static void testParameterNames(HttpServletRequest request, HttpServletResponse response) {
		//获取到的是一个枚举器
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			//每个标签的名字
			String name = (String) enumeration.nextElement();
			String[] values = request.getParameterValues(name);//相当于将只有一个值的内容放成数据组的第一个元素
			for (String string : values) {
				System.out.println(name+"    "+string);
			}
		}
	}
	 //* getParameterMap()
	//以一个map的形式接收表单的数据
	public static void testParameterMap(HttpServletRequest request, HttpServletResponse response) {
		Map<String, String[]> map = request.getParameterMap();
		
		User user = new User();
		
		//第一个参数:要导入数据的模型     第二个参数:对应的map对象
		//注意:模型的属性名字与表单的标签名字必须一致
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
