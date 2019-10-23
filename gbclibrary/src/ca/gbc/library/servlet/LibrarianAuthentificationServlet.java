package ca.gbc.library.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.gbc.library.beans.User;



public class LibrarianAuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public LibrarianAuthentificationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create a new user
		User user = new User();
		String username = request.getParameter("librarianEmail");
		String password = request.getParameter("librarianPassword");
		String role = "librarian";
		
		//get the user info
		user.setEmail(username);
		user.setPassword(password);
		user.setRole(role);
		
		//set the attribute
		request.setAttribute("librarian", user);
	
		
		if(username != null && username.length()>0) {
			if(username.equalsIgnoreCase("user@georgebrown.ca") && password.equalsIgnoreCase("user123") ){
				request.getRequestDispatcher("librarian.html").forward(request, response);
				log("User "+ user.getEmail() + " from "+ getServletContext().getInitParameter("Locals") 
						 +" has successfully logged in ");
			}
			else {
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.print("<h3>User Invalid Credentials Provided!</h3>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		}
	}

}
