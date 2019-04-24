package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * 第二种创建servlet的方法
 * 这是ServletDemo2继承了GenericServlet ,实现了Servlet接口
 * 在GenericServlet里面,已经将Servlet的所有方法都实现了,我们在实现功能的时候,只需要创建
 * GenericServlet的子类,在子类中写我们需要的方法即可.我们把这种模式成适配器模式
 */
public class ServletDemo2 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service2");

	}

}
