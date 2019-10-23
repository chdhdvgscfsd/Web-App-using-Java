package ca.gbc.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		request.setAttribute("adminUser", user);
		
		if(username != null && username.length()>0) {
			if(username.equalsIgnoreCase("admin@georgebrown.ca") && password.equalsIgnoreCase("admin123") ){
				request.getRequestDispatcher("admin.html").forward(request, response);
				log("User "+ user.getEmail() + " from "+ getServletContext().getInitParameter("School") 
						 +" has successfully logged in ");
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.print("<h2>Admin Invalid Credentials Provided!</h2>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		
		}
				
		
	}
		


}
