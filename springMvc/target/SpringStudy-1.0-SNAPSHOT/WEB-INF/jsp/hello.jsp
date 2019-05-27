<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//http://127.0.0.1:8989/springmvc/
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello.jsp</title>
<link href="static/css/hello.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1>hello.jsp</h1>
	<h1>${name }</h1>
	<hr>
	<div>hello world</div>

</body>
</html>