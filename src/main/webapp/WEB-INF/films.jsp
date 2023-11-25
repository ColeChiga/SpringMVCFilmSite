<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body class="bg-secondary border border-primary-subtle">
	<div class="container-fluid name-plate row bg-primary">
		<h1 class="col text-center ">Welcome to Cole's Film Site</h1>
	</div>
	<div class="row container-fluid row bg-primary-subtle border border-primary">
	<div class="col-1"></div>
	<div class="col">
	<c:choose>
		<c:when test="${! empty film}">
		<h2>${film.size()} Films Found with the Keyword "${keyword}"</h2>
			<c:out value="${Search}" />
				<ol>
			<c:forEach items="${film}" var="film">
					<li><a href="GetFilmData.do?id=${film.filmId}">${film.title}</a>
				<ul>
					<li>${film.desc}</li>
				</ul>
			</c:forEach>
				</ol>
		</c:when>
		<c:otherwise>
			<p>No Films found</p>
		</c:otherwise>
	</c:choose>
	<br />
	<a href="home.do">Return to home</a>
</div></div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">	
	</script>
</body>
</html>