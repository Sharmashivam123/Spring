<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (storage.getItem('path'))
			storage.removeItem('path');
	}

	function set() {
		var path = [ 'index.jsp' ];
		storage.setItem('path', JSON.stringify(path));
	}

	function clearlogin() {
		storage.removeItem('login');
	}
</script>
</head>
<body>
	<a href="city"><button onclick="set()">Book Ticket</button></a>
	<form action="/logout" method="get">
		<br> <input type="submit" value="logout" onclick="clearlogin()">
	</form>
</body>
</html>