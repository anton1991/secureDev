package controllers;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
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
}  