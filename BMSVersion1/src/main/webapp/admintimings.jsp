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
		<div class="display-4 d-block mt-4" id="header">Showtimings</div>
		<div id="registeration">
			<table name="theatre" class="form-control mt-4">
				<tr>
					<th>Timing Id</th>
					<th>Show 1</th>
					<th>Show 2</th>
					<th>Show 3</th>
					<th>Show 4</th>
					<th>update</th>
					<th>delete</th>
				</tr>
				<c:forEach var="timing" items="${showsList}">
					<tr>
						<form action="/admintimingupdt" method="get" class="w-50 mx-auto">
							<td><input type="text" name="timingId"
								value="${timing.timingId}"></td>
							<td><input type="text" name="show1"
								value="${timing.show1}"></td>
							<td><input type="text" name="show2"
								value="${timing.show2}"></td>
							<td><input type="text" name="show3"
								value="${timing.show3}"></td>
							<td><input type="text" name="show4"
								value="${timing.show4}"></td>
							<td><input type="submit" name="update" value="update"></td>

						</form>
						<form action="/admintimingdlt" method="get" class="w-50 mx-auto">
							<input type="hidden" value="${timing.timingId}" name=timingId>
							<td><input type="submit" name="delete" value="delete"></td>
						</form>
					</tr>
				</c:forEach>
				<tr>
					<form action="/admintimingadd" method="get" class="w-50 mx-auto">
						<td><input type="text" name="timingId" value="" required></td>
						<td><input type="text" name="show1"></td>
						<td><input type="text" name="show2"></td>
						<td><input type="text" name="show3"></td>
						<td><input type="text" name="show4"></td>
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