<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Result page</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Person Result page</h1>
<p>Don't forget: ${thought}</p>
<p>Student's name is ${pers.firstName}. The age is ${pers.age}.
<br/>
<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>