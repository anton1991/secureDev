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
 
<div class="container" >
    <div class="col-md-4 col-sm-6 col-xs-12" >
      <div class="text-center" >
        <img src="${profile.getPhoto()}" name ="photo" class="avatar img-circle img-thumbnail" alt="avatar" style="width=100px; height=100px;">
      </div>
      </div>
<form class="form-horizontal" action="EditProfile" enctype="multipart/form-data" method="post">
    <!-- left column -->

    <!-- edit form column -->
    <div class="col-md-8 col-sm-6 col-xs-12 personal-info">
      <h3>Personal info</h3>
      
        <div class="form-group">
          <label class="col-lg-3 control-label">First name:</label>
          <div class="col-lg-8">
            <input class="form-control" name="first_name" value="${profile.getFirstName()}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Last name:</label>
          <div class="col-lg-8">
            <input class="form-control" name="last_name" value="${profile.getLastName()}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Email:</label>
          <div class="col-lg-8">
            <input class="form-control" value="${profile.getUsername()}" disabled type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Home Adress:</label>
          <div class="col-lg-8">
            <input class="form-control" name="add" value="${profile.getAddress()}" type="text">
          </div>
        </div>
        <div class="form-group">
          <label class="col-lg-3 control-label">Phone Number:</label>
          <div class="col-lg-8">
            <input class="form-control" name="phone" value="${profile.getPhone()}" type="text">
          </div>
        </div>
        <div class="form-group">
			<label class="col-md-3 control-label"></label>
			<div class="col-lg-8" style="padding-left:205px;">
				<input type="file" name="photo" />
				<input type="hidden" name="old_photo" value="${profile.getPhoto()}"/>
			</div>
									
		</div>
          <div class="col-md-8">
            <input class="btn btn-primary" value="Save Changes" type="submit">
            <span></span>
          </div>
        </div>
      </form>
    
</div>
</div>

    
    </jsp:body>
</t:genericpage>
