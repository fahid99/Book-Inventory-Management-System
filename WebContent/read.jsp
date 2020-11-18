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

<h3>Select a minimum rating to sort through the list of books</h3>
<select name="ratings" size="6">  
    <option value="0"> 0 </option>
    <option value="1"> 1 </option>
    <option value="2"> 2 </option>
    <option value="3"> 3 </option>
    <option value="4"> 4 </option>
    <option value="5"> 5 </option>
</select>

<br></br>

<%= table %>

<br />
<a href="add">Add a book</a>

</body>
</html>