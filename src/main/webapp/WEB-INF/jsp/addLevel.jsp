<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/template/bootstrap.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Level</title>
</head>
<body class="container"><br>
	<form action="addLevel" method="post">
		Select Department: <select name="department">
			<c:forEach var="department" items="${departments }">
				<option value="${department.department_id }">${department.department_name}</option>
			</c:forEach>
		</select> <br>
		<br>

		Level Name: <input type="text" name="level_name" required><br> <br>
		Pass Mark : <input type="number" name="pass_mark" required><br> <br>
		<input type="submit" value="Add Level">


	</form>


</body>
</html>