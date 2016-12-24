<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
 
      <form class="form-signin" method="post" action="LoginServlet" style="max-width: 330px;
  padding: 15px;
  margin: 0 auto;">

		<c:choose> 
		  <c:when "{false}">
		    <h2 class="form-signin-heading">Please Login:</h2>
		  </c:when>
		  <c:otherwise>
		    <h2 class="form-signin-heading">${msg}</h2>
		  </c:otherwise>
		</c:choose>
        
                		<div class="form-group">
							<label for="inputEmail" class="sr-only">Email address</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa-lg" aria-hidden="true"></i></span>
									<input name='username' type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus style="width:200px">
								</div>
							</div>
						</div>
        				<div class="form-group">
							<label for="inputPassword" class="sr-only">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required style="width:200px">
								</div>
							</div>
						</div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:200px">Sign in</button>
      </form>

    
    </jsp:body>
</t:genericpage>
