<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<!-- Home page is just redirecting the user to customer list page -->
	<% response.sendRedirect("customer/list"); %>
</body>
</html>