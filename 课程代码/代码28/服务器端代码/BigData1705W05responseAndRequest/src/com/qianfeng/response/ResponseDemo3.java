package com.qianfeng.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class ResponseDemo3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		
		//告知客户端不缓存的方法一
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);
		
		//方法二:直接每次都让网址发生变化  http://localhost:8081/BigDat1705W05responseAndRequest/ResponseDemo3?time=现在的时间
		
		//随机生成验证码图片a
		//1.自己生成-需要画图等知识
		//2.利用三方架包
		//第一个参数:图片的宽度      高度       数字的个数      干扰线的条数
		ValidateCode code = new ValidateCode(100,25,4,26);
		
		//通过response的输出流将图片写出到客户端
	    code.write(response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
