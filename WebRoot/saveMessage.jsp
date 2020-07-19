<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="cn.jmu.vo.Person"%>
<%@page import="cn.jmu.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存新留言</title>
</head>
<body>
	<%
	if(session.getAttribute("daoliancheck") != null){//session的盗链属性在login页面被设置过，是正常登录进来的
		request.setCharacterEncoding("utf-8");
		Person per = null;
		String userid = session.getAttribute("userid").toString();
		per = DAOFactory.getPersonDAOInstance().findById(userid);
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
%>
	<jsp:useBean id="mes" class="cn.jmu.vo.Message" />
	<jsp:setProperty property="*" name="mes" />
	<jsp:setProperty property="writer" name="mes" value="<%=per.getName() %>" />
	<jsp:setProperty property="writeDate" name="mes" value="<%=df.format(now) %>" />

	<%
		try {
				if (DAOFactory.getMessageDAOInstance().doInsert(mes)) {
	%>
	<h3>
		留言保存成功!返回<a href="messageBoard.jsp">留言列表页</a>
	</h3>
	<%
		} else {
	%>
	<h3>
		留言保存失败!返回<a href="messageBoard.jsp">留言列表页</a>
	</h3>
	<%
		}
			} catch (Exception e) {
				System.out.println(e);
			}
	%>

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