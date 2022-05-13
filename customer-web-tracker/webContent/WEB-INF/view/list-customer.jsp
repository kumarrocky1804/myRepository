<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link type = "text/css" rel="stylesheet"
		href = "<c:url value="/resources/css/style.css" />"/>
<link type = "text/css" rel="stylesheet"
		href = "<c:url value="/resources/css/add-customer-style.css" />"/>
		
<title>List of Customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager </h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<input type="button" value="Add Customer" 
		onclick="window.location.href='addCustomerForm'; return false;"
		class="add-button"/>
		
		<!-- ADDING SEARCH Functionality -->
		<form:form action="search" method="GET">
			Search Customer: <input type="text" name="searchName"/>
			<input type="submit" value="Search" class="add-button"/>
		</form:form>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>EMAIL</th>
					<th>ACTION</th>
				</tr>
				
				<!--  using JSTL tags with attribute name -->
				<c:forEach var="customer" items="${customers}">
					<!-- create variable with update link as value -->
					<c:url var="updateLink" value="/customer/updateCustomerForm">
						<c:param name="customerId" value="${customer.id}"></c:param>					
					</c:url>
					
					<!-- create variable with delete link as value -->
					<c:url var="deleteLink" value="/customer/deleteCustomer">
						<c:param name="customerId" value="${customer.id}"></c:param>					
					</c:url>
					
					<tr>
					<!-- These will call the getters method -->
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						
						<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure about this?'))) return false;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>