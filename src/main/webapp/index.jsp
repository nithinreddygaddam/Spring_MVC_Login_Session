<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Mvc Login Demo</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="content">
			<fieldset>
			<legend>Navigation menu</legend>
 
			<!-- Here the href's value will be used to decide the method from
				 controller to be executed on click of this link -->
			<a href="toLogin.obj" style="margin:50;">Login</a>
			<p>
			<a href="toSignUp.obj" style="margin:50;">Sign up</a>
			</fieldset>
		</div>
	</body>
</html>