

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

import java.util.Date;

import ca.gbc.library.beans.User;
import ca.gbc.library.beans.Utility;
import ca.gbc.library.cookies.PersistentCookie;


@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CookieServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//creating a session scope for the admin user for that session		
		HttpSession session = request.getSession();
		final Object lock = request.getSession().getId().intern();
		User adminUser;
		synchronized(lock) {
			adminUser = (User) session.getAttribute("adminUser");
		}
		
		Utility u = new Utility();
		String dt = u.getCurrentDateTime();
		log("Cookie created successfully for last access "+ dt);
		//avoid the use of empty spaces
		PersistentCookie pc = new PersistentCookie(adminUser.getRole()+"-last-access",dt);
		
		response.addCookie(pc);
		log("Cookie created successfully for last access"+ dt);
		
		
		String page = (adminUser.getRole().equals("admin"))? 
				"admin.jsp" : "librarain.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

}
