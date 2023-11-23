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
<body>
	<c:choose>
		<c:when test="${! empty film}">

			<h2>Film found: ${film.title}</h2>
			<ul>
				<li>Film ID: ${film.filmId}</li>
				<li>Description: ${film.desc}</li>
				<li>Release Year: ${film.releaseYear}</li>
				<li>Film Length: ${film.length} minutes</li>
				<li>Rating: ${film.rating}</li>
				<li>Category: ${film.category}</li>
				<li>Language: ${film.lang}</li>
				<li>Features: <c:forEach items="${film.features}" var="feature">
				 		${feature}, 
					</c:forEach>
				</li>
				<li>Rental Duration: ${film.rentDur} days</li>
				<li>Rental Rate: $${film.rate}</li>
				<li>Replacement: Cost $${film.repCost}</li>
				<li>Actors:</li>
				<ul>
					<c:forEach items="${actors}" var="actor">
						<li>${actor.firstName}${actor.lastName}</li>
					</c:forEach>
				</ul>


			</ul>




		</c:when>
		<c:otherwise>
			<p>No Films found</p>
		</c:otherwise>
	</c:choose>
	<br />
	<a href="home.do">Return to home</a>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">	
	</script>
</body>
</html>