package module;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.sql.PreparedStatement;
import secureDev.ConnectionManager;
import module.UserBean;

public class UserDAO 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
	
public static Boolean sign_up(UserBean bean)
{
	PreparedStatement stmt=null;
	
	try
	{
		//connect to DB 
		currentCon = ConnectionManager.getConnection();
	    //clear sql injection threat
	    stmt= currentCon.prepareStatement("select * from user_auth where EMAIL=? AND PASSWORD = ?;");
	    stmt.setString(1, bean.getUsername());
	    stmt.setString(2, bean.getPassword());
	    
	}
	catch (Exception ex) 
	{
		System.out.println("Log In failed: An Exception has occurred! " + ex);
		return false;
	}
	return true;
}
	
public static UserBean login(UserBean bean) {
	
      //preparing some objects for connection       
   PreparedStatement stmt=null;
   try 
   {
      //connect to DB 
      currentCon = ConnectionManager.getConnection();
      
      //clear sql injection threat
      System.out.println(bean.getUsername() + bean.getPassword());
      stmt= currentCon.prepareStatement("SELECT * FROM user_auth WHERE EMAIL= ? AND PASSWORD = ?");
      System.out.println(bean.getUsername() + bean.getPassword());
      stmt.setString(1, bean.getUsername());
      stmt.setString(2, bean.getPassword());
      rs = stmt.executeQuery();	        
      boolean more = rs.next();
	       
      // if user does not exist set the isValid variable to false
      if (!more) 
      {
         System.out.println("Sorry, you are not a registered user! Please sign up first");
         bean.setValid(false);
      } 
	        
      //if user exists set the isValid variable to true
      else if (more) 
      {
         String firstName = rs.getString("First_Name");
         String lastName = rs.getString("Last_Name");
	     	
         System.out.println("Welcome " + firstName);
         bean.setFirstName(firstName);
         bean.setLastName(lastName);
         bean.setValid(true);
      }
   } 

   catch (Exception ex) 
   {
      System.out.println("Log In failed: An Exception has occurred! " + ex);
   } 
	    
   //some exception handling
   finally 
   {
      if (rs != null)	{
         try {
            rs.close();
         } catch (Exception e) {}
            rs = null;
         }
	
      if (stmt != null) {
         try {
            stmt.close();
         } catch (Exception e) {}
            stmt = null;
         }
	
      if (currentCon != null) {
         try {
            currentCon.close();
         } catch (Exception e) {
         }

         currentCon = null;
      }
   }

return bean;
	
   }	
}