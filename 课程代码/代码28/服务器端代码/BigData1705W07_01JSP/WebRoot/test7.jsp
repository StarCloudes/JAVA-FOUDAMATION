<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>九大内置对象</title>
</head>
<body>
	<%
		pageContext.setAttribute("like", "pageContext");
		
		request.setAttribute("like1", "request");
		
		session.setAttribute("like", "session");
		
		application.setAttribute("like", "application");
		
		//请求转发
		request.getRequestDispatcher("/test8.jsp").forward(request, response);
		
		//重定向
		//response.sendRedirect(request.getContextPath()+"/test8.jsp");
		
	 %>
	 
	 <%-- 通过pageContext实现请求转发和请求包含--%>
	 <%--
	 	pageContext.forward("/test8.jsp");
	 	pageContext.include("/test8.jsp");
	  --%>
</body>
</html>