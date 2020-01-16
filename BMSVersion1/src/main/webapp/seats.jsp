<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Available Seats</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%--<script>
var storage = window.sessionStorage;
window.onload = check();
function check()
{
	let checkboxes = document.querySelectorAll('input[type=checkbox]');
	for (const checkbox of checkboxes) {
		checkbox.checked = false;
	}
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
</script> --%>
<style>
#book {
	background-color: #76cdd8;
	height: 800px;
	position: relative;
	color: white;
	padding-top: 5%;
	text-align: center;
}

#tableheader {
	display: none;
}

input[type=submit] {
	font-size: 1.2rem;
}

.check {
	display: flex;
	wrap-flex: wrap;
	margin-left: -80px
}

input[type=checkbox] {
	width: 100px;
}

#error-msg {
	display: none;
	background-color: rgb(255, 0, 0, 0.1);
	color: rgb(255, 0, 0);
	padding: 2%;
	font-size: 1rem;
}

.myClass {
	text-align: center;
}

*::after, *::before {
	display: none !important;
}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark w-100">
		<a class="navbar-brand" href="#"><img alt="epam" src="logo.png"
			class="w-25" /></a>
		<form action="/logout" method="get" class="ml-auto">
			<button type="submit" value="logout" class="btn btn-danger my-auto"
				onclick="clearlogin()">Logout</button>
		</form>
	</nav>

	<div class="container-fluid text-center pt-5" id="book">
		<div class="display-4 d-block mt-4" id="header">Select the seats</div>
		<small id="error-msg">Maximum 6 seats can be selected</small>
		<div>
			<form action="confirmation" method="get" class="w-50 mx-auto">
				<h2 class="text-center bg-white text-dark d-block mx-auto mt-5 p-2">Screen
					here</h2>
				<br> <br>
				<div class="check text-justify d-flex align-content-center  py-2">
					<table>
						<caption></caption>
						<th id="tableheader"></th>
						<tr>
							<td class="myClass p-3"><span class="h5">Silver </span></td>
						</tr>
					</table>
					<c:forEach var="silver" items="${silverSeats}">
						<c:if test="${not silver.value}">
							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox"
										value="${silver.key.seatId} ${silver.key.cost}"> <label
										class="custom-control-label text-white" for="customCheck1">${silver.key.seatId}</label>
										<div class="text-white">${silver.key.cost}</div></td>
								</tr>
							</table>

						</c:if>
						<c:if test="${silver.value}">

							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox mt-1"
										value="${silver.key.seatId} ${silver.key.cost}" disabled>
										<label class="custom-control-label text-white"
										for="customCheck1">${silver.key.seatId}</label>
										<div class="text-white">${silver.key.cost}</div></td>
								</tr>
							</table>

						</c:if>
					</c:forEach>
				</div>
				<div class="check text-justify d-flex align-content-center  py-2">
					<table>
						<caption></caption>
						<th id="tableheader"></th>
						<tr>
							<td class="myClass  p-3"><span class="h5">Gold </span></td>
						</tr>
					</table>
					<c:forEach var="gold" items="${goldSeats}">
						<c:if test="${not gold.value}">
							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox"
										value="${gold.key.seatId} ${gold.key.cost}"> <label
										class="custom-control-label text-white" for="customCheck1">${gold.key.seatId}</label>
										<div class="text-white">${gold.key.cost}</div></td>
								</tr>
							</table>

						</c:if>
						<c:if test="${gold.value}">

							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox mt-1"
										value="${gold.key.seatId} ${gold.key.cost}" disabled>
										<label class="custom-control-label text-white"
										for="customCheck1">${gold.key.seatId}</label>
										<div class="text-white">${gold.key.cost}</div></td>
								</tr>
								</th>
							</table>

						</c:if>
					</c:forEach>
				</div>
				<div class="check text-justify d-flex align-content-center py-2">

					<table>
						<caption></caption>
						<th id="tableheader"></th>
						<tr>
							<td class="myClass  p-3"><span class="h5">Platinum </span></td>
						</tr>
					</table>
					<c:forEach var="platinum" items="${platinumSeats}">
						<c:if test="${not platinum.value}">
							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox"
										value="${platinum.key.seatId} ${platinum.key.cost}"
										id="customCheck1"> <label
										class="custom-control-label text-white" for="customCheck1">${platinum.key.seatId}</label>
										<div class="text-white">${platinum.key.cost}</div></td>
								</tr>
							</table>

						</c:if>
						<c:if test="${platinum.value}">

							<table>
								<caption></caption>
								<th id="tableheader"></th>
								<tr>
									<td class="myClass"><input type="checkbox" name="seats"
										class="custom-control custom-checkbox mt-1"
										value="${platinum.key.seatId} ${platinum.key.cost}"
										id="customCheck1" disabled> <label
										class="custom-control-label text-white" for="customCheck1">${platinum.key.seatId}</label>
										<div class="text-white">${platinum.key.cost}</div></td>
								</tr>
							</table>

						</c:if>
					</c:forEach>
				</div>
				<input type="submit" class="btn btn-secondary w-50 mt-5"
					value="Next" id="submit-btn" disabled>
			</form>
		</div>

	</div>

	<footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
		&copy;EPAM Systems </footer>

	<script type="text/javascript">
	window.onload = () => { 
		let totalSelected = 0;
		let checkboxes = document.querySelectorAll('input[type=checkbox]');
		for (const checkbox of checkboxes) {
			checkbox.checked = false;
			checkbox.addEventListener ('change', () => {
				if (checkbox.checked) {
					totalSelected +=1;
				} else {
					totalSelected -= 1;
					console.log(totalSelected);
				}
				if (totalSelected > 6) {
					document.querySelector('#error-msg').style.display = 'block';
				} else {
					document.querySelector('#error-msg').style.display = 'none';
				}
				if (totalSelected > 0 && totalSelected <= 6) {
					document.querySelector('#submit-btn').disabled = false;
				} else {
					document.querySelector('#submit-btn').disabled = true;
				}
			})
		}
		
	}
		
	</script>
</body>
</html>

