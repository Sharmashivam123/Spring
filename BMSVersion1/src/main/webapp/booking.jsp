<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Bms</title>
<script>
window.location.replace('/tickets');
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (!storage.getItem('path'))
			window.location.replace('index.jsp');
		var path = JSON.parse(storage.getItem('path'));
		if (!path.includes('user.jsp'))
			window.location.replace(path[path.length - 1]);
		else {
			path.push('booking.jsp');
			storage.setItem('path', JSON.stringify(path));
		}

	}
</script>
<style>
input[type=submit] {
	width: 120px;
	background-color: tomato;
	color: white;
	height: 40px;
	padding: 1%;
}
</style>

</head>
<body>
	<form action="/tickets" method="get">
		<input type="submit" value="Ticket Details">
	</form>
</body>
</html>