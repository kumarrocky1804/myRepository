<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Spring library for spring form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Form</title>
</head>
<body>
	<!-- model attribute is the name of model attribute that is to be binded -->
	<form:form action="processForm" modelAttribute="student">
	<!-- when page is loaded spring calls the get methods for "path" -->
	<!-- when it is submitted, spring call set methods -->
		First name: <form:input path="firstName"/>
		<br><br>
		
		Last Name: <form:input path="lastName"/>
		<br><br>
		
		Country: 
		<!-- WITHOUT HASH-MAP
		<form:select path="country">
			<form:option value="India" label="India"></form:option>
			<form:option value="USA" label="USA"></form:option>
			<form:option value="Russia" label="Russia"></form:option>
			<form:option value="China" label="China"></form:option>
			<form:option value="South Africa" label="South Africa"></form:option>
		</form:select>
		-->
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br><br>
		
		Favorite Language :
		<!-- WITHOUT HASH-MAP
		<br>
		Java <form:radiobutton path="favouriteLang" value="java"/>
		C# <form:radiobutton path="favouriteLang" value="c#"/>
		JavaScript <form:radiobutton path="favouriteLang" value="javaScript"/>
		Python <form:radiobutton path="favouriteLang" value="python"/>-->
		<form:radiobuttons path="favouriteLang" items="${student.langOptions}"/>
		<br><br> 
		Operation Systems Used:
		<br>
		<form:checkboxes items="${student.OSOptions}" path="OS"/>
		<br><br>
		
		<input type="submit" value="Register">
	</form:form>
</body>
</html>