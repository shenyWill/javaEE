<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<String> strList = new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		request.setAttribute("list", strList);
	%>
	
	
	<h1>取出数据</h1>
	<c:forEach items="${list}" var="str">${str }</c:forEach>
</body>
</html>