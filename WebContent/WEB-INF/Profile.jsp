<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
		<!-- 
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'> -->
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
 
 
<div class="container">
      <div class="row">

        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">${user_data.getFirstName()} ${user_data.getLastName()}</h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center" style="width=100px; height=100px;"> <img alt="User Pic" src="${user_data.getPhoto()}" class="img-circle img-responsive"> </div>
                

                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>First Name:</td>
                        <td><c:out value="${user_data.getFirstName()}" /></td>
                      </tr>
                      <tr>
                        <td>Last Name:</td>
                        <td><c:out value="${user_data.getLastName()}" /></td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td><c:out value="${user_data.getUsername()}" /></td>
                      </tr>
                        <tr>
                        <td>Home Address:</td>
                        <td><c:out value="${user_data.getAddress()}" /></td>
                      </tr>
                        <td>Phone Number:</td>
                        <td><c:out value="${user_data.getPhone()}" /></td>
                           
                      </tr>
                     
                    </tbody>
                  </table>
                  
                  <a href="/secureDev/ShowAppointment" class="btn btn-primary">My Appointments</a>
                  <a href="/secureDev/Calendar" class="btn btn-primary">Order a new Appointment</a>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                        <span class="panel-footer" class="pull-right">
                            <a href="/secureDev/EditProfile" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a href="/secureDev/LogOut" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>  
          </div>
        </div>
      </div>
    </div>

    
    </jsp:body>
</t:genericpage>
