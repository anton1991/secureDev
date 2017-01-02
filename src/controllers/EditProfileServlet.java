package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(maxFileSize = 16177215) 

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
	    	System.out.println(user_data.getLastName());
	    	System.out.println(user_data.getLastName());
	    	System.out.println(session.getAttribute("user_name").toString());
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
	 		UserBean new_user = UserDAO.get_user_data(session.getAttribute("user_name").toString());
	 		InputStream inputStream = null; // input stream of the upload file
	 		String absolute_path = getServletContext().getInitParameter("user_photos");
			String relative_path = "/secureDev/Images/";
	 	
	         
	        // obtains the upload file part in this multipart request
			Part filePart = null;
			
			try{
	        filePart = request.getPart("photo");
			}
			catch (Exception ex) 
     	   {
     	      System.out.println("upload photo: An Exception has occurred! " + ex);
     
     	   }  
			System.out.println(filePart);
	        if (filePart != null) {
	        	System.out.println("photo not null");
	        	File uploads = new File(absolute_path);

	        	File file = new File(uploads, session.getAttribute("user_name").toString()+"_photo.jpg");

	        	try (InputStream input = filePart.getInputStream()) {
	        	    Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
	        	    new_user.setPhoto(relative_path+session.getAttribute("user_name").toString()+"_photo.jpg");
	        	}
	        	catch (Exception ex) 
	        	   {
	        	      System.out.println("upload photo: An Exception has occurred! " + ex);
	        	   }  
	        }
	        else
	        {
	        	new_user.setPhoto(request.getParameter("old_photo"));
	        }

	 		new_user.setFirstName(request.getParameter("first_name"));
	 		new_user.setLastName(request.getParameter("last_name"));
	 		new_user.setAddess(request.getParameter("add"));
	 		new_user.setPhone(request.getParameter("phone"));
	 	    new_user.setUserName(session.getAttribute("user_name").toString());
	 	    
	 	    UserDAO.update_user_data(new_user);
	 	    response.sendRedirect("Profile");
	     }
	     else 
	     {
	    	 request.getRequestDispatcher("LogIn").include(request, response);
	     }
	}

}
