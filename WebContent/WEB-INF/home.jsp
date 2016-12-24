<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
            <h3>Book an appointment online - NOW!</h3>
            <br>
            <a href="#about" class="btn btn-dark btn-lg">Find Out More</a>
			<c:choose>
			    <c:when test="${empty user_loged_in}">
					<a href="LogIn" class="btn btn-dark btn-lg">Log In</a>
            		<a href="SignUp" class="btn btn-dark btn-lg">Sign Up</a>			    
            		</c:when>
			    <c:otherwise>
			    	<a href="Profile" class="btn btn-dark btn-lg">Your Profile</a>
			   </c:otherwise>
			</c:choose> 
		
            
    </jsp:body>
</t:genericpage>
