<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Spring library for spring form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- JSTL tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer Form</title>
	<!-- 
	<style type="text/css">
		.error{
			color:red
		}
	</style> -->
	<!--  Loading CSS from file -->
	<link type = "text/css" rel="stylesheet"
		href = "<c:url value="/resources/css/style.css" />"/>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
		First name: <form:input path="firstName"/>
		<br><br>
		
		<!-- if errors display with field -->
		Last Name: <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
		<br><br>
		
		Free Passes: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		<br><br>
		
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		
		Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		<br><br>
		
		<input type="submit" value="Register">
	</form:form>
	
	<!--  Loading JS -->
	<script src="<c:url value="/resources/js/script.js"/>"></script> />
</body>
</html>