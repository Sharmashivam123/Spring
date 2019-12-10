<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>City Available</title>
<script>
var storage = window.sessionStorage;
window.onload = check();
function check()
{
	if(!storage.getItem('path'))
		window.location.replace('index.jsp');
var path = JSON.parse(storage.getItem('path'));
if(!path.includes('index.jsp'))
	window.location.replace(path[path.length-1]);
else
	{
	path.push('city.jsp');
	storage.setItem('path',JSON.stringify(path));
	}
	
}
</script>
</head>

<body>

	<div id="header">
		<h1>Choose from Available cities</h1>
	</div>
	<div id="registeration">
		<form action="location" method="get">
			<select name="city">
				<c:forEach var="city" items="${cityList}">
					<option value="${city.cityId}">${city.cityName}</option>
                                                                                                            
				</c:forEach>
			</select> <input type="submit" value="submit">
		</form>
	</div>

</body>
</html>