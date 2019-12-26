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
		<a class="navbar-brand" href="#"><img alt="epam" src="logo.png"
			class="w-25" /></a>
		<form action="/logout" method="get" class="ml-auto">
			<button type="submit" value="logout" class="btn btn-danger my-auto"
				onclick="clearlogin()">Logout</button>
		</form>
	</nav>
	<div class="container-fluid text-center pt-5" id="book">
		<div class="display-4 d-block mt-4" id="header">Theatres</div>
		<div id="registeration">
			<table name="theatre" class="form-control mt-4">
				<tr>
					<th>Theatre Id</th>
					<th>Theatre Name</th>
					<th>update</th>
					<th>delete</th>
				</tr>
				<c:forEach var="theatre" items="${theatreList}">
					<tr>
						<form action="admintheatreupdt" method="get" class="w-50 mx-auto">
							<td><input type="text" name="theatreId"
								value="${theatre.theatreId}"></td>
							<td><input type="text" name="theatreName"
								value="${theatre.theatreName}"></td>
							<td><input type="submit" name="update" value="update"></td>
						</form>
						<form action="admintheatredlt" method="get" class="w-50 mx-auto">
							<input type="hidden" value="${theatre.theatreId}" name="theatreId">
							<td><input type="submit" name="delete" value="delete"></td>
						</form>
					</tr>
				</c:forEach>
				<tr>
					<form action="admintheatreadd" method="get" class="w-50 mx-auto">
						<td><input type="text" name="theatreId" value="" required></td>
						<td><input type="text" name="theatreName" value="" required></td>
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