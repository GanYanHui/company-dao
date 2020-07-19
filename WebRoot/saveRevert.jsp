<%@page import="cn.jmu.vo.Person"%>
<%@page import="cn.jmu.factory.DAOFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="cn.jmu.vo.Revert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存留言回复</title>
</head>
<body>
	<%
		if (session.getAttribute("daoliancheck") != null) {//session的盗链属性在login页面被设置过，是正常登录进来的
	%>

	<%!String messageIDString = "";%>
	<%
		request.setCharacterEncoding("utf-8");

			Revert rev = new Revert();

			//ID
			messageIDString = (String) session.getAttribute("messageID");
			int messageID = Integer.parseInt(messageIDString);

			//内容
			String content = request.getParameter("content");

			//回帖者
			Person per = null;
			String userid = session.getAttribute("userid").toString();
			per = DAOFactory.getPersonDAOInstance().findById(userid);

			//回帖时间
			Date now = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

			rev.setMessageID(messageID);
			rev.setContent(content);
			rev.setWriter(per.getName());
			rev.setWriteDate(df.format(now));

			boolean flag = false;
			flag = DAOFactory.getRevertDAOInstance().doInsert(rev);

			if (flag) {
	%>
	<jsp:forward page="revertMessage.jsp">
		<jsp:param name="messageID" value="<%=messageIDString%>" />
	</jsp:forward>
	<%
		} else {
	%>
	<h2>
		保存失败,返回<a href="messageBoard.jsp">留言列表页</a>
	</h2>
	<%
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