<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
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

</body>
</html>