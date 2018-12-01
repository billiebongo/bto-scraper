<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="entity.*"
	import="utility.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" charset="utf-8">

<jsp:include page="header.jsp" />
<jsp:include page="footer.jsp" />
<title>listing</title>
<head>

    <script src="js/script.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>


    <link rel="stylesheet" href="css/listStyle.css">
    <script>
    
    
    
    
    
    </script>
  </head>
</head>
<body>
<div class="headingfordetails">
    <h1>Details of BTO</h1>
</div>
<%
	RetrieveDatabase retrieve = new RetrieveDatabase();
	SupportController support = new SupportController();
	HDB h = new HDB();
	h = retrieve.getOneHDB(request.getParameter("b"), request.getParameter("f"));
	String[] coor;
	coor = h.getCoordinates().split(",");
	boolean isCarpark = support.isCarparkNearBy(coor[0], coor[1]);
	boolean isKindergarten = support.isKindergartenNearBy(coor[0], coor[1]);
	boolean isDengue = support.isDengueArea(coor[0], coor[1]);
%>
<div class="masonry">
  <form action="ListingsServlet" method="post">
    <div class="brick">
        <img id="list" src="Img/address.PNG">
        <h5>
          <span>
            Blk: <%=h.getBlock() %><br>
            &nbsp; Address: <%=h.getLocation() %><br>
            &nbsp;&nbsp;Flat type: <%=h.getFlat_type() %>
        </span>
		</h5>
    </div>
    

	<div class="brick">
        <img id="list" src="Img/carpark.PNG">
        <h5>
          <span>
            Carpark within 500m: <%=isCarpark %>
		</span>
		</h5>
    </div>
    
    <div class="brick">
        <img id="list" src="Img/unitavailable.PNG">
        <h5>
          <span>
            Units Available:<%=h.getUnits() %>
            </span>
		</h5>
    </div>
    
    <div class="brick">
        <img id="list" src="Img/ethnicquota.PNG">
        <h5>
          <span>
            Ethnic Quota:<%=h.getEthnic_quota() %>
        </span>
        </h5>
      </div>
      
      <div class="brick">
        <img id="list" src="Img/kindergarten.PNG">
        <h5>
          <span>
            Kindergarten within 1km:<%=isKindergarten %>
            </span>
		</h5>
      </div>

      <div class="sitePlan">
      	<a title="BTO sitemap" href="<%=h.getSite_plan() %>" target="_blank"><img id="list" src="<%=h.getSite_plan() %>"></a>
      </div>
    
    <div class="brick">
        <img id="list" src="Img/completiondate.PNG">
        <h5>
          <span>
            Completion Date: <%=h.getCompletion_date() %><br>
            &nbsp; Possession Date: <%=h.getPossession_date() %>
        </span>
       </h5>
      </div>

      <div class="brick">
    				<img id="list" src="Img/Dengue.PNG">
            <h5>
              <span>
                Dengue Clusters: <%=isDengue %>
            </span>
            </h5>
      </div>
      <input type="submit" value="<%=h.getBlock()%>" name="hdbval">Add to Compare</input>
    </form>
  </div>
</body>
</html>