<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Seats</title>
<script>
var storage = window.sessionStorage;
window.onload = check();
function check()
{
	if(!storage.getItem('path'))
		window.location.replace('index.jsp');
var path = JSON.parse(storage.getItem('path'));
if(!path.includes('shows.jsp'))
	window.location.replace(path[path.length-1]);
else
	{
	path.push('seats.jsp');
	storage.setItem('path',JSON.stringify(path));
	}
	
}
</script>
<style>
.check {
	display: flex;
	wrap-flex: wrap;
}

#error-msg {
	display: none;
	background-color: rgb(255, 0, 0, 0.1);
	color: rgb(255, 0, 0);
	padding: 2%;
	font-size: 1rem;
}

#submit-btn {
	display: none;
}
</style>

</head>
<body>

	<div id="header">
		<h1>Select the seats</h1>
	</div>
	<br>
	<br>
	<small id="error-msg">Maximum 6 seats can be selected</small>
	<div id="registeration">
		<form action="confirmation" method="get">
			<h2>Screen here</h2>
			<br> <br>
			<div class="check">
				<h3>Silver</h3>
				<br> <br>
				<c:forEach var="silver" items="${silverSeats}">
					<input type="checkbox" name="seats"
						value="${silver.seatId} ${silver.cost}">${silver.seatId}
				</c:forEach>
			</div>
			<br> <br>

			<div class="check">
				<h3 style="text-align: center;">Gold</h3>
				<br> <br>
				<c:forEach var="gold" items="${goldSeats}">
					<input type="checkbox" name="seats"
						value="${gold.seatId} ${gold.cost}">${gold.seatId}
				</c:forEach>
			</div>
			<br> <br>

			<div class="check">
				<h3 style="text-align: center;">Platinum</h3>
				<br> <br>
				<c:forEach var="platinum" items="${platinumSeats}">
					<input type="checkbox" name="seats"
						value="${platinum.seatId} ${platinum.cost}">${platinum.seatId}
				</c:forEach>
			</div>

			<input type="submit" value="submit" id="submit-btn">
		</form>
	</div>
	<script type="text/javascript">
		let totalSelected = 0;
		let checkboxes = document.querySelectorAll('input[type=checkbox]');
		for (const checkbox of checkboxes) {
			checkbox.addEventListener ('change', () => {
				if (checkbox.checked) {
					totalSelected +=1;
				} else {
					totalSelected -= 1;
				}
				if (totalSelected > 6) {
					document.querySelector('#error-msg').style.display = 'block';
				} else {
					document.querySelector('#error-msg').style.display = 'none';
				}
				if (totalSelected > 0 && totalSelected <= 6) {
					document.querySelector('#submit-btn').style.display = 'block';
				} else {
					document.querySelector('#submit-btn').style.display = 'none';
				}
			})
		}
		
	</script>
</body>
</html>