package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {
	/*
	 * 昨天知识总结:
	 * 1.servlet
	 * 		>servlet的4中创建方式
	 * 			实现servlet接口
	 * 			继承GenericServlet类            适配器模式
	 * 			继承HttpServlet类                    模板设计模式
	 * 			通过直接创建servlet类型的文件实现(与第三种一样)
	 *       在前三种需要到web.xml中完成当前servlet的注册
	 *       >生命周期:从servlet的创建到销毁         
	 *          service  方法调用很多次   其他的方法只调用一次
	 *       >ServletConfig     对应的作用域:当前的servlet对象
	 *       >ServletContext              当前的应用
	 *       	获取全局的属性
	 *       	共享数据
	 *       	通过相对路径获取绝对路径
	 *       servlet,config,context对象的创建和销毁都是由tomcat服务器实现的
	 *       >路径匹配
	 *       	具体的名字
	 *       	*
	 *        	*.名字(*.do)
	 *        优先级   依次降低
	 * 2.http
	 * 		>请求
	 * 			请求消息行         
	 * 				请求方式       请求的资源路径
	 * 			请求消息头
	 * 				属性信息
	 * 			请求消息体
	 * 				在Post请求方式下的请求内容
	 * 		>响应
	 * 			响应消息行
	 * 				状态码
	 * 			响应消息头
	 * 				属性信息  : 是否让浏览器缓存     ,编码,刷新
	 * 			响应消息体
	 * 				正文
	 * 3.get和post的区别
	 * 4.response
	 * 		>编码  三种方式
	 * 		注意点:先编码再获取流
	 * 		>下载图片--使用字节流
	 * 		>验证码图片的生成下载
	 * 
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求消息行
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println(request.getMethod());//请求方法
		System.out.println(request.getContextPath());//资源在服务器上的路径
		System.out.println(request.getRequestURI());//资源在服务器上的访问路径
		System.out.println(request.getRequestURL());//全路径
		System.out.println(request.getQueryString());//?后面的部分
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
