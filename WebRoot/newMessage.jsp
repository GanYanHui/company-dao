<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增留言页</title>
</head>
<body>
	<%
		if (session.getAttribute("daoliancheck") != null) {//session的盗链属性在login页面被设置过，是正常登录进来的
	%>
	<div align="center">
		<h2>发布新留言</h2>
		<form action="saveMessage.jsp" method="post">
			标题:<input type="text" name="title" /><br /> 内容:<input type="text"
				name="content" /><br /> <input type="submit" value="添加" /><input
				type="reset" value="重置" />
		</form>
		<br /> <a href="messageBoard.jsp">回到留言列表页</a>
	</div>
	<%
		} else {
			//response.sendRedirect("login.jsp");	//会立即跳转
			response.setHeader("refresh", "2;URL = login(JavaScript).jsp");
	%>
	<h2>您还未登录，请先登录！</h2>
	<h3>2秒后将返回登陆页面</h3>
	<%
		}
	%>
</body>
</html>