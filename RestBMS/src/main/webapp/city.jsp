<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>City Available</title>
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