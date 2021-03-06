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
	
		<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               	</div>
	            </div> 
				<div class="main-login main-center"  style="border-radius: 50px 50px;opacity:0.95;background:#fff;width:800px;margin:0 auto;margin-top:0;text-align:center;">
					<form class="form-horizontal" enctype="multipart/form-data" action="SignInController" method="post" style="width:300px; margin:0 auto" >
						
						<div class="form-group" >
							<label for="name" class="cols-sm-2 control-label">first Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" style="width:200px" name="first_name" id="name"  placeholder="Enter your first Name"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">last name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" style="width:200px" name="last_name" id="last_name"  placeholder="Enter your last name"/>
								</div>
							</div>
						</div>
						<div class="form-group" >
							<label for="email" class="cols-sm-2 control-label">Your Email</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="email" class="form-control" style="width:200px" name="email" id="inputEmail" placeholder="Email address" required autofocus/>
								</div>
							</div>
						</div>



						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label" >Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" style="width:200px" name="password" id="inputPassword"  required placeholder="Enter your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" style="width:200px" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type=submit class="btn btn-primary btn-lg btn-block login-button" style="width:200px">Register</button>
						</div>

					</form>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
		<script>		
			var password = document.getElementById("password"), confirm = document.getElementById("confirm");
			function validatePassword(){
  			if(password.value != confirm.value) {
    			confirm.setCustomValidity("Passwords Don't Match");
  				} else {
    				confirm.setCustomValidity('');
  				}
			}

			password.onchange = validatePassword;
			confirm.onkeyup = validatePassword;
		</script>
		</jsp:body>
		</t:genericpage>
		

