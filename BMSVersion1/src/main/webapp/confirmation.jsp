<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (storage.getItem('path'))
			storage.removeItem('path');
	}

	function set() {
		var path = [ 'confirmation.jsp' ];
		storage.setItem('path', JSON.stringify(path));
	}

	function clearlogin() {
		storage.removeItem('login');
	}
</script>
</head>
<body>
	<c:if test="${status < 1}">${msg}</c:if>
	<c:if test="${status > 0}">${msg}</c:if>
	login to proceed
	<br>
	<a href="/login"><input type="button" value="login"></a>
</body>
</html>