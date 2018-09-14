<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Time Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
</head>
<style>
input[type=submit]
{
cursor: pointer;
}</style>
<body>
<div class="jumbotron" style="text-align:center;">
<form action="/TimeTable/CreateTable" method="post">
<h3><b><%=request.getAttribute("setup") %></b></h3>
Start Time Of The Day
<select name="starttime">
<option value="8">8:00am</option>
<option value="9">9:00am</option>
</select> 
<br>
End Time Of The Day
<select name="endtime">
<option value="12.30">12:30pm</option>
<option value="13.30">01:30pm</option>
<option value="14.30">02:30pm</option>
</select>
<br>
<br>
<input class="btn btn-outline-primary" type="submit" value="Configure">
</form>
</div>
</body>
</html>