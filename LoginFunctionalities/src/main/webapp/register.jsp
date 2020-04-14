<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Registeration</title>
</head>
<body>
	<div class="container">
		<div class="row">Enter the Registeration Details:</div>
		<div class="col-xs-12">
			<form:form method="post" modelAttribute="dto">
				<div class="row">
					<label for="username">User-Name: </label>
					<form:input path="username" name="user-name" />
					<form:errors path="username" />
				</div>
				<div class="row">
					<label for="password">Password: </label>
					<form:input path="password" name="password" />
					<form:errors path="password" />
				</div>
				<div class="row">
					<label for="confirmPassword">Confirm Password: </label>
					<form:input path="confirmPassword" name="confirm" />
					<form:errors path="confirmPassword" />
				</div>
				<div class="row">
					<label for="phone">Phone: </label>
					<form:input path="phone" name="phone" />
					<form:errors path="phone" />
				</div>
				<div class="row">
					<label for="role">Role: </label>
					<form:input path="role" name="role" />
					<form:errors path="role" />
				</div>
				<input type="submit" value="register" />
			</form:form>
		</div>
	</div>
</body>
</html>