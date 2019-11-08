<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="Registration.css">
<meta charset="ISO-8859-1">
<title>Available Seats</title>
<style>
	.check {
		display: flex;
		wrap-flex: wrap;
	}

</style>
</head>
<body>

	<div id="header">
		<h1>Select the seats</h1>
	</div><br><br>
	<div id="registeration">
		<form action="ProcessBooking" method="get">
			<h2 >Screen here</h2><br><br>
			<div class="check">
				<h3 >Silver</h3><br><br>
				<c:forEach var="silver" items="${silverSeats}">
				<input type="checkbox"  name = "A" value="${silver.seatId} ${silver.cost}" >
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="check">
				<h3 style="text-align: center;">Gold</h3><br><br>
				<c:forEach var="gold" items="${goldSeats}">
				<input type="checkbox"  name = "B" value="${gold.seatId} ${gold.cost}" >
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="check">
			 <h3 style="text-align: center;">Platinum</h3><br><br>
				<c:forEach var="platinum" items="${platinumSeats}">
				<input type="checkbox"  name = "C" value="${platinum.seatId} ${platinum.cost}" >
				</c:forEach>
			</div>
			
			<input type="submit" value="submit">
		</form>
	</div>

</body>
</html>