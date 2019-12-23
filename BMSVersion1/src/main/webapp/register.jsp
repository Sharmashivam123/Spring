<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<style>
input {
	display: block;
}

#pass-error {
	background-color: rgb(220, 53, 69, 0.2);
	color: rgb(220, 53, 69);
	font-size: 1rem;
	display: block;
}

input[type=submit] {
	display: none;
}
</style>

</head>
<body>
	<form action="userregister" method="get"
		class="col-md-6 mx-auto mt-5 bg-light p-0" id="form">
		<div class="container-fluid m-0 p-0">
			<div class="h1 text-uppercase text-center text-white bg-info p-3">Register</div>
		</div>
		<div class="p-5">
			<label for="user" class="mt-3">Email:</label> <input type="email"
				name="user" class="form-control" required /> <label
				for="phone class="mt-3">Phone:</label> <input type="text"
				name="phone" pattern="[0-9]{10}" class="form-control" required /> <label
				for="pwd" class="mt-3">Password:</label> <input type="password"
				name="pwd" class="form-control" id="pass"
				pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%]).{6,20}"
				required /> <label for="cpass" class="mt-3">Confirm
				Password:</label> <input type="password" name="cpass" class="form-control"
				id="cpass"> <small id="pass-error"></small>

			<button class="btn btn-danger mt-3" value="register" id="submit-btn">Register</button>

			<input type="submit" id="hid-submit-btn">
		</div>
	</form>
	<script>
		document.getElementById('submit-btn').addEventListener('click', () => {
			let pass = document.getElementById('pass').value;
			let cpass = document.getElementById('cpass').value;

			let error = document.getElementById('pass-error');
			
			if (pass === cpass) {
				document.getElementById('hid-submit-btn').click();
			} else {
				error.innerText = 'Password Should Match with Confirm Password!';
			}
			
		})
		
		
	</script>
</body>
</html>