<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Sci Fi Library - Add a Book</title>
</head>
<body>

<h1>Sci Fi Library - Add a Book</h1>

<form name=addForm action=addBook method=get >

   <label>
      Book title:
   </label>
   <input type=text name=title value="" />
   <br />
   <label>
      Book author:
   </label>
   <input type=text name=author value="" />
   <br />
   
   <label>
      Book pages:
   </label>
   <input type=text name=pages value="" />
   <br />
   
   <label>
      Book rating:
   </label>
   <input type=text name=rating value="" />
   <br />
   
   <input type=submit name=submit value="Add the Book" />

</form>
</body>
</html>