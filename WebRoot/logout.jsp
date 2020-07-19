<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注销登录,退出</title>
</head>
<body>
<!-- 用户必须先登录，才能访问此页面, 如果没有登陆，提示用户回去login.jsp页面重新登陆 -->
<%
	if(session.getAttribute("daoliancheck") != null){//session的盗链属性在login页面被设置过，是正常登录进来的
%>
	<%session.invalidate(); %>
	<h2>若要重新登录,请点击<a href = "login(JavaScript).jsp">登录</a></h2>
<%	}else{ 
	//response.sendRedirect("login.jsp");	//会立即跳转
	response.setHeader("refresh", "2;URL = login(JavaScript).jsp");
%>
	<h2>您还未登录，请先登录！</h2>
	<h3>2秒后将返回登陆页面</h3>
<% } %>
</body>
</html>