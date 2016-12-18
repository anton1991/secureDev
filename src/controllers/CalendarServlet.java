package controllers;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import module.AppointmentBean;
import module.AppointmentDAO;  
public class CalendarServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
        response.setContentType("text/html");  
        HttpSession session = request.getSession(false);	   
        if(session  !=null && session.getAttribute("loged_in").equals("true"))
        {
        	request.setAttribute("user_loged_in", "anton");
        	request.getRequestDispatcher("/WEB-INF/Calendar.jsp").include(request, response); 
        }
        else
        {
        	System.out.println("not autoraized");
        	response.sendRedirect("LogIn");
        }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		AppointmentBean new_apoint = new AppointmentBean(); 
		if(session  !=null && session.getAttribute("loged_in").equals("true"))
		{
			try
			{	    
				new_apoint.setOWNER(session.getAttribute("user_name").toString());
				new_apoint.setFirstName(request.getParameter("first_name"));
				new_apoint.setLastName(request.getParameter("last_name"));
				new_apoint.setPhone(request.getParameter("phone"));
				new_apoint.setEmail(request.getParameter("email"));
				new_apoint.setRegarding(request.getParameter("regarding"));
				new_apoint.setMonth(request.getParameter("month"));
				new_apoint.setDay(request.getParameter("day"));
				new_apoint.setTime(request.getParameter("time"));
				new_apoint.setMessage(request.getParameter("message"));
				boolean res = AppointmentDAO.set_appointment(new_apoint);
		    }
			catch (Exception ex)
			{
				System.out.println("Log In failesd: An Exception has occurred! " + ex);
			}
		}
	}
}  