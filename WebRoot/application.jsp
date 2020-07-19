<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int count = 0;
	String counter_name = request.getParameter("counter_name");
	try{
		count = Integer.parseInt((application.getAttribute(counter_name).toString()));
	}catch(Exception e){ }
%>
<h3>自从应用服务器启动后，此页面已经访问了<%=count %>次！</h3>
<%
	count++;
	application.setAttribute(counter_name, new Integer(count));
%>
</body>
</html>