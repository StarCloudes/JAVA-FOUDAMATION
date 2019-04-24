package com.qianfeng.test;

public class Test {
	/*
	 * 复习:
	 * 1.request
	 * 	>请求行的一些常用方法
	 * 	>post下的中文处理(tomcat7)  tomcat8在post的时候也需要使用setCharacterEnCoding设置编码
	 * 	>服务器获取表单数据的方法
	 * 		>字符流
	 * 		.getParameter(标签的名字)   获取一个标签的值
	 * 		.getParameterValues(标签的名字)    获取一个name对应的多个值
	 * 		.getParameterNames()     获取所有的标签名
	 * 		.getParameterMap()      获取所有的标签名和值,组成map
	 * 		>字节流
	 * 		getInputstream()    图片的上传
	 * >get下的中文处理   再编码再解码
	 * >重定向与请求转发
	 * 		重定向     sendRedirect()    ---   response
	 * 		请求转发   getRequestDispatcher()  ----  request
	 *      request:是域对象
	 * 2.cookie--会话技术
	 * 	>基本语法     
	 * 		只能接收字符串
	 * 		客户端技术
	 * 		最大值4kb
	 *      以键值对的方式存值
	 *      通过getMaxage标记存活时间
	 *      通过getpath设置路径
	 *      request通过getCookies()获取客户端传来的所有cookie对象
	 *      response通过addCookie()将cookie对象添加到客户端
	 * 3.session--会话技术
	 * 		服务器端技术
	 * 		是域对象
	 * 		可以存储大量的值
	 * 		以键值对的方式存值
	 * 		每一个浏览器对应一个session,一个session有一个sessionid
	 *      session  我们可以手动 设置存活时间  方法  setMaxInactiveInterval(interval) 单位秒
	 * 4.购物车
	 */
    
}
