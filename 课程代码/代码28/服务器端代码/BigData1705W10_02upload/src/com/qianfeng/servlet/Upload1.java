package com.qianfeng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Upload1 extends HttpServlet {
/*
 * 使用提交表单的方式接收图片的注意事项:
 * 1.必须使用file类型的input标签
 * 2.表单的enctype属性类型必须设置成:multipart/form-data(用来结束字节流)
 * 3.表单接收数据的方式必须是post
 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		//因为图片是字节流,而getParameter只能接收字符流,如果用于接收图片,
		//只能接收到他的路径,如:C:\Users\Administrator\Desktop\工作资料\图片\120.jpg
		//注意:有些浏览器可以接收全路径,有些浏览器只能接收到文件的名字
		String file = request.getParameter("file");
		
	
		
		System.out.println(name+"   "+file);
		
		//使用字节流接收数据
		//获取字节输入流
		ServletInputStream sis = request.getInputStream();
		
		byte[] arr = new byte[1024];
		int num = 0;
		while ((num = sis.read(arr)) != -1) {
			//将内容写入到控制台
			System.out.print(new String(arr,0,num));
		}
		
		sis.close();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
