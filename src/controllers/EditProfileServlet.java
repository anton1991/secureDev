package controllers;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(false);	
		 UserBean user_data = null;
	     if(session  !=null && session.getAttribute("loged_in").equals("true"))
	     {
	    	user_data = UserDAO.get_user_data(session.getAttribute("user_name").toString());
	    	request.setAttribute("profile", user_data);
	    	System.out.println(user_data.getUsername());
	    	request.getRequestDispatcher("/WEB-INF/ProfileEdit.jsp").include(request, response); 
	          
	     }
	     else 
	     {
	    	 request.getRequestDispatcher("LogIn").include(request, response);
	     }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
