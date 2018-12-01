<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.header {
	padding: 8px 14px;
	margin-bottom: 0;
	height: 10hv;
	background-color: #f7f7f7;
	border-bottom: 1px solid #ebebeb;
	border-radius: calc(0.7rem - 1px);
}

.search {
	float: right;
	margin-top: -27px;
}

input[type="text"] {
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
}
.topnav {
    background-color: #333;
    overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    margin-left: 10%;
    text-decoration: none;
    font-size: 25px;
    position: relative;
}

/* Change the color of links on hover */
.topnav a:hover {
    background-color: #ddd;
    color: black;

}

/* Add a color to the active/current link */
.topnav a.active {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
	<div class="header">
	<%
			if (session.getAttribute("un") == null) {
			%>
				<a href="home.jsp">
			<%
			}else{
			%>
				<a href="homeAdmin.jsp">
			<%} %>
		
    <div class="BTOInsightlogo">
			<img src="Img/logo_preview.png" alt="BTOInSight Icon"
				width="250px" height="100px">
		</div>
    </a>
		<div class="search">

			<form id="myform" name="myform" method="post" action="search.jsp">
				<input type="text" name="search" /> <input type="submit" value="search" />
			</form>
		</div>
	</div>
	<div class="topnav" id="myTopnav">
			<a href="home.jsp">Home</a> 
			<a href="bto.jsp">Map</a>
			<a href="compare.jsp">Compare</a> 
			<a href="plannermain.jsp">Planner</a> 
			<%
			if (session.getAttribute("un") == null) {
			%>
				<a href="login.jsp">Login</a>
			<%
			}else{
			%>
				<a href="LoginController?para=logout">Logout</a>
			<%} %>
		</div>
</body>
</html>