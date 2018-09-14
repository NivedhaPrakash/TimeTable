<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="java.util.List,com.ibm.timetable.Trainer,com.ibm.timetable.Crud"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Classes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
</head>
<script type="text/javascript">
function change(obj){
	txt=obj.options[obj.selectedIndex].text;
	location.href = "/TimeTable/Result?text=" +txt;
}
</script>
<body>
<div class="jumbotron" style="text-align:center;">
Schedule for Trainer : 
<select name="subjects" onchange="change(this);">
<option value=" " selected disabled hidden>Select the Trainer</option>
<%List<Trainer> subject = (List<Trainer>) request.getAttribute("subject");
   for (Trainer e : subject) { %>
<option><%=e.getT_name()%></option>
<%} %>
</select>
</div>
</body>
</html>