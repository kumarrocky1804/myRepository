<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- spring security JSP tag lib -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h2> New Company Home page </h2>
	<hr>
	<p>
	Welcome to the home page
	</p>
	
	<hr>
	<!--  Display username and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		ROle: <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	<!-- Add links for managers -->
	<security:authorize access="hasRole('MANAGER')">
		<a href="${pageContext.request.contextPath}/leaders">Leaders Meeting</a>
		(Only for leaders)
	</security:authorize>
	
	<hr>
	<!-- Add links for admins -->
	<security:authorize access="hasRole('ADMIN')">
		<a href="${pageContext.request.contextPath}/system">Admin Meeting</a>
		(Only for Admins)
	</security:authorize>
	<hr>
	
	<!--  add logout button -->
	<!--  logout listener is default provided by spring security -->
	<form:form action="${pageContext.request.contextPath}/logout" 
							   method="POST">
			<input type="submit" value="logout" />		
	</form:form>
</body>
</html>