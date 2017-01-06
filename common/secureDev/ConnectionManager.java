package secureDev;

import java.sql.*;

public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
    	  String url = "jdbc:sqlite:/Users/dorlaker/MySQLiteDB"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("org.sqlite.JDBC");
         
         try
         {            	
        	 //todoo add user name and password to database!!
            con = DriverManager.getConnection(url); 
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}