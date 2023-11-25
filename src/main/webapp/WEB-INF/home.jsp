<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Site</title>
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

	<form class="form-control p-2 text-primary-emphasis btn-outline bg-primary border border-primary-subtle" action="GetFilmData.do"
		method="GET">
		Get a Film Using it's ID <input type="number" name="id" size="4"
			min="1"/> <input type="submit" value="Get Film Data" />
	</form>

	<form class="form-control p-2 text-primary-emphasis btn-outline bg-primary border border-primary-subtle" action="GetFilmData.do"
		method="GET">
		Get a Film Using a Keyword <input type="text" name="keyword" /> <input
			type="submit" value="Get Film Data" />
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>