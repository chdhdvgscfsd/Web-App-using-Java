<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A Web Page</title>
<link rel="stylesheet" href="css/styles.css">

<script>
function includeHTML() {
  var z, i, elmnt, file, xhttp;
  /* Loop through a collection of all HTML elements: */
  z = document.getElementsByTagName("*");
  for (i = 0; i < z.length; i++) {
    elmnt = z[i];
    /*search for elements with a certain atrribute:*/
    file = elmnt.getAttribute("w3-include-html");
    if (file) {
      /* Make an HTTP request using the attribute value as the file name: */
      xhttp = new XMLHttpRequest();
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4) {
          if (this.status == 200) {elmnt.innerHTML = this.responseText;}
          if (this.status == 404) {elmnt.innerHTML = "Page not found.";}
          /* Remove the attribute, and call this function once more: */
          elmnt.removeAttribute("w3-include-html");
          includeHTML();
        }
      }
      xhttp.open("GET", file, true);
      xhttp.send();
      /* Exit the function: */
      return;
    }
  }
}
</script>

<script src="js/code.js"></script>
		
</head>
<body bgcolor=cyan>
<div w3-include-html="navigation.html"></div>

	
		<div class="container" id="form1">
			<h3>Admin Login</h3>
			<form action="AdmAuth" method="post">
		  		<div class="form-group">
		    		<label for="inputEmail1">Email address</label><br>
		    		<input type="email" name="adminEmail" class="form-control" id="inputEmail1" aria-describedby="emailHelp" placeholder="Enter email"><br><br>
		  		</div>
		  		<div class="form-group">
		    		<label for="inputPassword1">Password</label><br>
		    		<input type="password" name="adminPassword" class="form-control" id="inputPassword1" placeholder="Password"><br><br>
		  		</div>
		  
		  		<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div><br><br>
			
		<div class="container" id="form2">
			<h3>Librarian Login</h3>
			<form action="LibrarianAuthentification" method="post">
		  		<div class="form-group">
		    		<label for="inputEmail1">Email address</label><br>
		    		<input type="email" name="librarianEmail" class="form-control" id="inputEmail2" aria-describedby="emailHelp" placeholder="Enter email"><br><br>
		  		</div>
		  		<div class="form-group">
		    		<label for="inputPassword2">Password</label><br>
		    		<input type="password" name="librarianPassword" class="form-control" id="inputPassword2" placeholder="Password"><br><br>
		  		</div>
		  
		  		<button type="submit" class="btn btn-primary">Submit</button>
			</form>
			
		</div>
	
	<div w3-include-html="footer.html"></div>
	<script>
	includeHTML();
	</script>
</body>
</html>

