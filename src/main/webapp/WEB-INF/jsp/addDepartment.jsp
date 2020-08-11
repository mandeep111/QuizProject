<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/template/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Department</title>
</head>
<body class="container">
	<form action="addDepartment" method="post">
		Department Name: <input type="text" name="department_name" required><br>
		<br> <input type="submit" value="Add Department">
	</form>
	<br>
	<h2>List of Departments</h2>
	<p>Add questions to any of the topic</p>
	<c:forEach var="department" items="${departments }">
		<div class="row">
			<div class="col-md-6">
				<a href="/admin/addQuestion/${department.department_id }">${department.department_name}</a>

			</div>
			<div class="col-md-2">
				<button type="button"
					onclick="deleteDepartment(${department.department_id})"
					class="btn btn-danger">Delete</button>
			</div>
		</div>
		<br>
	</c:forEach>
</body>

<script type="text/javascript">
            function deleteDepartment(department_id) {
                let message = confirm("Delete this department?");
                if (message == true) {
                    window.location = "${pageContext.request.contextPath}/admin/deleteDepartment/"+department_id;
                }
            }
        </script>
</html>