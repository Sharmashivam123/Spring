<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Date</title>
<script>
var storage = window.sessionStorage;
window.onload = check();
function check()
{
	if(!storage.getItem('path'))
		window.location.replace('index.jsp');
var path = JSON.parse(storage.getItem('path'));
if(!path.includes('theatre.jsp'))
	window.location.replace(path[path.length-1]);
else
	{
	path.push('date.jsp');
	storage.setItem('path',JSON.stringify(path));
	}
	
}
</script>
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