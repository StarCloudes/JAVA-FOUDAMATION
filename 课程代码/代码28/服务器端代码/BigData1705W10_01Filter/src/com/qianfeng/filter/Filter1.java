package com.qianfeng.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * 过滤器是由tomcat服务器创建的,销毁的
 * 过滤器也需要注册
 * 
 * 过滤器的生命周期:
 * Filter1()  构造方法---一次
 * init()     初始化方法--一次
 * doFilter() 工作的方法(过滤)--多次
 * destroy()  销毁--一次
 * 
 * 执行顺序:Filter1()----init-----doFilter-----destroy
 */
public class Filter1 implements Filter {
	FilterConfig fconfig = null;
	//初始化方法
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		fconfig = filterConfig;//获取config对象

	}

	//工作的方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * 我们把在同一个客户端和服务器之间存在多个过滤器时,称为过滤器链
		 * 工作原理:调用FilterChain的doFilter方法首先会跳转到后面的过滤器,当后面没有过滤器了,就会跳转到服务器
		 * 
		 * 当存在多个过滤器时,我们要做的事情
		 * 关键点在与web.xml文件的配置
		 * 1.注册的顺序决定了过滤器被执行的顺序
		 * 2.要想在同一个链上,必须保证被他们过来的服务器的路径是一致的.
		 */
		
		//chain.doFilter之前负责过滤request
		System.out.println("Filter1:过滤前");
		
		
		chain.doFilter(request, response);//真正实现过滤的方法

		//chain.doFilter之后负责过滤response
		System.out.println("Filter1:过滤后");
		
		//这里也能实现过滤--这里不是过滤器链
//		chain.doFilter(request, response);
//		System.out.println("Filter1:过滤后后");
	}

	//销毁方法
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
