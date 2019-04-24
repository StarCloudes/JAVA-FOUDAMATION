package com.qianfeng.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//chain.doFilter之前负责过滤request
		System.out.println("Filter2:过滤前");
				
				
		chain.doFilter(request, response);//真正实现过滤的方法

		//chain.doFilter之后负责过滤response
		System.out.println("Filter2:过滤后");

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
