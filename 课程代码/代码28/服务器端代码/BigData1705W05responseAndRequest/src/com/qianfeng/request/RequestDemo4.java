package com.qianfeng.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo4 extends HttpServlet {

	/*
	 * 重定向与请求转发
	 * 
	 * 共同点:都可以实现两个界面的切换
	 * 
	 * 不同点:
	 * 重定向:
	 * 1.客户端要请求两次
	 * 2.地址栏显示两个地址
	 * 3.两次操作都是由客户端完成的
	 * 4.可以访问外部网址(地址)
	 * 5.访问工程下的servlet对象时,工程名是:request.getContextPath()+访问路径
	 * 6.不能通过request对象实现两个服务器之间传值
	 * 请求转发:
	 * 1.客户端只需要请求一次
	 * 2.地址栏显示一个地址
	 * 3.一次客户端,一次服务器端
	 * 4.只能在应用内访问
	 * 5.工程名是:访问路径
	 * 6.可以实现两个服务器之间传值
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//实现重定向
		//testDirect(request, response);
		//实现请求转发	
		testForword(request, response);
	
	}
	
	//实现重定向
	public static void testDirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		 * 用户:张三   张三想借钱
		 * 
		 *  demo4:我没有钱,你去找demo5借吧
			demo4:恭喜你借钱成功
			demo5:没问题,我有,我借给你10亿
		 */
		
		System.out.println("demo4:我没有钱,你去找demo5借吧");
		
		//重定向
		//参数:要进行跳转的网址---demo5的访问地址
		//因为这里是从客户端重新发出的请求,所以要写全地址  http://localhost:8081/BigData1705W05responseAndRequest/RequestDemo5
		//但是这里 可以省略:http://localhost:8081.因为在同一个服务器里面
		//BigData1705W05responseAndRequest是资源在服务器上的路径,因为重定向是重新进行请求,应用外部的请求,所以当前的路径不可以省略
		//getContextPath():资源在服务器上的路径
		//response.sendRedirect(request.getContextPath()+"/RequestDemo5");
		
		System.out.println("demo4:恭喜你借钱成功");
		
		//访问百度的地址
		response.sendRedirect("http://www.baidu.com");
	}
	//实现请求转发
	public static void testForword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /*
		  * demo4:我没有钱,你去找demo5借吧
			demo5:没问题,我有,我借给你10亿
			demo4:恭喜你借钱成功
		  */
		System.out.println("demo4:我没有钱,你去找demo5借吧");
		//请求转发--实现访问demo5:这里因为始终没有出当前的应用,所以只需要写应用内的访问路径即可
		//forward:实现的是对request和response对象的传递
		
		//通过request实现传值:将值绑定到request对象上
		request.setAttribute("01", "bingbing");
		
		// http://localhost:8081/BigData1705W05responseAndRequest可以省略
		request.getRequestDispatcher("/RequestDemo5").forward(request, response);;
		
		System.out.println("demo4:恭喜你借钱成功");
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
