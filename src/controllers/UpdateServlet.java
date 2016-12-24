package controllers;
import module.UserDAO;
import secureDev.ConnectionManager;
import module.UserBean;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);	
		 UserBean user_data = null;
	     if(session  !=null && session.getAttribute("loged_in").equals("true"))
	     {
	    	user_data = UserDAO.get_user_data(session.getAttribute("user_name").toString());
	    	request.setAttribute("user_data", user_data);
        	request.getRequestDispatcher("/WEB-INF/Profile.jsp").include(request, response); 
	          
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
		HttpSession session = request.getSession(false);	   
	     if(session  !=null && session.getAttribute("loged_in").equals("true"))
	     {
	    	 request.getRequestDispatcher("/WEB-INF/Profile.jsp").include(request, response);
	     }
	     else 
	     {
	    	 request.getRequestDispatcher("LogIn").include(request, response);
	     }
	}

}
