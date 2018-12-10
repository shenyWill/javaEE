<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 使用el获得参数 -->
	<!-- 初始化web.xml配置的参数 -->
	${initParam.username}
	
	
	<%
		Cookie cookie = new Cookie("name", "rose");
		response.addCookie(cookie);
	%>
	<hr>
	<!-- 固定写法，获取name的值 -->
	${cookie.name.value}
</body>
</html>