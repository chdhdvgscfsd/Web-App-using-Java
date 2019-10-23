<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A Web Page</title>
<link rel="stylesheet" href="css/styles.css">
<!--  <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">  -->


		
</head>
<body bgcolor="cyan">
<%@ include file="navigation.jsp" %>

	
	
		<div class="container" id="form1">
			<h3>Admin Login</h3>
			<h3 class="msg">${message}</h3><br>
			<form action="AdmAuth" method="post">
		  		<div class="form-group">
		    		<label for="inputEmail1">Email address</label><br>
		    		<input type="email" name="adminEmail" class="form-control" id="inputEmail1" aria-describedby="emailHelp" 
		    			placeholder="Enter email" value="${email}">
		    		<br><br>
		  		</div>
		  		<div class="form-group">
		    		<label for="inputPassword1">Password</label><br>
		    		<input type="password" name="adminPassword" class="form-control" id="inputPassword1" placeholder="Password"><br><br>
		  		</div>
		  
		  		<button type="submit" class="btn btn-primary">Submit</button><br>
		  		
			</form>
		</div><br><br>
			
		<div class="container" id="form2">
			<h3>Librarian Login</h3>
			<h3 class="msg">${message1}</h3><br>
			<form action="LibrarianAuthentification" method="post">
		  		<div class="form-group">
		    		<label for="inputEmail1">Email address</label><br>
		    		<input type="email" name="librarianEmail" class="form-control" id="inputEmail2" aria-describedby="emailHelp" 
		    		placeholder="Enter email"  value="${email1}"><br><br>
		  		</div>
		  		<div class="form-group">
		    		<label for="inputPassword2">Password</label><br>
		    		<input type="password" name="librarianPassword" class="form-control" id="inputPassword2" placeholder="Password"><br><br>
		  		</div>
		  
		  		<button type="submit" class="btn btn-primary">Submit</button>
		  		
			</form>
			
		</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>

