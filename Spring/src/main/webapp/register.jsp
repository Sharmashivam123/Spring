<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registeration</title>
</head>
<body>
	<form action="userregister" method="get">
		email: <input type="email" name="user" required /><br> password:
		<input type="password" name="pwd"
			pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{6,20}"
			required /><br> phone: <input type="text" name="phone"
			pattern="[0-9]{10}" required /><br> <input type="submit"
			value="register" />
	</form>
</body>
</html>