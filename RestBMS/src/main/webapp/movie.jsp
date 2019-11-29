<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Movies</title>
</head>
<body>

	<div id="header">
		<h1>Choose from Available Movies</h1>
	</div>
	<div id="registeration">
		<form action="theatre" method="get">
			<select name="movie">
				<c:forEach var="movie" items="${movies}">
					<option value="${movie.movieId},${movie.movieName}">${movie.movieName}</option>
				</c:forEach>
			</select> <input type="submit" value="submit">
		</form>
	</div>

</body>
</html>