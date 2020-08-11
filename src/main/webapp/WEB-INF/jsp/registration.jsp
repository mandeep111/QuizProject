<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="/WEB-INF/template/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body class="container">
<form action="addUser" method="post">
	Enter Username: <input type="text" name="username" required><br><br>
	Enter Password: <input type="password" name="password" required><br><br>
	<input type="submit" value="Register">
</form>
</body>
</html>