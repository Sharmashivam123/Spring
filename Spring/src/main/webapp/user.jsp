<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
<script>
var storage = window.sessionStorage;
window.onload = check();
function check()
{
	if(!storage.getItem('path'))
		window.location.replace('index.jsp');
var path = JSON.parse(storage.getItem('path'));
if(!path.includes('seats.jsp'))
	window.location.replace(path[path.length-1]);
else
	{
	path.push('user.jsp');
	storage.setItem('path',JSON.stringify(path));
	}
	
}
</script>
</head>
<body>

	<div id="header">
		<h1>Enter User Details to proceed</h1>
		<br> <br>
	</div>
	<div id="registeration">
		<form action="booking" method="get" id="userForm">
			Name: <input type="text" name="userName"
				placeholder="Enter your name" pattern="^[a-zA-Z\s]+$" min="6"
				max="20" required><br> <br> Phone : <input
				type="tel" name="phone" placeholder="Enter your phone"
				pattern="[0-9]{10}" required><br> <br> <input
				type="submit" value="submit">
		</form>
	</div>
	
</body>
</html>