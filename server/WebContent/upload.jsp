<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<title>Upload</title>
<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

</head>
<body>

<center>
        <h1>Update Database</h1>
        <form method="post" action="uploadServlet" enctype="multipart/form-data">
        <div style="margin-left:30%;margin-top:100px;">
<ul>
  <li>
    <input type="radio" name="type" id="f-option" value="carpark">
    <label for="f-option">Carpark</label>
    
    <div class="check"></div>
  </li>
  
  <li>
    <input type="radio" name="type" id="s-option" value="dengue" >
    <label for="s-option">Dengue</label>
    
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" name="type" id="t-option" value="kind">
    <label for="t-option">Kindergartens</label>
    
    <div class="check"><div class="inside"></div></div>
  </li>
</ul>
</div>
            <table border="0" style="clear:left">
              <!-- <tr><input type="radio" name="type" value="carpark" checked> Carpark
			  <input type="radio" name="type" value="dengue"> Dengue
			  <input type="radio" name="type" value="kind"> Kindergartens
            </tr> -->
            <tr>
                    <td>
                   <input type="file" name="file-3[]" id="file-3" class="inputfile inputfile-3" data-multiple-caption="{count} files selected" multiple />
					<label for="file-3"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>Choose a file&hellip;</span></label>
					</td>
                    
                    <!-- <td><input type="file" name="file" size="50"/></td> -->
                    <td colspan="2">
                        <input type="submit" value="Save" class="submit" onsubmit="setTimeout(function(){window.location.reload();},10)">
                    </td>
                </tr>
                
            </table>
        </form>
        <script>
        <% 
        if(request.getAttribute("Message") !=null){
        	if(request.getAttribute("Message").toString().equalsIgnoreCase("1")){
        	%>
        	
        	alert("File uploaded and saved into database!");
        	
        <%	
        	}
        if(request.getAttribute("Message").toString().equalsIgnoreCase("0")){
        	%>
        	
        	alert("Fail to uplaod file!");
        	<%} %>
        
     <%  } %>
     </script>
    </center>
		<script src="js/custom-file-input.js"></script>
</body>
</html>