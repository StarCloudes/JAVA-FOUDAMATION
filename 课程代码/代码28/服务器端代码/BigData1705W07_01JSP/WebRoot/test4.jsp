<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>6大动作之请求转发</title>
</head>
<body>
	<%
		//传递中文需要单独设置编码
		request.setCharacterEncoding("utf-8");
	 %>

	<%--
		//通过java代码实现请求转发
		request.getRequestDispatcher("/test5.jsp?name=bingbing&age=18").forward(request,response);
	 --%>
	 
	 <%--使用jsp实现请求转发 --%>
	 <jsp:forward page="/test5.jsp">
	 	<jsp:param value="冰冰" name="name"/>
	    <jsp:param value="20" name="age"/>
	 </jsp:forward>
</body>
</html>