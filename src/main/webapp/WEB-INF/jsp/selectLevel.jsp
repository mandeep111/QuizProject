<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@include file="/WEB-INF/template/bootstrap.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select level</title>
</head>
<body class="container">
<h2>Select Level:</h2>
<c:forEach var="level" items="${levels}">
<a href="${level.level_id }">${level.level_name }</a><br><br>
</c:forEach>
</body>
</html>