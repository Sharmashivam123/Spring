<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Shows</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (!storage.getItem('path'))
			window.location.replace('index.jsp');
		var path = JSON.parse(storage.getItem('path'));
		if (!path.includes('date.jsp'))
			window.location.replace(path[path.length - 1]);
		else {
			path.push('shows.jsp');
			storage.setItem('path', JSON.stringify(path));
		}

	}
</script>
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
		<a class="navbar-brand" href="#"><img src="logo.png" class="w-25" /></a>
		<form action="/logout" method="get" class="ml-auto">
			<button type="submit" value="logout" class="btn btn-danger my-auto"
				onclick="clearlogin()">Logout</button>
		</form>
	</nav>

	<div class="container-fluid text-center pt-5" id="book">
		<div class="display-4 d-block mt-4" id="header">Select the show
			timing on you want to book</div>
		<div id="registeration">
			<form action="seats" method="get" class="w-50 mx-auto">
				<select name="showTime" class="form-control mt-4">
					<c:forEach var="time" items="${shows}">
						<option value="${time}">${time}</option>
					</c:forEach>
				</select> <input type="submit" value="Next" class="btn btn-dark mt-5 w-50">
			</form>
		</div>

	</div>

	<footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
		&copy;EPAM Systems </footer>
</body>
</html>