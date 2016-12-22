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
 
 
      <table class="table table-hover" style="margin: 0 auto; width: 800px; text-align: center; overflow-y:scroll; height: 500px; display: block">
    <!-- here should go some titles... -->
    <tr class="active" >
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Message</th>
    </tr>
    <c:forEach items="${appointment}"  var="book">
    <tr class="success">
        <td>
            <c:out value="${book.getFirstName()}" />
        </td>
        <td>
            <c:out value="${book.getLastName()}" />
        </td>
        <td>
            <c:out value="${book.getEmail()}" />
        </td>
        <td>
            <c:out value="${book.getMessage()}" />
        </td>
    </tr>
    </c:forEach>
</table>

    
    </jsp:body>
</t:genericpage>
