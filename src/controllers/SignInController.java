package controllers;

import module.UserDAO;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import module.UserBean;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
@MultipartConfig(maxFileSize = 16177215) 
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
		 request.getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean new_user = new UserBean();
		InputStream inputStream = null; // input stream of the upload file
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        System.out.println(filePart.toString());
        if (filePart != null) {
        	File uploads = new File(System.getProperty("user.dir"));

        	File file = new File(uploads, request.getParameter("email")+"_photo.jpg");

        	try (InputStream input = filePart.getInputStream()) {
        	    Files.copy(input, file.toPath());
        	    new_user.setPhoto(request.getParameter("email")+"_photo.jpg");
        	}
        	catch (Exception ex) 
        	   {
        	      System.out.println("upload photo: An Exception has occurred! " + ex);
        	      
        	      System.out.println(System.getProperty("user.dir"));
        	      return;
        	   }  
        }
		
		new_user.setFirstName(request.getParameter("first_name"));
		new_user.setLastName(request.getParameter("last_name"));
	    new_user.setUserName(request.getParameter("email"));
	    new_user.setPassword(request.getParameter("password"));
	     
	    new_user.setType("guest");
   	 	UserDAO.sign_up(new_user);
   	 	request.getRequestDispatcher("/WEB-INF/LogInPage.jsp").forward(request, response);

	}

}
