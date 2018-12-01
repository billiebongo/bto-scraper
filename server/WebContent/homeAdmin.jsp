<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="utf-8">
<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />

    <script src="js/script.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/homeStyle.css">
  </head>
</head>

	<body>
	<%
		if (session.getAttribute("un") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
    <h1 class="BTO">BTO In-Sight</h1>
    <p class="BTO">Find the right home that's a perfect fit for you.</p>

    <nav class="navbar navbar-default">
           <div class="nav nav-justified navbar-nav">

               <form class="navbar-form navbar-search" role="search">
                   <div class="input-group">

                       <input type="text" class="form-control">

                       <div class="input-group-btn">
                           <button type="button"
						class="btn btn-search btn-info">
                               <span class="glyphicon glyphicon-search"></span>
                               <span class="label-icon">Search</span>
                           </button>
                       </div>
                   </div>
               </form>

           </div>
       </nav>

            <p>&nbsp;</p>
  <div class="picsposition">

  <figure class="snip1166" style="margin-left:1%">
  <img src="Img/map.PNG" alt="sample74" height="200">
  <figcaption>
    <h3>Map </h3>
    <div>
      <p>Get useful information on HDB housing matters and locations of HDB's flats, car parks, shops and businesses. </p>
    </div>
		<a href="bto.jsp"></a>
  </figcaption>
</figure>

<figure class="snip1166 navy ">
  <img src="Img/compare.PNG" alt="sample72" height="200">
  <figcaption>
    <h3>Compare</h3>
    <div>
      <p>Compare BTO flats to determine the one that best suits one's/family needs.</p>
    </div>
		<a href="compare.jsp"></a>
  </figcaption>
</figure>
<figure class="snip1166 red">
  <img src="Img/planner.PNG" alt="sample73" height="200">
  <figcaption>
    <h3>Planner</h3>
    <div>
      <p>To determine what are the key criterias that one should consider when choosing BTO e.g travelling time to work,amenities for kids and elderly etc.</p>
    </div>
		<a href="plannermain.jsp"></a>
  </figcaption>
</figure>
<figure class="snip1166 purple">
  <img src="Img/systemadmin.png" alt="sample75" height="200">
  <figcaption>
    <h3>Update Database</h3>
    <div>
      <p>Maintains Web system performance by performing system monitoring and analysis, and performance tuning</p>
    </div><a href="upload.jsp"></a>
  </figcaption>
</figure>

</div>

</body>

</html>