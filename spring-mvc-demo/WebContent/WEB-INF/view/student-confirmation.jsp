<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	<h2> Student Registered - ${student.firstName} ${student.lastName} </h2>
	<br><br>
	<h3> Other details are as following - </h3>
	<br>
	Country - ${student.country}
	<br>
	Favourite Language - ${student.favouriteLang}
	<br>
	Operating System Used -
	<br>
	<ol>
		<c:forEach var="temp" items="${student.OS}">
			<li>${temp}</li>
		</c:forEach>
	</ol>
</body>
</html>