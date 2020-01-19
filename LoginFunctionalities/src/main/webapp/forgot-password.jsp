<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Login Functionalities</title>
</head>
<body>
	<c:if test="${mailStatus == 'success'}">
		<label>You have successfully requested the password reset.</label>
	</c:if>
	"${errors}"
	<form:form action="/forgot" method="post" modelAttribute="forgot-password-dto">
		<label for="email">Enter the username: </label>
		<input type="text" name="email" required />
		<form:errors></form:errors>
		<label for="send">Send the link through mail</label>
		<input type="submit" name="send" />
	</form:form>
</body>
</html>