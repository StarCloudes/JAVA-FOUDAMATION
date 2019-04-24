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
		
		//第二次访问
		Cookie[] cookies = request.getCookies();
		//System.out.println(cookies.length);
		if (cookies != null) {//判断是否是第一次访问服务器
			//取出我们要的cookie
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String key = cookie.getName();
				String value = cookie.getValue();
				if (key.equals("mytime")) {//说明是我们的cookie
					 System.out.println(value);
					 
					 //写回客户端
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 long time = Long.parseLong(value);
					 String newtime = sdf.format(new Date(time));
					 out.write("您上次登录的时间是:"+newtime);
					 out.write("<a href='"+request.getContextPath()+"/ClearServlet'>clear</a>");
				}
			}
			
		}
		
		//第一次访问
		//创建cookie对象,以键值对的形式存值--只能存储字符串
		Cookie cookie = new Cookie("mytime",new Date().getTime()+"");
		System.out.println("ok");
		//最大的存活时间--永远存活
		/*
		 * setMaxAge(num)
		 * num=0  立即清除
		 * num=一个数   这个数就是cookie的存活时间
		 * num=无穷大     永远存在
		 * num=-1   默认值,当会话结束的时候,cookie被清除
		 */
		//cookie.setMaxAge(60*10);//600秒
		cookie.setMaxAge(Integer.MAX_VALUE);
		//给当前的cookie对象设置路径
		cookie.setPath(request.getContextPath()+"/CookieDemo");
		//cookie.setPath(request.getContextPath());//一般设置成这样
		//第二次的时候,因为当前的cookie与前面的cookie路径一致,所以认为是一个cookie,它将前面的cookie覆盖了
		response.addCookie(cookie);
		
		request.getSession().setMaxInactiveInterval(interval);
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
