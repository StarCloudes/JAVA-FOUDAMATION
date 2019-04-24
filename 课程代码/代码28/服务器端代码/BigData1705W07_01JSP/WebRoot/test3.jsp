<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include</title>
</head>
<body>
	bbbbbbbbbbbbbbb
	<%--静态包含:在翻译之后,直接将内容进行了合并,实际上我们只编译了一个.java文件 --%>
	<%@include file="test2.jsp" %>
	
	<%--动态包含  :从始至终都是两个文件,我们编译了两个文件
	<jsp:include page="test2.jsp"></jsp:include>--%>
	
	<%--尽量使用静态包含 --%>
</body>
</html>