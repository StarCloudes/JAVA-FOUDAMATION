package com.qianfeng.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {
 
	/*
	 * 直接将图片发送回客户端
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//如果客户端图片显示成乱码,可以将当前的编码去掉
		//response.setContentType("text/html;charset=utf-8");
		
		//找图片
		ServletContext sContext = getServletContext();
		String url = sContext.getRealPath("WEB-INF\\classes\\美女1.jpg");
		
		//获取图片的名字
		int index = url.lastIndexOf("\\")+1;
		String filename = url.substring(index);
		
		//如果图片的名字是中文的解决办法
		//采用encode编码       第一个参数:需要编码的文本     第二个参数:指定的编码
		String newName = URLEncoder.encode(filename,"utf-8");
		
		//将图片读入到内存
		FileInputStream fis = new FileInputStream(url);
		
		//将图片写出到网络(客户端)
		ServletOutputStream sos = response.getOutputStream();
		
		//设置客户端下载
		response.setHeader("content-disposition","attachment;filename="+newName);
		
		//图片的传输
		byte[] arr = new byte[1024];
		int num;
		while ((num = fis.read(arr))!= -1) {
			sos.write(arr,0,num);
			
			sos.flush();
		}
		
		fis.close();
		sos.close();
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request, response);
	}

}
