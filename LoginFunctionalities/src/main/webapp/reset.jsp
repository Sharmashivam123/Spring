<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<div class="col-xs-12">
		<div class="row">"${error}"</div>

		<form:form method="post" action="/reset" modelAttribute="dto">
			<div class="row">
				<form:label path="password">New Password: </form:label>
				<form:password path="password" />
				<form:errors path="password"></form:errors>
			</div>
			<div class="row">
				<form:label path="confirmPassword">Confirm Password: </form:label>
				<form:password path="confirmPassword" />
				<form:errors path="confirmPassword" />
			</div>
			<form:hidden path="token" value="${token.token}"></form:hidden>
			<form:errors path="token" />
			<div class="row">
				<input type="submit" value="change" />
			</div>
		</form:form>

	</div>
</body>
</html>