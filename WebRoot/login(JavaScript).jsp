<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">
	function gettime() {
		var d = new Date();
		document.getElementById("t").innerHTML = d;
		window.setTimeout("gettime()", 1000);//软件1811 甘延辉 201821122020
	}
	window.onload = gettime;
</script>
<title>登录页面</title>
<style type="text/css">
#content1 {
	width: 600px;
	height: 300px;
	margin: 10px auto;
	font-family: "楷体";
	font-size: 16px;
}
</style>
</head>
<body>
	<div id="content1">
		现在是北京时间:
		<div id="t"></div>
		下面是登陆程序:
		<form action="login_check.jsp" method="post">
			<table>
				<tr>
					<th>用户ID:</th>
					<th><input type="text" name="userid" /></th>
				</tr>

				<tr>
					<th>密码:</th>
					<th><input type="password" name="password"></th>
				</tr>

				<tr>
					<th><input type="submit" value="登录" /></th>
					<th><input type="reset" value="重填" /></th>
				</tr>
			</table>
		</form>
		<!-- 2017110116   123 -->
	</div>
</body>
</html>