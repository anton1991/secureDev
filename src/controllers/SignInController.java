package controllers;

import module.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.UserBean;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("SignUp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean new_user = new UserBean();
		
		
		new_user.setFirstName(request.getParameter("first_name"));
		new_user.setLastName(request.getParameter("last_name"));
	    new_user.setUserName(request.getParameter("email"));
	    new_user.setPassword(request.getParameter("password"));
   	 	UserDAO.sign_up(new_user);
   	 	request.getRequestDispatcher("/WEB-INF/LogInPage.jsp").forward(request, response);

	}

}
