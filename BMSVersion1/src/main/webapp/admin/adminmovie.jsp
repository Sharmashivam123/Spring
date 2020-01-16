<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BMS Admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


<style>
#book {
	background-color: #76cdd8;
	height: 400px;
	position: relative;
	color: white;
	padding-top: 5%;
	text-align: center;
}

input[type=submit] {
	font-size: 1.2rem;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark w-100">
		<a class="navbar-brand" href="/confirm"><img alt="epam"
			src="logo.png" class="w-25" /></a>

		<form action="/logout" method="get" class="ml-auto">
			<button type="submit" value="logout" class="btn btn-danger my-auto"
				onclick="clearlogin()">Logout</button>
		</form>
	</nav>
	<div class="container-fluid text-center pt-5" id="book">
		<div class="display-4 d-block mt-4" id="header">Movies</div>
		<div id="registeration">
			<table name="movie" class="form-control mt-4">
				<tr>
					<th>movie Id</th>
					<th>movie Name</th>
					<th>update</th>
					<th></th>
					<th>delete</th>
				</tr>
				<c:forEach var="movie" items="${movieList}">
					<tr>
						<form action="/admin/movieupdt" method="get" class="w-50 mx-auto">
							<td><input type="text" name="movieId"
								value="${movie.movieId}" readonly></td>
							<td><input type="text" name="movieName"
								value="${movie.movieName}"></td>
							<td><c:forEach var="theatre" items="${movie.theatreList}">
									<input type="checkbox" name="theatreSelected"
										value="${theatre.theatreId}" />${theatre.theatreName}
						</c:forEach></td>
							<td><input type="submit" name="update" value="update"></td>
						</form>
						<form action="/admin/moviedlt" method="get" class="w-50 mx-auto">
							<input type="hidden" value="${movie.movieId}" name="movieId">
							<td><input type="submit" name="delete" value="delete"></td>
						</form>
				</c:forEach>
				<tr>
					<form action="/admin/movieadd" method="get" class="w-50 mx-auto">
						<td>Enter movieName:</td>
						<td><input type="text" name="movieName" value="" required></td>
						<td><c:forEach var="theatre" items="${theatreList}">
								<input type="checkbox" name="theatreSelected"
									value="${theatre.theatreId}" />${theatre.theatreName}
						</c:forEach></td>
						<td><input type="submit" name="add" value="add"></td>
					</form>
				</tr>
			</table>
		</div>
	</div>

	<footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
		&copy;EPAM Systems </footer>
</body>
</html>