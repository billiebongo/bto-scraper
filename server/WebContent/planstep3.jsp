<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" import="entity.*" import="utility.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header.jsp" />


<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Planner</title>

<style>
h1 {
    text-align: center;
    font-family: calibri;
    margin:40px 0 0 0;
}


button{
	padding: 0;
	border: none;
	background: none;
	background: #0066A2;
	color: white;
	border-style: outset;
	border-color: #0066A2;
	height: 50px;
	width: 100px;
	font-size:0;display:block;line-height:0
	text-shadow:none;
	text-indent:-9999px;
}
table
{
	align: centre;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
    overflow-y:scroll; 
    height:200px;  
    position:absolute;
}
tr, td {

    font-family: calibri;
}
p{
font-weight: bold;
}

</style>
</head>
<body>
<h1>Your search results:</h1>
<c:if test="${error500 != null}">
    <a href="plannermain.jsp">No results available. Go back and try again.</a>
</c:if>

<table >
<tr>
<td><p>Click for details</p></td>
<td><p>Towns</p></td>
<td><p>Blocks</p></td>
<td><p>Ethnic quotas</p></td>
<td><p>Flat Type</p></td>
<td><p>Site Plan</p></td>
<td><p>Completion Date</p></td>
</tr>
<c:forEach var="hdb" items="${HDBList}" >
<form action="PlanBTOController" method="get">
<tr>
    <%HDB theTown=(HDB)pageContext.getAttribute("hdb");
    
        String key = theTown.getBlock()+"*"+theTown.getFlat_type();
     %>
<td><input type="submit" name="key" src="Img/listing-icon.png" alt="click" height="42" width="42" value="<%=key %>"></td>

  <td>${hdb.town}</td>
  <td>${hdb.block}</td>
  <td>${hdb.ethnic_quota}</td>
  <td>${hdb.flat_type}</td>
  <td><a href=${hdb.site_plan}>link</td>
  <td>${hdb.completion_date}</td>

  
  </tr>
  </form>
</c:forEach>

</table>


<script>
function loadservlet_onclick() { 
	  document.location.href = "PlanBTOController"; 
	} 

</script>
</body>

</html>