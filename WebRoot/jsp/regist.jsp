<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
String path = request.getContextPath();  //项目UrI

/**
  *@basePath http相关的项目路径
  */
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<head>
<%@ page language="java"  pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=">

</head>
<body>
	<h2>这是一个注册页面</h2>
	<form action="<%=basePath %>/RegistServlet" method="post">
		username:<input type="text" name="username"/><br/>
		password:<input type="password" name="password"><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>