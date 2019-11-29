<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
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
		<form action="confirmation" method="get">
			<h2 >Screen here</h2><br><br>
			<div class="check">
				<h3 >Silver</h3><br><br>
				<c:forEach var="silver" items="${silverSeats}">
				<input type="checkbox"  name = "silverSeatAndCost" value="${silver.seatId} ${silver.cost}" >${silver.seatId}
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="check">
				<h3 style="text-align: center;">Gold</h3><br><br>
				<c:forEach var="gold" items="${goldSeats}">
				<input type="checkbox"  name = "goldSeatAndCost" value="${gold.seatId} ${gold.cost}" >${gold.seatId}
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="check">
			 <h3 style="text-align: center;">Platinum</h3><br><br>
				<c:forEach var="platinum" items="${platinumSeats}">
				<input type="checkbox"  name = "platinumSeatAndCost" value="${platinum.seatId} ${platinum.cost}" >${platinum.seatId}
				</c:forEach>
			</div>
			
			<input type="submit" value="submit">
		</form>
	</div>

</body>
</html>