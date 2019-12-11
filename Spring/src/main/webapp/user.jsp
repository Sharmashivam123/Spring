<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (!storage.getItem('path'))
			window.location.replace('index.jsp');
		var path = JSON.parse(storage.getItem('path'));
		if (!path.includes('seats.jsp'))
			window.location.replace(path[path.length - 1]);
		else {
			path.push('user.jsp');
			storage.setItem('path', JSON.stringify(path));
		}

	}
</script>
<style>
	#book {
	  background-color: #76cdd8;
	  height: 600px;
	  position: relative;
	  color: white;
	  padding-top: 5%;
	  text-align: center;
	}
	
	#book button {
	  margin-top: 5%;
	  height: 50px;
	  background-color: white;
	  font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
	  font-size: 1.8rem;
	  border-radius: 15px;
	}

</style>
</head>
<body>
	 <nav class="navbar navbar-expand-lg navbar-dark bg-dark w-100">
      <a class="navbar-brand" href="#"><img src="logo.png" class="w-25"/></a>
      <form action="/logout" method="get" class="ml-auto">
        <button type="submit" value="logout" class="btn btn-danger" onclick="clearlogin()">Logout</button>
      </form>
    </nav>

    <div class="container-fluid" id="book">
      <span class="display-2 d-block mb-4">Enter User Data</span>
      
   
	<div id="registeration" class=" container mt-4">
		<form action="booking" method="get" id="userForm" class="mt-2 mx-auto w-50">
		 <input type="text" name="userName"  class="form-control"
				placeholder="Enter your name" pattern="^[a-zA-Z\s]+$" min="6"
				max="20" required>
				<br> <br>
		<input type="tel" name="phone" placeholder="Enter your phone" class="form-control"
				pattern="[0-9]{10}" required>
				<br> <br>
				<input type="submit" class="btn btn-secondary w-25" value="Next">
		</form>
	</div>
      
    </div>
    
    <footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
    	&copy;EPAM Systems
    </footer>


</body>
</html>