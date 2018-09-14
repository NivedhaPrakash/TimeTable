<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,com.ibm.timetable.TimeTable,com.ibm.timetable.Crud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Table</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
</head>
<body>
<div class="jumbotron">
<h3><b>Time-Table</b></h3>
<form action="/TimeTable/Schedule" method="post">
<table class="table">
<thead>
				<tr scope="col">
					<td><b>Time</b></td>
					<td><b>Monday</b></td>
					<td><b>Tuesday</b></td>
					<td><b>Wednesday</b></td>
					<td><b>Thrusday</b></td>
					<td><b>Friday</b></td>
				</tr>
				</thead>
				<tbody>
				<%
					List<TimeTable> time = (List<TimeTable>) request.getAttribute("time");

					for (TimeTable e : time) {
				%>
				
				<tr scope="row">
					<td>
						<% out.println(e.getTime());%> - <%out.println(e.getTime()+1); %>
					</td>
					<td><input type="submit" class="btn btn-link" name="week" value=<%=e.getMon()%>></td>
					<td><input type="submit" class="btn btn-link" name="week" value=<%=e.getTue()%>></td>
					<td><input type="submit" class="btn btn-link" name="week" value=<%=e.getWed()%>></td>
					<td><input type="submit" class="btn btn-link" name="week" value=<%=e.getThrus()%>></td>
					<td><input type="submit" class="btn btn-link" name="week" value=<%=e.getFri()%>></td>
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<br>
</form>
</div>
</body>
</html>