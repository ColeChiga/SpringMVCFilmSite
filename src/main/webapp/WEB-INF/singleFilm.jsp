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
			
				<h2>Film found: ${film.title}</h2>
			<ul>
				<li>Film ID: ${film.filmId}</li>
				<li>Description: ${film.desc}</li>
				<li>Release Year: ${film.releaseYear}</li>
				<li>Language: ${film.lang}</li>
				<li>rental Duration: ${film.rentDur}</li>
				<li>Rental Rate: $${film.rate}</li>
				<li>Film Length: ${film.length} minutes</li>
				<li>Replacement: Cost ${film.repCost}</li>
				<li>Rating: ${film.rate}</li>
				<li>Features: ${film.features}</li>
				
			</ul>
			
		</c:when>
		<c:otherwise>
			<p>No Films found</p>
		</c:otherwise>
	</c:choose>
	<br/>
	<a href="home.do">Return to home</a>

</body>
</html>