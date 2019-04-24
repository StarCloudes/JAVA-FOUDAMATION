package com.qianfeng.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * servlet:是服务器端的一个小应用程序(.java文件),负责完成一个具体的功能
 * servlet的生命周期:从servlet对象被 创建到销毁的过程
 * servlet是由tomcat服务器创建的,也是由tomcat服务器销毁的
 * 
 * servlet对象的生命周期:
 * 1.ServletDemo1(构造方法)  执行一次   
 * 2.init(初始化方法)   执行一次   
 * 3.service(提供服务的方法)    执行多次
 * 4.destroy(销毁的方法)  执行一次   
 * 
 * sevlet的特点:
 * 1.service方法执行多次
 * 2.serlvet创建一次,使用多次.好处:节省内存
 * 3.servlet对象是随着服务器的关闭而销毁
 * 4.所有的方法都是自动被调用的
 */

/*
 * 第一种创建servlet的方法
 */
public class ServletDemo1 implements Servlet {
	//构造方法
	public  ServletDemo1() {
		System.out.println("SevletDemo1");
	}

	//负责当前对象的销毁
	@Override
	public void destroy() {
		System.out.println("destroy");

	}


	//初始化方法
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");

	}

	//向外界提供服务的方法(工作的方法)
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service");
	}

	//得到配置对象
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	//得到一些servlet的信息
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
