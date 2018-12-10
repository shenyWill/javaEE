<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.yuanwill.el.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- 模拟域中的数据 -->
<%
	request.setAttribute("company", "heima");
	
	// 存储一个对象
	User user1 = new User(1,"zhangsan", "123");
	session.setAttribute("user", user1);
	
	// 存储一个集合
	List<User> list = new ArrayList<User>();
	list.add(new User(2,"lisi", "456"));
	list.add(new User(3,"wanghu", "789"));
	
	application.setAttribute("list", list);
%>

<hr>

<!-- 取出 值-->
<%= request.getAttribute("company") %>
<% 
	User user = (User)session.getAttribute("user");
	out.write(user.getName());
%>
<hr>

<!-- 使用el表达式 -->
    ${requestScope.company}
    ${sessionScope.user.name}
    ${applicationScope.list[1].name }
    <hr>
    
    <!-- 使用el全局表达式 -->
    ${company}
    ${user.name}
    ${list[1].name }
</body>
</html>