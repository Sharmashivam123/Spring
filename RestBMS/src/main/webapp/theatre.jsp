<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Theatres</title>
</head>
<body>

	<div id="header">
		<h1>Choose from Available Theatres Showing these movie</h1>
	</div>
	<div id="registeration">
		<form action="date" method="get">
			<select name="theatre">
				<c:forEach var="theatre" items="${theatres}">
					<option value="${theatre.theatreId}">${theatre.theatreName}</option>                                                                                
				</c:forEach>
			</select> <input type="submit" value="submit">
		</form>
	</div>

</body>
</html>