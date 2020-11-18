<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String table = (String) request.getAttribute("table");
    	
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sci-Fi Library</title>
</head>
<body>

<h1>Sci-Fi Library</h1>

<%= table %>

<br />
<a href="add">Go back to main page</a>

</body>
</html>