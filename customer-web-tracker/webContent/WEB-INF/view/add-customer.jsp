<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- importing Spring form tags library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- import JSTL library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type = "text/css" rel="stylesheet"
		href = "<c:url value="/resources/css/style.css" />"/>
<link type = "text/css" rel="stylesheet"
		href = "<c:url value="/resources/css/add-customer-style.css" />"/>
<title>Save Customer</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager </h2>
		</div>
	</div>
	
	<div id="container">
		<h3> SAVE CUSTOMER </h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="post">
			<!-- Adding hidden field for primary key -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;">
			<p>
				<a href="<c:url value="/customer/list"/>">
					Back to List
				</a>
			</p>
		</div>
	</div>
</body>
</html>