<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Locations</title>
</head>
<body>

	<div id="header">
		<h1>Choose from Available Locations</h1>
	</div>
	<div id="registeration">
		<form action="movie" method="get">
			<select name="location">
				<c:forEach var="location" items="${locations}">
					<option value="${location.pin}">${location.areaName}</option>
                                                                                                            
				</c:forEach>
			</select> <input type="submit" value="submit">
		</form>
	</div>

</body>
</html>