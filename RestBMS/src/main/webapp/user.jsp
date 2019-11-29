<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
</head>
<body>

	<div id="header">
		<h1>Enter User Details to proceed</h1><br><br>
	</div>
	<div id="registeration">
		<form action="booking" method="post">
			userName:   <input type="text" name = "userName" placeholder = "Enter your name" pattern="^[a-zA-Z\s]+$" required><br><br>
			Phone   :   <input type="text" name = "phone" placeholder = "Enter your phone" maxlength="10" pattern = "^[0-9]+$" required><br><br>
			<input type="submit" value="submit">
		</form>
	</div>

</body>
</html>