package module;

import module.AppointmentBean;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import java.sql.*;

import secureDev.ConnectionManager;

public class AppointmentDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static Boolean set_appointment(AppointmentBean bean)
	{
		PreparedStatement stmt=null;
		
		try
		{
				//connect to DB 
				currentCon = ConnectionManager.getConnection();
			    //clear sql injection threat
			    stmt= currentCon.prepareStatement("INSERT INTO appointment (FIRST_NAME, LAST_NAME, EMAIL,MESSAGE,REGARDING,MONTH,DAY,TIME,PHONE,OWNER) VALUES (?,?,?,?,?,?,?,?,?,?);");
			    stmt.setString(1, bean.getFirstName());
			    stmt.setString(2, bean.getLastName());
			    stmt.setString(3, bean.getEmail());
			    stmt.setString(4, bean.getMessage());
			    stmt.setString(5, bean.getRegarding());
			    stmt.setString(6, bean.getMonth());
			    stmt.setString(7, bean.getDay());
			    stmt.setString(8, bean.getTime());
			    stmt.setString(9, bean.getPhone());
			    stmt.setString(10, bean.getOwner());
			    stmt.executeUpdate();	  
		}
		catch (Exception ex) 
		{
			System.out.println("Log In failed: An Exception has occurred! " + ex);
			return false;
		}
		return true;
	}

}
