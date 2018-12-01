<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" import="entity.*" import="utility.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<title>hello</title>
<style>
h1 {
    text-align: center;
    font-family: calibri;
    margin:50px 0 0 0;
}

h2 {
    text-align: center;
    font-family: calibri;
    font-style: italic;
    margin:10px 0 0 0;
}
table {
    width: 50%;
margin-left: auto;
margin-right: auto;
}

tr, td {
    height: 20px;
    padding: 10px;
    font-family: calibri;
}
p{
    height: 20px;
    padding: 10px;
    font-family: calibri;
    text-align: center;
}

button{
    font-family: calibri;
margin:auto;
align:center;
}


.buttonHolder{ 
	text-align: center; 
	}
	
.tile_div{
    text-align: center;
    width: 100%;
}

.tile_table{
    border-collapse:collapse;
}

.tile_table tr, td{
}

.tile_image{
    padding: 5px 5px 5px 5px;
    margin: 5px 5px 5px 5px;
}

</style>

</head>
<body>
${error}
<form action="PlanBTOController" method="get">


	<h1>What are you looking for?</h1>

    <table>
    <tr>
    <td><input type = "checkbox" name = "options" value = "town_val"><br><img class="tile_image" height="60px" width="80px" src="Img/location.jpg"/>
        <p class="tile_p">Location</p></td>
    <td><input type = "checkbox" name = "options" value = "possess_val"><br><img class="tile_image" height="60px" width="80px" src="Img/possess.png"/>
        <p class="tile_p">Date of Possession</p></td>
    <td><input type = "checkbox" name = "options" value = "complete_val"   ><br><img class="tile_image" height="60px" width="80px" src="Img/complete.png"/>
        <p class="tile_p">Date of completion</p></td>
    <td><input type = "checkbox" name = "options" value = "carpark_val" ><br><img class="tile_image" height="60px" width="100px" src="Img/carpark2.png"/>
        <p class="tile_p">Carpark distance</p></td>
    </tr>
    <tr>
    <td><input type = "checkbox" name = "options" value = "flat_type_val" ><br><img class="tile_image" height="60px" width="60px" src="Img/room.png"/>
        <p class="tile_p">Rooms</p></td>
    <td><input type = "checkbox" name = "options" value = "lease_val"><br><img class="tile_image" height="60px" width="60px" src="Img/contract.png"/>
        <p class="tile_p">Lease duration</p></td>
    <td><input type = "checkbox" name = "options" value = "ethnic_val" ><br><img class="tile_image" height="60px" width="60px" src="Img/ethnic.jpg"/>
        <p class="tile_p">Ethnicity</p></td>
    <td><input type = "checkbox" name = "options" value = "kin_val"><br><img class="tile_image" height="60px" width="60px" src="Img/kp.png"/>
        <p class="tile_p">Preschool Education</p></td>

	</table>
	


	</table>

    	<div class="buttonHolder">
    <td><button  onclick="loadservlet_onclick()">Plan my BTO!</button></td>
    </div>
    
 </form>
 
 
<script>
function loadservlet_onclick() { 
	  document.location.href = "PlanBTOController"; 
	} 

</script>
</body>
</html>