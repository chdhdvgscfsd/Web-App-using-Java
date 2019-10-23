<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- JSP Directive -->
 <%@ page import="java.util.Calendar, java.util.Date, java.time.LocalDate, java.time.ZoneId" %>
 
 	<%
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		int year = localDate.getYear();
		String month = localDate.getMonth().name();
		int day = localDate.getDayOfMonth();
		
		String today = month + " "+ day +" "+ year;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styles.css">


</head>
<body>
	

	

	<div class= "footerLine"><hr></div><br>
	
	<div class="footer">Collins Mbuton, ID:101175934</div>
	<div class="footerTime"><%=today %></div>



</body>
</html>