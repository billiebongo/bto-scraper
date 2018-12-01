<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="entity.*"
	import="utility.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<link rel="stylesheet" href="css/style.css">
<style type="text/css"></style>
<title>Login</title>
</head>
<body>
	<section id="content">
	<form action="LoginController" method="POST">
		<h1>Login Form</h1>
		<div>
			<input type="text" placeholder="Username" required="" name="un" id="username">
		</div>
		<div>
			<input type="password" placeholder="Password" required="" name="pd" id="password">
		</div>
		<div>
			<input type="submit" value="Log in">
			<div style="color: red">${error}</div>
		</div>
	</form>
	</section>
</body>
</html>