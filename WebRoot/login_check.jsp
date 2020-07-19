<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录检查页面</title>
</head>
<body>
	<!-- 1.接收login.jsp表单传过来的userid、password的值 -->
	<%
		request.setCharacterEncoding("utf-8");//设置编码方式
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		//System.out.println("id:" + userid + ", password:" + password);
		String yonghuming = null;//登录的用户名变量
		boolean flag = false;//登录成功与否变量
	%>
	<!-- 2.接受数据库test中的表t_user检查用户ID和密码是否匹配 -->
	<%
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //隐式装载驱动程序

		String DBURL = "jdbc:mysql://127.0.0.1:3306/test? characterEncoding=utf8 & useSSL=false & serverTimezone=UTC & rewriteBatchedStatements=true";
		String DBUSER = "root"; //数据库的用户名
		String DBPASS = "gyh123456"; //数据库的密码

		Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS); //建立连接

		String sql = "select username from t_user where userid = ? and password = ?";

		PreparedStatement pstmt = conn.prepareStatement(sql);//语句总管
		pstmt.setString(1, userid);
		pstmt.setString(2, password);
		pstmt.executeQuery();
		ResultSet rs = pstmt.executeQuery();//返回结果集对象
		if (rs.next()) {
			yonghuming = rs.getString("username");
			flag = true;//登录成功
			session.setAttribute("daoliancheck", "ok");//设置防盗链的属性
			session.setAttribute("userid", userid);
		}
		rs.close();
		pstmt.close();
		conn.close();
	%>
	<!-- 2.1 若匹配，取出username的值，跳转到login_success.jsp  -->
	<% if(flag){ %>
	<jsp:forward page="login_success.jsp">
		<jsp:param name="yhm" value="<%=yonghuming %>" />
	</jsp:forward>
	<!-- 2.2 若不匹配，跳转到login_failure.html -->
	<%
		} else {
	%>
	<jsp:forward page="login_failure.html" />
	<%
		}
	%>
</body>
</html>