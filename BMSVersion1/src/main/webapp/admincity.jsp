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
		<div class="display-4 d-block mt-4" id="header">Cities</div>
		<div id="registeration">
			<table name="city" class="form-control mt-4">
				<tr>
					<th>City Id</th>
					<th>City Name</th>
					<th>update</th>
					<th>delete</th>
				</tr>
				<c:forEach var="city" items="${cityList}">
					<tr>
						<form action="/admincityupdt" method="get" class="w-50 mx-auto">
						<td><input type="text" name="cityId" value="${city.cityId}"></td>
						<td><input type="text" name="cityName"
							value="${city.cityName}"></td>
						<td><input type="submit" name="update" value="update"></td>
						</form>
						<form action="/admincitydlt" method="get" class="w-50 mx-auto">
							<input type="hidden" value="${city.cityId}" name="cityId">
							<td><input type="submit" name="delete" value="delete"></td>
						</form>
					</tr>
				</c:forEach>
				<tr>
					<form action="/admincityadd" method="get" class="w-50 mx-auto">
						<td><input type="text" name="cityName" value="" required></td>
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