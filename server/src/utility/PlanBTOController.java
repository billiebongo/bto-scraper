package utility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.lang.*; //for stringbuilder
import entity.*;

@WebServlet("/PlanBTOController")
public class PlanBTOController extends HttpServlet {
	 
	   private String message;
	   private static final long serialVersionUID = 1L;
       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public PlanBTOController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	   public void init() throws ServletException {
	      // Do required initialization
	   }
	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		   String ls = request.getParameter("key");
		   
		   if (ls != null) {
			   String[] splitQ = ls.split("\\*");
			   request.setAttribute("key_flag", ls);
			   String block=splitQ[0];
			   String roomType = splitQ[1];
			   String queryListing = "/listing.jsp?b="+block+"&f="+roomType;

			   request.getRequestDispatcher(queryListing).forward(request, response);
		   }
	
		   String[] options= request.getParameterValues("options");
		   if (options != null && options.length > 0) {
			   List<String> list = Arrays.asList(options);
			   if(list.contains("town_val")) {
				   ArrayList<String> townList = new ArrayList();
				   RetrieveDatabase db = new RetrieveDatabase();

				   //townList = db.getTowns();

				   request.setAttribute("town", townList);
				   request.setAttribute("town_flag", "U HAF SELECTED TOWN");
			   }
			   if(list.contains("possess_val")) {
				   request.setAttribute("possess_flag", "U HAVE SELECTED POSSESS");
			   }
			   if(list.contains("complete_val")) {
				   request.setAttribute("complete_flag", "U HAVE SELECTED comPLETE");

			   }
			   if(list.contains("flat_type_val")) {
				   request.setAttribute("flat_type_flag", "U HAVE SELECTED FLAT_TYPE");

			   }
			   if(list.contains("lease_val")) {
				   request.setAttribute("lease_flag", "U HAVe SELECTED LEASE");


			   }
			   if(list.contains("ethnic_val")) {
				   
				   request.setAttribute("ethnic_flag", "U HAVE SELECTED Ethnic");

			   }
			   if(list.contains("kin_val")) {
				   
				   request.setAttribute("kin_flag", "U HAVE SELECTED Ethnic");

			   }
			   if(list.contains("floor_val")) {
				   
				   request.setAttribute("floor_flag", "U HAVE SELECTED Ethnic");

			   }
			   if(list.contains("carpark_val")) {
				   
				   request.setAttribute("carpark_flag", "U HAVE SELECTED Ethnic");

			   }
			   
			    request.getRequestDispatcher("/planstep2.jsp").forward(request, response);
			    } else {
			    	request.setAttribute("error", "Please tick at leats one");
			    	request.getRequestDispatcher("plannermain.jsp").forward(request, response);
			    }
	}
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {
			      
			      // Set response content type
			      response.setContentType("text/html");
			      int and_flag=0;
			      //if towns, completes wtv is all null; return error message tp plans.jsp

			      String[] towns = request.getParameterValues("selected_towns");
			      String[] rooms = request.getParameterValues("selected_rooms");
			      String ethnic = request.getParameter("ethnic");
			      String kin = request.getParameter("kin");
			      String carpark = request.getParameter("carpark");
				   String[] leases = request.getParameterValues("selected_lease");
			   String[] completes = request.getParameterValues("selected_completes");
				   String[] possess = request.getParameterValues("selected_possess");
				  
				   
				   if (towns==null && rooms==null && ethnic==null && leases==null && completes==null && possess==null) {
						request.setAttribute("error", "Please fill something");
					   request.getRequestDispatcher("/plannermain.jsp").forward(request, response);
				   }
			      
			      String query = "SELECT * FROM hdb WHERE ";
			      if (towns != null && towns.length > 0) {
			    	  ArrayList<String> exactTowns = new ArrayList<String>();
			    	  query=query.concat("(");
				      for (int q=0; q<towns.length; q++) {
				    	  	if (towns[q].equals("central")) {
				    	  		exactTowns.add("geylang");
				    	  	}
				    	  	if (towns[q].equals("north")) {
				    	  		exactTowns.add("woodlands");
				    	  		exactTowns.add("toa payoh");
				    	  		exactTowns.add("punggol");
				    	  		exactTowns.add("yishun");
				    	  	}

				    	  	if (towns[q].equals("east")) {
				    	  		exactTowns.add("bedok");
				    	  		exactTowns.add("tampines");

				    	  	}
				    	  	if (towns[q].equals("west")) {
				    	  		exactTowns.add("clementi");
				    	  	}
				    	  	
				    	  
				      }
				      
					   if (exactTowns != null && exactTowns.size() > 0) {
						   and_flag=-1;
						   
						   
						   int or_flag=0;
						   
						   for (int i=0; i<exactTowns.size(); i++) {
							   
							   if (or_flag==-1) {
								   query=query.concat(" OR town = '");
								   query=query.concat(exactTowns.get(i));
								   query=query.concat("'");
							   }else{
								   
								   query=query.concat("town = '");
								   query=query.concat(exactTowns.get(i));
								   query=query.concat("'");
								   or_flag=-1;
							   }
							   
						   }
						   query=query.concat(") ");
					   }
			    	  
			      }
				   
				     
					   if (rooms != null && rooms.length > 0) {
						   if (and_flag==-1) {
								
							   query=query.concat(" AND ");
						   }
						   and_flag=-1;
						   query=query.concat("(");
						   int or_flag=0;
						   for (int i=0; i<rooms.length; i++) {
							   if (or_flag==-1) {
								   query=query.concat(" OR flat_types LIKE '");
								   query=query.concat(rooms[i]);
								   query=query.concat("%'");
							   }else{
								   query=query.concat("flat_types LIKE '");
								   query=query.concat(rooms[i]);
								   query=query.concat("%'");
								   or_flag=-1;
							   }
							   
						   }
						   query=query.concat(") ");
					   }
				   
				   
					   if (ethnic != null) {
						   
						   if (and_flag==-1) {
					
							   query=query.concat(" AND ");
						   }
						   and_flag=-1;
						   if ("chinese".equals(ethnic)) {
							   query=query.concat("(ethnic_quota NOT LIKE '%Chinese-0%')");
						   }
						   if ("malay".equals(ethnic)) {
							   query=query.concat("(ethnic_quota NOT LIKE '%Malay-0%')");
						   }
						   if ("indian".equals(ethnic)) {
							   query=query.concat("(ethnic_quota NOT LIKE '%Indian/ Other Races-0%')");
						   }

					   }
					   


				      
					   if (leases != null && leases.length == 1) {
						   and_flag=-1;

						   
						   int or_flag=0;
						   for (int i=0; i<leases.length; i++) {

							   and_flag=-1;
							   if (leases[0]=="shortlease") {
								   if (and_flag==-1) {
									   query=query.concat(" AND ");
								   }
								   query=query.concat("(flat_types LIKE '2%')");
								   query=query.concat("'");
							   }else{
							   }
						   }
					   }

				   if (completes != null && completes.length > 0) {
					   List<String> DateList = Arrays.asList(completes);
					   
					   if (and_flag==-1) {
						   query=query.concat(" AND ");
					   }
					   and_flag=-1;
					   query=query.concat(" ( ");


					   int or_flag=0;
					   if (DateList.contains("2020")) {
						   if(or_flag==0) {
							   query=query.concat(" completion_date LIKE '%2021\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR completion_date LIKE '%2021\'");
						   }
					   }
					   if (DateList.contains("2021")) {
						   if(or_flag==0) {
							   query=query.concat(" completion_date LIKE '%2021\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR completion_date LIKE '%2021\'");
						   }
						   
					   }
					   if (DateList.contains("2022")) {
						   if(or_flag==0) {
							   query=query.concat(" completion_date LIKE '%2022\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR completion_date LIKE '%2022\'");
						   }
					   }
					   if (DateList.contains("2023")) {
						   if(or_flag==0) {
							   query=query.concat(" completion_date LIKE '%2023\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR completion_date LIKE '%2023\'");
						   }
					   }
					   query= query.concat(") ");
				   }

				   if (possess != null && possess.length > 0) {
					   List<String> PossessList = Arrays.asList(possess);
					   
					   if (and_flag==-1) {
						   query=query.concat(" AND ");
					   }
					   and_flag=-1;
					   query=query.concat(" ( ");


					   int or_flag=0;
					   if (PossessList.contains("2020")) {
						   if(or_flag==0) {
							   query=query.concat(" possession_date LIKE '2021%\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR possession_date LIKE '2021%\'");
						   }
					   }
					   if (PossessList.contains("2021")) {
						   if(or_flag==0) {
							   query=query.concat(" possession_date LIKE '2021%\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR possession_date LIKE '2021%\'");
						   }
						   
					   }
					   if (PossessList.contains("2022")) {
						   if(or_flag==0) {
							   query=query.concat(" possession_date LIKE '2022%\'");
							   or_flag=-1;
						   }else {
							   query=query.concat(" OR possession_date LIKE '2022%\'");
						   }
					   }
					   if (PossessList.contains("2023")) {
						   if(or_flag==0) {
							   query=query.concat(" possession_date LIKE '2023%\'");
							   or_flag=-1;
						   }else {
						   query=query.concat(" OR possession_date LIKE '2023%\'");
						   }
					   }
					   query= query.concat(") ");
				   }
				   
				   RetrieveDatabase db = new RetrieveDatabase();
				   ArrayList<HDB> HDBList = new ArrayList<HDB>();
				   HDBList = db.getInfo(query);
				   
				   // if kindergarten is selected, remove HDB where there 0 kindergartens nearby
				   if (kin != null) {
					   
					   ArrayList<Kindergartens> KList = new ArrayList<Kindergartens>();
					   KList=db.getK();
					   int k_flag=-1;
					   for(int h =0; h< HDBList.size(); h++) {

						   
						   List<String> coorList = Arrays.asList(HDBList.get(h).getCoordinates().split(","));
						   double x1 = Double.parseDouble(coorList.get(0));
						   double x2 = Double.parseDouble(coorList.get(0));
							for(int k=0; k<KList.size(); k++) {
								double distance = Math.hypot(x1-Double.parseDouble(KList.get(k).getX_coor()), x2-Double.parseDouble(KList.get(k).getY_coor()));
								if (distance<Double.parseDouble(kin)) {
									k_flag=1;
									break;
								} 
								
							}
						   
						   
					   }


					  

				   }
				   
				   if (carpark != null) {
					   
					   ArrayList<Carpark> CPList = new ArrayList<Carpark>();
					   CPList=db.getCP();
					   for(int h =0; h< HDBList.size(); h++) {

						   
						   List<String> coorList = Arrays.asList(HDBList.get(h).getCoordinates().split(","));
						   double x1 = Double.parseDouble(coorList.get(0));
						   double x2 = Double.parseDouble(coorList.get(0));
							for(int k=0; k<CPList.size(); k++) {
								double distance = Math.hypot(x1-Double.parseDouble(CPList.get(k).getX_coord() ), x2-Double.parseDouble(CPList.get(k).getY_coord() ));
								if (distance<Double.parseDouble(kin)) break;
							}
						   
						   
					   }


					  

				   }
				   
				   request.setAttribute("HDBList", HDBList); 
				   if (HDBList.size()==0) {
					   request.setAttribute("error500", "suggest for results"); 
				   }
				   request.getRequestDispatcher("planstep3.jsp").forward(request, response);


			   }
	   

	   public void destroy() {
	   }
	}