
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/template/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Questions</title>
</head>
<body>

	<div class="container">
		<div class="col-md-12">
			<form action="/admin/addQuestion" method="post">
				Selected Department: <select name="department">

					<option value="${departments.department_id }">${departments.department_name}</option>

				</select> <br> <br> Select Level: <select name="level">
					<c:forEach var="level" items="${levels}">
						<option value="${level.level_id }">${level.level_name}</option>
					</c:forEach>
				</select><br> <br> Question: <input type="text" name="question" required>
				<br> <br> Option1: <input type="text" name="option1" required>
				<br> <br> Option2: <input type="text" name="option2" required>
				<br> <br> Option3: <input type="text" name="option3" required>
				<br> <br> Option4: <input type="text" name="option4" required>
				<br> <br> Correct Option: <input type="number" min="1" max="4" value="1" required
					name="correct_option"> <br> <br> 
					Weight:<input required
					type="number" name="weight" min="1" value="1" max="20"><br> <br> <input
					type="submit" value="Add Question">
			</form>
		</div>
	</div>
</body>
</html>