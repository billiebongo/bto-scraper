package utility;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String para= request.getParameter("para");
		HttpSession session = request.getSession();
		if(para.equalsIgnoreCase("logout")) {
			session.removeAttribute("un");
			response.sendRedirect("home.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("un");
		String password= request.getParameter("pd");
		ArrayList<User> uList = new ArrayList<User>();
		RetrieveDatabase retrieve = new RetrieveDatabase();
		HttpSession session = request.getSession();
		session.removeAttribute("un");
		session.removeAttribute("error");
		uList = retrieve.getUsers();
		for(int i=0;i<uList.size();i++) {
			if(uList.get(i).getName().equals(name)) {
				if(uList.get(i).getPassword().equals(password)){
					session.setAttribute("un", name);
					response.sendRedirect("homeAdmin.jsp");
				}
			}
		}
		if(session.getAttribute("un")==null) {
			session.setAttribute("error", "User name or password is incorrect");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
