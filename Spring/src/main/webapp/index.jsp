<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script>
	var storage = window.sessionStorage;
	window.onload = check();
	function check() {
		if (storage.getItem('path'))
			storage.removeItem('path');
	}

	function set() {
		var path = [ 'index.jsp' ];
		storage.setItem('path', JSON.stringify(path));
	}

	function clearlogin() {
		storage.removeItem('login');
	}
</script>
<style>
	#book {
	  background-color: #76cdd8;
	  height: 400px;
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
      <span class="display-2 d-block">Welcome to Ticket Booking System!</span>
      <a href="city">
        <button onclick="set()" class="btn w-50 shadow">Start Booking</button> 
      	</a>
    </div>
    
    <footer class="w-100 bg-dark text-white p-4 text-center fixed-bottom">
    	&copy;EPAM Systems
    </footer>
  </body>
</html>

</html>	


