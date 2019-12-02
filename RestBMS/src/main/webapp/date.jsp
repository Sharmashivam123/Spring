<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Date</title>
</head>
<body>

	<div id="header">
		<h1>Select the date on you want to book</h1>
	</div>
	<div id="registeration">
		<form action="timings" method="get">
		<select name = "date" >
		<c:forEach var="date" items="${dates}">
					<option value="${date}">${date}</option>                                                                                 
				</c:forEach>
		</select>
			<input type="submit" value="submit">
		</form>
	</div>
</body>
</html>