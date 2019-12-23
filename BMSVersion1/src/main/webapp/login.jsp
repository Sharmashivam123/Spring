<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BMS Login Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
input {
	display: block;
}
</style>
</head>
<body>
	<div class="container-fluid m-0 p-0">
		<div class="h1 text-uppercase text-center text-white bg-info p-3">Login
			Form</div>
		<form action="/login" method="post"
			class="col-md-6 mx-auto mt-5 bg-light p-0" id="form">
			<table style="with: 50%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
					<td><a href="/register"><input type="button"
							value="register" /></a></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>

