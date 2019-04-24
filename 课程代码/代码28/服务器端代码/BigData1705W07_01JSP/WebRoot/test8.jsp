<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>九大内置对象-4大域对象</title>
</head>
<body>
	<%--
		请求转发:  null request session application 
		重定向:    null null session application 
	 --%>
	<%=pageContext.getAttribute("like") %>
	<%=request.getAttribute("like") %>
	<%=session.getAttribute("like") %>
	<%=application.getAttribute("like") %>
	<%--起作用的范围是当前的4大域对象
		域对象的范围从小到大是:pageContext<request<session<application
		findAttribute起作用的时候是从pageContext开始匹配,有值就输出,没有值继续向下找.一直找到application为止
	 --%>
	<%=pageContext.findAttribute("like") %>
</body>
</html>