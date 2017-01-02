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
import java.nio.file.StandardCopyOption;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Servlet implementation class SignInController
 */
@WebServlet("/SignInController")
@MultipartConfig(maxFileSize = 16177215) 
public class SignInController extends HttpServlet {
	
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println(hashtext);
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 
	
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
		String absolute_path = getServletContext().getInitParameter("user_photos");
		String relative_path = "/secureDev/Images/";
        
        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
        	File uploads = new File(absolute_path);

        	File file = new File(uploads, request.getParameter("email")+"_photo.jpg");

        	try (InputStream input = filePart.getInputStream()) {
        	    Files.copy(input, file.toPath(),StandardCopyOption.REPLACE_EXISTING);
        	    new_user.setPhoto(relative_path+request.getParameter("email")+"_photo.jpg");
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
	    new_user.setPhoto("/secureDev/img/20.jpg");
	    System.out.println("password");
	    new_user.setPassword(getMD5(request.getParameter("password") + request.getParameter("email")));
	     
	    new_user.setType("guest");
   	 	boolean status = UserDAO.sign_up(new_user);
   	 	if (status)
   	 	{
   	 		request.getRequestDispatcher("/WEB-INF/LogInPage.jsp").forward(request, response);
   	 	}
   	 	else
   	 	{
   	 		System.out.println("user already exists" );
   	 		request.getRequestDispatcher("/WEB-INF/SignUp.jsp").forward(request, response);
   	 	}

	}
	


}


