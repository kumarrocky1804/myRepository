<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--  Spring Form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--  JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>LOGIN PAGE</title>
	
	<style type="text/css">
		.failed{
			color:red;
		}
	</style>
</head>
<body>
	<h3>CUSTOM LOGIN PAGE :</h3>
	<!-- name same as set up in securityconfig -->
	<form:form action="${pageContext.request.contextPath}/authUser"
		method="POST">

		<!-- IF there is login error, check for error param -->
		<c:if test="${param.error != null}">
			<i class="failed">INVALID CREDENTIALS</i>
		</c:if>

		<!-- names of params should necessarily be usernaem and password -->
		<p>
			User Name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>

		<input type="submit" value="LOGIN" />
	</form:form>
</body>
</html>