<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/transferServlet" method="post">
	转出账户： <input type="text" name="out"><br>
	转入账户： <input type="text" name="in"><br>
	转入金额： <input type="text" name="money"><br>
	<input type="submit" value="确认提交">
</form>
</body>
</html>