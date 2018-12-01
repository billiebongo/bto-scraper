package utility;

import entity.HDB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListingsServlet", urlPatterns = { "/Listings", "/ListingsServlet" })
public class ListingsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListingsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] hdbBlocks = request.getParameterValues("hdbval");
        RetrieveDatabase retrieve = new RetrieveDatabase();
        ArrayList<HDB> hdbArrayList = retrieve.getHDB(hdbBlocks);
        request.setAttribute("hdbList",hdbArrayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/compare.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		RetrieveDatabase retrieve = new RetrieveDatabase();
        ArrayList<HDB> hdbArrayList = retrieve.getHDB(0);
        request.setAttribute("hdbList",hdbArrayList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listings.jsp");
        requestDispatcher.forward(request,response);
    }
}
