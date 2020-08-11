<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand -->
			<a class="navbar-brand" href="/">InfoDevelopers Quiz Program</a>

			<!-- Links -->
			<ul class="navbar-nav">
				<c:forEach var="department" items="${departments }">
				<li class="nav-item"><a class="nav-link" href="user/depart/${department.department_id}/levels">${department.department_name}</a></li>
				</c:forEach>
				<li class="nav-item"><a class="nav-link" href="registration">Register User</a></li>
				<li class="nav-item"><a class="nav-link" href="admin/adminPage">Go to Admin Page</a></li>
			</ul>
		</nav>
	</div>
	<br>

	<div class="container">
		<h3>Welcome to Info Developer</h3>
		<p>To Play the quiz select department and level from above navbar.</p>
	</div>

</body>
</html>