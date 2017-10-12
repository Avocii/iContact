<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>iContact Registrati</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <style>
  body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
      color: #f5f6f7;
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  .bg-1 { 
      background-color: #1abc9c; /* Green */
      color: #ffffff;
  }
  .bg-2 { 
      background-color: #474e5d; /* Dark Blue */
      color: #ffffff;
  }
  .bg-3 { 
      background-color: #ffffff; /* White */
      color: #555555;
  }
  .bg-4 { 
      background-color: #2f2f2f; /* Black Gray */
      color: #fff;
  }
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
  .btn {
    border: none;
    color: white;
    padding: 14px 28px;
    font-size: 16px;
    cursor: pointer;
}
  .success {background-color: #4CAF50;} /* Green */
.success:hover {background-color: #46a049;}
  </style>
</head>
<body>

<div class="jumbotron bg-1 text-center">
  <h1>iContact</h1>
  <p>Crea e Registra un Nuovo Account!</p> 
</div>
  
<div class="container bg-3">

    <div class="col-sm-5">
      <h3>Registrati QUI!</h3>
      <p>Inserisci Username e Password:</p>
			<div class="col-xs-6">
			<form action="register" method="post">
			<label for="register">Username:</label>
      <input type="text" name="username" class="form-control" id="register">	
	
			<label for="register">Password:</label>
      <input type="password" name="password" class="form-control" id="register">
			<br>
			<button class="btn success" type="submit" onclick='return registrazione()'>OK!</button>
			<script>
			function registrazione() {
				if (!confirm("Confermi la Registrazione?"))
            return false;
			}
			</script>
			</form>
			</div>	
			 
    </div>
   
   
  
</div>

</body>
</html>