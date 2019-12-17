<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMS</title>
</head>
<body>${error}
	<form action="/verify" method="get">
		OTP: <input type="text" name = "otp" pattern="[0-9]+">
		<input type="submit" value="submit otp">
	</form>
	
	<form action="/logout">
		<input type="submit" value="logout">
	</form>
</body>
</html>