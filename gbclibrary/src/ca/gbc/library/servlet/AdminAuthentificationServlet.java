package ca.gbc.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.gbc.library.beans.User;

//make the servlet available via two url mappings
@WebServlet(urlPatterns = {"/AdminAuthentification","/AdmAuth"})
public class AdminAuthentificationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public AdminAuthentificationServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//calling the doPost method to work should in case the doGet is called
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//import the User class
		User user = new User();
		//getting form values
		String username = request.getParameter("adminEmail");  
		String password = request.getParameter("adminPassword");
		String role = "admin";
		
		
		//set the values using the class methods
		user.setEmail(username);
		user.setPassword(password);
		user.setRole(role);
		
		
		//request.setAttribute("adminUser", user);  ..not longer needed
		//switching from req scope to session scope
		HttpSession session = request.getSession();
		session.setAttribute("adminUser", user);
		//set session to last for duration d browser is open
		session.setMaxInactiveInterval(-1);
		
		//creating a sticky form, user gets back what they submitted(prev attempt) and try to resubmit again
		request.setAttribute("email", request.getParameter("adminEmail"));
		
		if(username != null && username.length()>0) {
			if(username.equalsIgnoreCase("admin@georgebrown.ca") && password.equalsIgnoreCase("admin123") ){
				request.getRequestDispatcher("/CookieServlet").forward(request, response);
				//from web.xml file
				log("User "+ user.getEmail() + " from "+ getServletContext().getInitParameter("School") 
						 +" has successfully logged in ");
			}
			else {
				response.setContentType("text/html");
				//setting a failed login msg and inform the end-user
				request.setAttribute("message", "failed Login attempt");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		
		}
				
		
	}
		


}
