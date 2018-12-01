<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>





<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />

<title>Insert title here</title>
<style>
h1 {
    text-align: center;
    font-family: calibri;
    margin:50px 0 0 0;
}
p {
    text-align: center;
    font-family: calibri;
}

table {
    width: 50%;
margin-left: auto;
margin-right: auto;
}
button{
    font-family: calibri;
margin:auto;
align:center;
}


.buttonHolder{ 
	text-align: center; 
	}

</style>
</head>
<body>

${error}

<form action="PlanBTOController" method="post">

<h1>Choose the qualities of your dream home <br>And we will find them for you!</h1>
<% if(request.getAttribute("town_flag") != null){
	%> <p>What is your desired location (near workplace maybe?)</p>
	<table><tr>
    <td><input type = "checkbox" name = "selected_towns" value = "west">West</td>
    <td><input type = "checkbox" name = "selected_towns" value = "east">East</td>
    <td><input type = "checkbox" name = "selected_towns" value = "central">Central</td>
<td><input type = "checkbox" name = "selected_towns" value = "north">North</td>
</tr></table>
<% }  %>

<% if(request.getAttribute("flat_type_flag") != null){
	%> 	<p>How many rooms would you like?</p><table><tr> 
    <td><input type = "checkbox" name = "selected_rooms" value = "2">2-Room</td>
    <td><input type = "checkbox" name = "selected_rooms" value = "3">3-Room</td>
    <td><input type = "checkbox" name = "selected_rooms" value = "4">4-Room</td>
	<td><input type = "checkbox" name = "selected_rooms" value = "5">5-Room</td>
</tr></table>
<% }  %>


<% if(request.getAttribute("lease_flag") != null){
	%> <p>short lease or 99-year?</p>
	<table><tr>
	<td><input type="checkbox" name="selected_lease" value="shortlease">Short<br></td>
	<td><input type="checkbox" name="selected_lease" value="longlease">Long<br></td>
	
	</tr></table>
	  
  

<% }  %>

<% if(request.getAttribute("possess_flag") != null){
	%> <p>When would you like to move in?</p>
	<table><tr>
    <td><input type = "checkbox" name = "selected_possess" value = "2020">2020</td>
    <td><input type = "checkbox" name = "selected_possess" value = "2021">2021</td>
    <td><input type = "checkbox" name = "selected_possess" value = "2022">2022</td>
	<td><input type = "checkbox" name = "selected_possess" value = "2023">2023</td>
</tr></table>
<% }  %>

<% if(request.getAttribute("complete_flag") != null){
	%> <p>By when would you like to see a completed building?</p>
	<table><tr>
    <td><input type = "checkbox" name = "selected_completes" value = "2020"> Before 2020</td>
    <td><input type = "checkbox" name = "selected_completes" value = "2021">2021</td>
    <td><input type = "checkbox" name = "selected_completes" value = "2022">2022</td>
	<td><input type = "checkbox" name = "selected_completes" value = "2023">2023</td>
</tr></table>
<% }  %>

<% if(request.getAttribute("ethnic_flag") != null){
	%> <p>BTOs have ethnic quotas, let us find those available based on your ethnicity</p>
	<table>
	<tr>
  <td><input type="radio" name="ethnic" value="chinese">Chinese<br></td>
  <td><input type="radio" name="ethnic" value="malay">Malay<br></td>
  <td><input type="radio" name="ethnic" value="indian"> Indian/Other<br></td>
  </tr>
	</table>
<% }  %>

<% if(request.getAttribute("kin_flag") != null){
	%> <p> Do you plan on having kids soon? Choose the proximity for preschools.</p>
		<table>
	<tr>
  <td><input type="radio" name="kin" value="100">within 100m<br></td>
  <td><input type="radio" name="kin" value="1000">within 1km<br></td>
  <td><input type="radio" name="kin" value="3000">within 3km<br></td>
	  </tr>
	</table>
<% }  %>



<% if(request.getAttribute("carpark_flag") != null){
	%><p> How near do you want your carpark to be?</p>
	<table><tr>
  <td><input type="radio" name="carpark" value="100">within 100m<br></td>
  <td><input type="radio" name="carpark" value="1000">within 1k<br></td>
  <td><input type="radio" name="carpark" value="3000">within 3km<br></td>
  </tr>
  </table>
<% }  %>

   	<div class="buttonHolder">
    <td><button  onclick="loadservlet_onclick()">Find my BTO!</button></td>
    </div>
</form>
 

    
<script>
function loadservlet_onclick() { 
	  document.location.href = "PlanBTOController"; 
	}; 
</script>
</body>
</html>