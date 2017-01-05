package module;

import module.AppointmentBean;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import java.sql.*;

import secureDev.ConnectionManager;
import secureDev.XssUtils;
import module.UserBean;
import module.UserDAO;

public class AppointmentDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	public static Boolean set_appointment(AppointmentBean bean, UserBean usr)
	{
		PreparedStatement stmt=null;
		try
		{
				//connect to DB 
				currentCon = ConnectionManager.getConnection();
			    //clear sql injection threat and xss
			    stmt= currentCon.prepareStatement("INSERT INTO appointment (FIRST_NAME, LAST_NAME, EMAIL,MESSAGE,REGARDING,MONTH,DAY,TIME,PHONE,OWNER) VALUES (?,?,?,?,?,?,?,?,?,?);");
			    stmt.setString(1, XssUtils.clearXss(usr.getFirstName()));
			    stmt.setString(2, XssUtils.clearXss(usr.getLastName()));
			    stmt.setString(3, XssUtils.clearXss(usr.getUsername()));
			    stmt.setString(4, XssUtils.clearXss(bean.getMessage()) );
			    stmt.setString(5, XssUtils.clearXss(bean.getRegarding()));
			    stmt.setString(6, XssUtils.clearXss(bean.getMonth()));
			    stmt.setString(7, XssUtils.clearXss(bean.getDay()));
			    stmt.setString(8, XssUtils.clearXss(bean.getTime()) );
			    stmt.setString(9, XssUtils.clearXss(bean.getPhone()));
			    stmt.setString(10, XssUtils.clearXss(bean.getOwner()));
			    stmt.executeUpdate();	  
		}
		catch (Exception ex) 
		{
			System.out.println("Log In failed1: An Exception has occurred! " + ex);
			return false;
		}
		return true;
	}
	public static List<AppointmentBean> get_appointment_regular(String Owner, String type)
	{
		PreparedStatement stmt=null;
		AppointmentBean bean = new AppointmentBean();
		List<AppointmentBean> beans = new ArrayList<AppointmentBean>();
		try
		{
				//connect to DB 
				currentCon = ConnectionManager.getConnection();
			    //clear sql injection threat
				type=type.toString();
				//user type is saved in session and can only be accessed via db
				//so the user can't change his type(admin/guest).
				if (!type.equals("admin"))
				{
					System.out.println(type);
					stmt= currentCon.prepareStatement("select FIRST_NAME, LAST_NAME, EMAIL,MESSAGE,REGARDING,MONTH,DAY,TIME,PHONE from appointment where  OWNER = ?;");
					stmt.setString(1, Owner);
				}
				else
				{
					System.out.println(type);
					stmt= currentCon.prepareStatement("select FIRST_NAME, LAST_NAME, EMAIL,MESSAGE,REGARDING,MONTH,DAY,TIME,PHONE from appointment");
				}
				rs = stmt.executeQuery();	
			    while ( rs.next())
			    {
			    	bean = new AppointmentBean();
			    	bean.setFirstName(XssUtils.clearXss(rs.getString("FIRST_NAME")));
			    	bean.setLastName(XssUtils.clearXss(rs.getString("LAST_NAME")) );
			    	bean.setEmail(XssUtils.clearXss(rs.getString("EMAIL")));
			    	bean.setDay(XssUtils.clearXss(rs.getString("DAY")));
			    	bean.setMonth(XssUtils.clearXss(rs.getString("MONTH")));
			    	bean.setTime(XssUtils.clearXss(rs.getString("TIME")));
			    	bean.setPhone(XssUtils.clearXss(rs.getString("PHONE")));
			    	bean.setRegarding(XssUtils.clearXss(rs.getString("REGARDING")));
			    	bean.setOWNER(Owner);
			    	bean.setMessage(XssUtils.clearXss(rs.getString("MESSAGE")));
			    	beans.add(bean);
			    }
			    return beans;
		}
		catch (Exception ex) 
		{
			System.out.println("Log In failed2: An Exception has occurred! " + ex);
			return null;
		}
	}
	

}
