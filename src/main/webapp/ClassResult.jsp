<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.models.ClassModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="Header.jsp" %>
<title>Class Result Page</title>
<style>
.container {
	display: flex;
	align-items:center;
	justify-content:center;
	height:100vh;
	width:100vw;
	flex-direction:column;
}
</style>
</head>
<body>
<div class="container">
	<h1 style="color:red">Class Result are:</h1>
	<table class="table table-hover">
		<thead>
		<tr>
		<th scope="col">
			Class Name
		</th>
		<th scope="col">
			Class Timings
		</th>
		<th scope="col">
			Class Teacher
		</th>
	
		</tr>
		</thead>
		<tbody>
		 <% ArrayList<ClassModel> classes = (ArrayList<ClassModel>)request.getAttribute("classes");
        for(ClassModel c:classes){%>
            <tr>
       			<td><%=c.getClassNumber() %></td>
       			<td><%=c.getTiminings() %></td>
       			<td><%=c.getClassTeacher() %></td>
            </tr>
            <%}%>
            </tbody>
	</table>
	<a href="/LearnerAcademy/DashBoard.jsp" class="btn btn-success">Go Back</a>
</div>
 
</body>
</html>