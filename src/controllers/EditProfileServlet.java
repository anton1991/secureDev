package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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
	    	request.setAttribute("img_url", user_data.getPhoto());
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
		HttpSession session = request.getSession(false);	   
	     if(session  !=null && session.getAttribute("loged_in").equals("true"))
	     {
	 		// TODO Auto-generated method stub
	 		UserBean new_user = new UserBean();
	 		InputStream inputStream = null; // input stream of the upload file
	 	
	         
	         // obtains the upload file part in this multipart request
	         Part filePart = request.getPart("photo");
	         System.out.println(System.getProperty("user.dir"));
	         if (filePart != null) {
	         	File uploads = new File(System.getProperty("user.dir"));

	         	File file = new File(uploads, request.getParameter("email")+"_photo.jpg");

	         	try (InputStream input = filePart.getInputStream()) {
	         	    Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
	         	    new_user.setPhoto(System.getProperty("user.dir")+"/"+request.getParameter("email")+"_photo.jpg");
	         	}
	         	catch (Exception ex) 
	         	   {
	         	      System.out.println("upload photo: An Exception has occurred! " + ex);
	         	      
	         	      return;
	         	   }  
	         }
	 		
	 		new_user.setFirstName(request.getParameter("first_name"));
	 		new_user.setLastName(request.getParameter("last_name"));
	 	    new_user.setUserName(request.getParameter("email"));
	 	    new_user.setPassword(request.getParameter("password"));
	 	     
	    	 request.getRequestDispatcher("/WEB-INF/ProfileEdit.jsp").include(request, response);
	     }
	     else 
	     {
	    	 request.getRequestDispatcher("LogIn").include(request, response);
	     }
	}

}
