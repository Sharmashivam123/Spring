<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="Registration.css">
<meta charset="ISO-8859-1">
<title>Available Shows</title>
</head>
<body>

	<div id="header">
		<h1>Select the show timing on you want to book</h1>
	</div>
	<div id="registeration">
		<form action="SeatRange" method="get">
			<select name="showTime">
				<c:forEach var="time" items="${shows}">
					<option value="${time.key}">${time.value}</option>                                                                                   
				</c:forEach>
			</select> 
			  
			<input type="submit" value="submit">
		</form>
	</div>

</body>
</html>