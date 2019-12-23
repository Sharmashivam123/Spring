<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Booking Details</title>
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (!storage.getItem('path'))
			window.location.replace('index.jsp');
		var path = JSON.parse(storage.getItem('path'));
		if (!path.includes('booking.jsp'))
			window.location.replace(path[path.length - 1]);
		else {
			path = [ 'index.jsp' ];
			storage.setItem('path', JSON.stringify(path));
		}

	}
</script>
<style>
.inner-block {
	width: 50%;
	margin: 0px auto;
	border: 2px solid black;
	text-align: center;
}
</style>

</head>
<body>
	<div class="block">
		<div class="inner-block">
			<h1>Booking Details of the ${tickets.fullName}</h1>
			<br> <br>
			<form action="" method="get">
				Email: ${tickets.fullName}<br> <br> Phone No :
				${tickets.phone}<br> <br> BookingId : ${tickets.bookingId}<br>
				<br> MovieName : ${tickets.movieName}<br> <br>
				ShowTiming : ${tickets.showTiming}<br> <br> ShowDate :
				${tickets.showDate}<br> <br> TotalTicket :
				${tickets.ticketBooked}<br> <br> Seats :
				${tickets.seatId}<br> <br> TotalCost inclusive of
				gst : ${tickets.totalCost}
			</form>
			<br> <br>
			<form action="index.jsp" method="get">
				<input type="submit" value="home">
			</form>


		</div>
	</div>

</body>
</html>