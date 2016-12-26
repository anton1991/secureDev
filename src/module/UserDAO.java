package module;
import java.text.*;
import java.util.*;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.sql.*;
import java.sql.PreparedStatement;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import secureDev.ConnectionManager;
import module.UserBean;

public class UserDAO 	
{
   static Connection currentCon = null;
   static ResultSet rs = null;  
	
public static Boolean sign_up(UserBean bean)
{
	PreparedStatement stmt=null;
	if (is_user_exists(bean.getUsername()))
	{
		return false;
	}
	try
	{
		//connect to DB 
		
		currentCon = ConnectionManager.getConnection();
	    //clear sql injection threat
	    stmt= currentCon.prepareStatement("INSERT INTO user_auth (FIRST_NAME, LAST_NAME, EMAIL,PASSWORD, TYPE, PHOTO) VALUES (?,?,?,?,?,?);");
	    stmt.setString(1, bean.getFirstName());
	    stmt.setString(2, bean.getLastName());
	    stmt.setString(3, bean.getUsername());
	    stmt.setString(4, bean.getPassword());
	    stmt.setString(5, bean.getType());
	    stmt.setString(6, bean.getPhoto());
	    stmt.executeUpdate();	    
	    
	}
	catch (Exception ex) 
	{
		System.out.println("Sgin In failed: An Exception has occurred! " + ex);
		return false;
	}
    if (currentCon != null) {
        try {
           currentCon.close();
        } catch (Exception e) {
        }
    }
	return true;
}

public static UserBean get_user_data(String user_email)
{
	PreparedStatement stmt=null;
	UserBean bean = new UserBean();
	try
	{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();
		    //clear sql injection threat

				stmt= currentCon.prepareStatement("select * from user_auth where  EMAIL = ?;");
				stmt.setString(1, user_email);
		    rs = stmt.executeQuery();	
		    while ( rs.next() )
		    {
		    	bean.setFirstName(rs.getString("FIRST_NAME"));
		    	bean.setLastName(rs.getString("LAST_NAME"));
		    	bean.setUserName(rs.getString("EMAIL"));
		    	bean.setPhone(rs.getString("PHONE"));
		    	bean.setAddess(rs.getString("ADDRESS"));
		    	bean.setPhoto(rs.getString("PHOTO"));
		    }
		    if (currentCon != null) {
		        try {
		           currentCon.close();
		        } catch (Exception e) {
		        }
		    }
		    return bean;
	}
	catch (Exception ex) 
	{
		System.out.println("Show data failed: An Exception has occurred! " + ex);
		return null;
	}
}

private static boolean is_user_exists(String User_name)
{
	PreparedStatement stmt=null;
	//connect to DB 
	try
	{
	currentCon = ConnectionManager.getConnection();
	stmt= currentCon.prepareStatement("select * from user_auth WHERE EMAIL = ?");
	stmt.setString(1, User_name);
	rs = stmt.executeQuery();	        
    boolean more = rs.next();
    if (more)
    {
        if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }
        }
    	return true;
    }
    else 
    {
        if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }
        }
    	return false;
    }
	}
	
	catch (Exception ex) 
	{
		System.out.println("is user exists  failed: An Exception has occurred! " + ex);
		return false;
	}
}
	

public static boolean update_user_data(UserBean bean)
{
	PreparedStatement stmt=null;
	try
	{
			//connect to DB 
			currentCon = ConnectionManager.getConnection();
		    //clear sql injection threat

				stmt= currentCon.prepareStatement("UPDATE user_auth SET FIRST_NAME = ?, LAST_NAME = ?, PHONE = ?,ADDRESS = ?,PHOTO = ? WHERE EMAIL = ?");
				stmt.setString(1, bean.getFirstName());
				stmt.setString(2, bean.getLastName());
				stmt.setString(3, bean.getPhone());
				stmt.setString(4, bean.getAddress());
				stmt.setString(5, bean.getPhoto());
				stmt.setString(6, bean.getUsername());
				stmt.executeUpdate();	
			    if (currentCon != null) {
			        try {
			           currentCon.close();
			        } catch (Exception e) {
			        }
			    }	
		    return true;
	}
	catch (Exception ex) 
	{
		System.out.println("update data failed: An Exception has occurred! " + ex);
		return false;
	}
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
         String type = rs.getString("TYPE");
	     	
         System.out.println("Welcome " + firstName);
         bean.setFirstName(firstName);
         bean.setLastName(lastName);
         bean.setType(type);
         bean.setValid(true);
      }
      if (currentCon != null) {
          try {
             currentCon.close();
          } catch (Exception e) {
          }
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