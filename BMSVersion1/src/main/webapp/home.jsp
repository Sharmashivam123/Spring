<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
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

#book button {
	margin-top: 5%;
	height: 50px;
	background-color: white;
	font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
	font-size: 1.8rem;
	border-radius: 15px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark w-100">
		<a class="navbar-brand" href="/confirm"><img alt="epam"
			src="logo.png" class="w-25" /></a>
		<form action="/logout" method="get" class="ml-auto">
			<button type="submit" value="logout" class="btn btn-danger"
				onclick="clearlogin()">Logout</button>
		</form>
	</nav>
	<nav class="navbar navbar-expand-lg navbar-dark  w-100">
		<form action="/admin/city" method="get" class="ml-auto">
			<button type="submit" value="city" class="btn btn-danger">city</button>
		</form>
		<form action="/admin/location" method="get" class="ml-auto">
			<button type="submit" value="location" class="btn btn-danger">location</button>
		</form>
		<form action="/admin/movie" method="get" class="ml-auto">
			<button type="submit" value="movie" class="btn btn-danger">movie</button>
		</form>
		<form action="/admin/theatre" method="get" class="ml-auto">
			<button type="submit" value="theatre" class="btn btn-danger">theatre</button>
		</form>
		<form action="/admin/timings" method="get" class="ml-auto">
			<button type="submit" value="timings" class="btn btn-danger">timings</button>
		</form>
		<form action="/admin/screen" method="get" class="ml-auto">
			<button type="submit" value="screen" class="btn btn-danger">screen</button>
		</form>
	</nav>

	<div class="container-fluid" id="book">
		<span class="display-2 d-block">Welcome !</span>
	</div>

	<footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
		&copy;EPAM Systems </footer>
</body>
</html>

</html>


