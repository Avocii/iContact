<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Contatti</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/mycss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">iContact</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="getList">Home</a></li>
      <li><a href="../user/logout" onclick='return logout()'>Logout</a>
      <script>
			function logout() {
				if (!confirm("Sicuro di voler Uscire?"))
			        return false;
			}
			</script>
      </li>
      
    </ul>
  </div>
</nav>
	<div class="container">
		<h2>Benvenuto ${user.username}!</h2>
		<p>Ecco i tuoi contatti tabellati uno per uno:</p>
		<table class="table table-striped table-bordered" id="myTable">
			<thead>
				<tr>
					<th><span class="glyphicon glyphicon-user margin-icon-text"></span> Nome <span onclick="sortTable(0)" class="glyphicon glyphicon-sort pull-right"></span></th>
					<th><span class="glyphicon glyphicon-user margin-icon-text"></span> Cognome <span onclick="sortTable(1)" class="glyphicon glyphicon-sort pull-right"></span></th>
					<th><span class="glyphicon glyphicon-earphone margin-icon-text"></span> Telefono</th>
					<th><span class="glyphicon glyphicon-envelope margin-icon-text"></span> Email <span onclick="sortTable(2)" class="glyphicon glyphicon-sort pull-right"></span></th>
					<th><span class="glyphicon glyphicon-cog margin-icon-text"></span> Azioni</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${lista}" var="contatti">
					<tr>
						<td><a>${contatti.getName()}</a></td>
						<td><a>${contatti.getCognome()}</a></td>
						<td><a>${contatti.getTel()}</a></td>
						<td><a>${contatti.getMail()}</a></td>
						<td>
  <div class="btn-group pull-right">
  
  <button type="button" class="btn btn-default">Scegli</button>

  
  <button type="button" class="btn btn-basic dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <span class="glyphicon glyphicon-option-vertical"></span>
    <span class="sr-only"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a  href="edit?id=${contatti.getId()}"> <span class="glyphicon glyphicon-pencil margin-icon-text"></span> Modifica</a></li>

    <li><a href="delete?id=${contatti.getId()}" onclick='return elimina()'> <span class="glyphicon glyphicon-trash margin-icon-text"></span> Elimina</a>
    <script>
			function elimina() {
    	if (!confirm("Sicuro di voler eliminare il contatto?"))
        return false;
			}
			</script>
    </li>
   
    </ul>
</div>
</td>
					</tr>
				</c:forEach>


  
			</tbody>
		</table>
		<script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("myTable");
  switching = true;
  // Set the sorting direction to ascending:
  dir = "asc"; 
  /* Make a loop that will continue until
  no switching has been done: */
  while (switching) {
    // Start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /* Loop through all table rows (except the
    first, which contains table headers): */
    for (i = 1; i < (rows.length - 1); i++) {
      // Start by saying there should be no switching:
      shouldSwitch = false;
      /* Get the two elements you want to compare,
      one from current row and one from the next: */
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      /* Check if the two rows should switch place,
      based on the direction, asc or desc: */
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
          // If so, mark as a switch and break the loop:
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
      /* If a switch has been marked, make the switch
      and mark that a switch has been done: */
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      // Each time a switch is done, increase this count by 1:
      switchcount ++; 
    } else {
      /* If no switching has been done AND the direction is "asc",
      set the direction to "desc" and run the while loop again. */
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>
<script>
function cercaNome() {
  // Declare variables 
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    } 
  }
}
</script>
	</div>
	<div class="container bg-3">
  <div class="row">
    <div class="col-sm-5">
	<a href="save" class="btn btn-success btn-md btn-sx">
      <span class="glyphicon glyphicon-plus margin-icon-text"></span> Add
       <span class="sr-only"></span>
    </a>
    </div>
    </div>
    </div>

</body>
</html>