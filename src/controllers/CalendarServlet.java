package controllers;  
  
import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import module.AppointmentBean;
import module.AppointmentDAO; 
import module.UserBean;
import module.UserDAO;
import secureDev.XssUtils;


@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
        response.setContentType("text/html");  
        HttpSession session = request.getSession(false);
        UserBean user_data = null;
        //validate that user is loged in
        if(session  !=null && session.getAttribute("loged_in").equals("true"))
        {
        	request.setAttribute("user_loged_in", "anton");
        	user_data = UserDAO.get_user_data(session.getAttribute("user_name").toString());
        	request.setAttribute("profile", user_data);
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
		UserBean user_data = null;
		//validate that user is loged in
		if(session  !=null && session.getAttribute("loged_in").equals("true"))
		{
			try
			{	   
				//create new_apoint module and save it 
	        	user_data = UserDAO.get_user_data(session.getAttribute("user_name").toString());
	        	request.setAttribute("profile", user_data);
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
				System.out.println(new_apoint.getFirstName()+"---"+new_apoint.getOwner()+"---"+new_apoint.getEmail());
				System.out.println(user_data.getUsername());
				boolean res = AppointmentDAO.set_appointment(new_apoint, user_data);
		    }
			catch (Exception ex)
			{
				System.out.println("Log In failesd: An Exception has occurred! " + ex);
			}
		}
		else
		{
			response.sendRedirect("LogIn");
		}
		response.sendRedirect("Home");
		
	}
}  