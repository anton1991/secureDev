package controllers;

import module.UserBean;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import module.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
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
	 * Default constructor.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/LogInPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(true);
			UserBean user = new UserBean();
			String sessionId = session.getId();
			Cookie userCookie = new Cookie("JSESSIONID", sessionId);
			userCookie.setHttpOnly(true);
			user.setUserName(request.getParameter("username"));
			user.setPassword(getMD5(request.getParameter("password") + request.getParameter("username")));

			user = UserDAO.login(user);

			if (user.isValid()) {
				// setting cookie to expiry in 30 mins
				session.setAttribute("user_name", user.getUsername());
				session.setAttribute("loged_in", "true");
				session.setAttribute("user_type", user.getType());
				response.addCookie(userCookie);
				request.getRequestDispatcher("Home").forward(request, response);

			}

			else {
				userCookie.setMaxAge(0);
				response.addCookie(userCookie);
				request.setAttribute("msg", "fuck you");
				request.getRequestDispatcher("LogIn").forward(request, response);
			}
		}

		catch (Throwable theException) {
			System.out.println(theException);
		}

	}
}
