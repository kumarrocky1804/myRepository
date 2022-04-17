<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	<h2> Customer Confirmed - ${customer.firstName} ${customer.lastName} </h2>
	<br>
	<h3> Other detils are - </h3>
	<br>
	Free passes - ${customer.freePasses}
	<br>
	Postal Code - ${customer.postalCode}
	<br>
	Course Code - ${customer.courseCode}
</body>
</html>