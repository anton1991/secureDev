package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import module.AppointmentBean;
import module.AppointmentDAO;

/**
 * Servlet implementation class ShowAppointmentsServlet
 */
@WebServlet("/ShowAppointmentsServlet")
public class ShowAppointmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAppointmentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		List<AppointmentBean> appointments = null;
        if(session  !=null && session.getAttribute("loged_in").equals("true"))
        {
        	appointments = AppointmentDAO.get_appointment_regular(session.getAttribute("user_name").toString(),session.getAttribute("user_type").toString());
        	request.setAttribute("appointment", appointments);
        	request.setAttribute("user_loged_in", session.getAttribute("user_name"));
        	request.getRequestDispatcher("/WEB-INF/Admin.jsp").include(request, response); 
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
