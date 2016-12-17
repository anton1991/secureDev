package controllers;

import module.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import module.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        super();
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("LogInPage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	    
	         HttpSession session = request.getSession(true);	    
		     UserBean user = new UserBean();
		     String sessionId = session.getId();
		     Cookie userCookie = new Cookie("JSESSIONID", sessionId);
		     user.setUserName(request.getParameter("username"));
		     user.setPassword(request.getParameter("password"));

		     user = UserDAO.login(user);
			   		    
		     if (user.isValid())
		     {
					//setting cookie to expiry in 30 mins
		          session.setAttribute("user_name",user.getFirstName());
		          session.setAttribute("loged_in", "true");
		          
		            
		            response.addCookie(userCookie);
		          request.getRequestDispatcher("Home").forward(request, response);

		     }
			        
		     else 
		     {
		    	 userCookie.setMaxAge(0);
		    	 response.addCookie(userCookie);
		    	 request.setAttribute("msg", "fuck you");
		    	 request.getRequestDispatcher("LogInPage.jsp").forward(request, response);
		     }
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
		       
	}
}

