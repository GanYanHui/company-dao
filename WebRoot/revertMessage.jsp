<%@page import="cn.jmu.factory.DAOFactory"%>
<%@page import="cn.jmu.vo.Revert"%>
<%@page import="cn.jmu.vo.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%! String messageIDString = "";%>
<%
	request.setCharacterEncoding("utf-8");

	messageIDString = request.getParameter("messageID");
	int messageID = Integer.parseInt(messageIDString);

	session.setAttribute("messageID", messageIDString);
	Message mes = DAOFactory.getMessageDAOInstance().findById(messageID);
	List<Revert> all = DAOFactory.getRevertDAOInstance().findById(messageID);
	Revert rev = null;
%>
<title><%=mes.getTitle()%></title>
</head>
<body>
	<div align="center">
		<h3><%=mes.getTitle()%></h3>
		<table border="2">
			<tr>
				<th>作者</th>
				<th>帖子内容</th>
				<th>留言时间</th>
			</tr>
			<tr>
				<td><%=mes.getWriter()%></td>
				<td><%=mes.getContent()%></td>
				<td><%=mes.getWriteDate()%></td>
			</tr>
		</table>
		<h2>-----------------------------以下是回复-----------------------------</h2>
		<%
			//先判断有无回复
			if (all.size() == 0) {
		%>
		<h3>暂无回复</h3>
		<%
			} else {
		%>
		<table border="2">
			<tr>
				<th>作者</th>
				<th>回复内容</th>
				<th>发言时间</th>
			</tr>
			<%
				for (int i = 0; i < all.size(); i++) {
						rev = (Revert) all.get(i);
			%>
			<tr>
				<td><%=rev.getWriter()%></td>
				<td><%=rev.getContent()%></td>
				<td><%=rev.getWriteDate()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		<h2>----------------------------------------------------------</h2>
		<form action="saveRevert.jsp" method="post">
			<h4>添加留言回复</h4>
			<textarea name="content" rows="6" cols="50"></textarea><br/>
			<input type="submit" value="回复"/>
			<input type="reset" value="重置"/>
		</form>
		<h2><a href = "messageBoard.jsp">返回留言列表页</a></h2>
	</div>
</body>
</html>