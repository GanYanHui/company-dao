<%@page import="cn.jmu.vo.Person"%>
<%@page import="cn.jmu.dao.impl.MessageDAOImpl"%>
<%@page import="cn.jmu.vo.Message"%>
<%@page import="cn.jmu.factory.DAOFactory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言列表页</title>
</head>
<body>
	<%
		if (session.getAttribute("daoliancheck") != null) {//session的盗链属性在login页面被设置过，是正常登录进来的
			request.setCharacterEncoding("utf-8");
			List<Message> all = DAOFactory.getMessageDAOInstance().findAll();
			//MessageDAOImpl mImpl = new MessageDAOImpl();
			//List<Message> all = mImpl.findAll();
			Message mes = null;
			Person per = null;
			String userid = session.getAttribute("userid").toString();
			per = DAOFactory.getPersonDAOInstance().findById(userid);
	%>
	<p>
		当前用户名:<font color="red"><%=per.getName()%></font>
	</p>
	<div align="center">
		<h2>留言板</h2>
		<table border="2">
			<tr>
				<th>留言ID</th>
				<th>标题</th>
				<th>内容</th>
				<th>作者</th>
				<th>发表时间</th>
				<th>回复数</th>
			</tr>
			<%
				for (int i = 0; i < all.size(); i++) {
						mes = (Message) all.get(i);
			%>
			<tr>
				<td><%=mes.getMessageID()%></td>
				<td><a
					href="revertMessage.jsp?messageID=<%=mes.getMessageID()%>"> <%=mes.getTitle()%>
				</a></td>
				<td><%=mes.getContent()%></td>
				<td><%=mes.getWriter()%></td>
				<td><%=mes.getWriteDate()%></td>
				<td><%=mes.getCount()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="newMessage.jsp">添加新留言</a>
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