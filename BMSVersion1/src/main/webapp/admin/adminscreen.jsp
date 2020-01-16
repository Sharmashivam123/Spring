<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>BMS Admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


<style>
#book {
	background-color: #76cdd8;
	height: 400px;
	position: relative;
	color: white;
	padding-top: 5%;
	text-align: center;
}

input[type=submit] {
	font-size: 1.2rem;
}

tr {
	width: 100%;
}

th {
	font-size: 1.25rem;
	color: black;
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
		<div class="display-4 d-block mt-4" id="header">Screen Here</div>
		<div id="registeration" class="table w-100 p-4">
			<table name="screen" class="bg-light mt-4 mx-auto"
				style="margin-bottom: 120px;">
				<tr>
					<th>Seat Id</th>
					<th>Tier</th>
					<th>Cost for a ticket</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="seat" items="${seats}">
					<tr>
						<form action="/admin/updtscreen" method="get" class="w-50 mx-auto">
							<td><input type="text" name="seatId" value="${seat.seatId}"
								class="form-control"></td>
							<td><input type="text" name="tier" value="${seat.tier}"
								class="form-control"></td>
							<td><input type="text" name="cost" value="${seat.cost}"
								class="form-control"></td>
							<td><input type="submit" name="update" value="Update"
								class="btn btn-info"></td>
						</form>
						<form action="/admin/dltscreen" method="get" class="w-50 mx-auto">
							<input type="hidden" value="${seat.seatId}" name="seatId"
								class="form-control">
							<td><input type="submit" name="delete" value="Delete"
								class="btn btn-danger"></td>
						</form>
					</tr>
				</c:forEach>
				<tr>
					<form action="/admin/addscreen" method="get" class="w-50 mx-auto">
						<td><input type="text" name="seatId" value=""
							class="form-control" required></td>
						<td><input type="text" name="tier" value=""
							class="form-control" required></td>
						<td><input type="text" name="cost" class="form-control"
							required></td>

						<td colspan="2"><input type="submit" name="add" value="Add"
							class="btn btn-primary w-100"></td>
					</form>
				</tr>
			</table>
		</div>
	</div>

	<footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
		&copy;EPAM Systems </footer>
</body>

</html>