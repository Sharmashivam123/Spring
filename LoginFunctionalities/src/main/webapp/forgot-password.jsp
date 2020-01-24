<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<title>Login Functionalities</title>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<c:if test="${mailStatus == 'success'}">
		<label>You have successfully requested the password reset.</label>
	</c:if>
	<form:form action="/forgot" name="frm" method="post"
		modelAttribute="dto">
		<spring:message code="lbl.email" text="Enter the Email: "></spring:message>
		<form:input path="email" name="email" />
		<form:errors path="email" cssClass="error" />
		<label for="send">Send the link through mail</label>
		<input type="submit" name="send" />
	</form:form>
</body>
</html>