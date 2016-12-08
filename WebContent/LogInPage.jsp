<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

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
		    <h2 class="form-signin-heading">Please sign in</h2>
		  </c:when>
		  <c:otherwise>
		    <h2 class="form-signin-heading">${msg}</h2>
		  </c:otherwise>
		</c:choose>
        
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name='username' type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus style="width:200px">
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required style="width:200px">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="width:200px">Sign in</button>
      </form>

    
    </jsp:body>
</t:genericpage>
