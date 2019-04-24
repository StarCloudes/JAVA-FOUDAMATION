<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype:默认值是application/x-www-form-urlencoded,可以上传文本,然后如果要上传图片enctype的类型要设置成:multipart/form-data -->
	<form action="${pageContext.request.contextPath}/Upload2" method="post" enctype="multipart/form-data">
		姓名:<input type="text" name="name" /><br/>
	         上传文件:<input type="file" name="file" /><br/>
	    <input type="submit" value="提交" >
	</form>
</body>
</html>