<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/template/bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Play Quiz</title>
<script>
	function startTimer(duration, display) {
		var timer = duration, minutes, seconds;
		setInterval(function() {
			minutes = parseInt(timer / 60, 10);
			seconds = parseInt(timer % 60, 10);

			minutes = minutes < 10 ? "0" + minutes : minutes;
			seconds = seconds < 10 ? "0" + seconds : seconds;

			display.textContent = minutes + ":" + seconds;

			if (--timer < 0) {
				timer = duration;
			}
		}, 1000);

	}

	window.onload = function() {

		var fiveMinutes = 60 * 1, display = document.querySelector('#time');
		startTimer(fiveMinutes, display);

		setTimeout(function() {
			alert("Time Over, Restart Playing?") ? "" : location.reload();
		}, 1000 * 60);

	};
</script>
</head>


<body>
	<div class="container">
		<h2 id="time">01:00</h2>

		<div class="row">
			<h1 class="col-md-8">Department: ${department.department_name}</h1>

			<a class="col-md-4" href="/j_spring_security_logout">Logout User</a>
		</div>
		<div class="col-md-12">
			<h5>Difficulty Level: ${level.level_name}</h5>

		<form action="${pageContext.request.contextPath}/showResult/${department.department_id}/${level.level_id}" method="post">
			<c:forEach var="question" items="${questions }">
				<div class="row">
					<div class="col-md-12">
						<h5>Q. ${question.question}</h5>
						<h5>${question.weight}marks</h5>
						<p>
							Select an option:							
							<select name="user_answer">
							<option value="1">${question.option1 }</option>
							<option value="2">${question.option2 }</option>
							<option value="3">${question.option3 }</option>
							<option value="4">${question.option4 }</option>
							</select>
						</p>
					</div>
					
					
				</div>
			</c:forEach>
			<input type="submit" value="Answer">
		</form>
		</div>

	</div>
</body>
</html>

