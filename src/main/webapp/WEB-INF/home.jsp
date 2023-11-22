<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Site</title>
</head>
<body>

<h1>Welcome to Cole's Film Site</h1>

<form action="GetFilmData.do" method="GET">
		Get a Film Using it's ID
		<input type="text" name="id" size="4"/> 
		<input type="submit" value="Get Film Data" />
	</form>

<form action="GetFilmData.do" method="GET">
    Get a Film Using a Keyword
    <input type="text" name="keyword"/> 
    <input type="submit" value="Get Film Data" />
  </form>
  
</body>
</html>