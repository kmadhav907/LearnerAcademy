<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.models.StudentModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="Header.jsp" %>
<title>Student Report Page</title>
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
	<h1 style="color:red">Student Report:</h1>
	<table class="table table-hover">
		<thead>
		<tr>
		<th scope="col">
			Student Name
		</th>
		<th scope="col">
			Age
		</th>
		<th scope="col">
			Class
		</th>
		<th scope="col">
			Section
		</th>
		
		</tr>
		</thead>
		<tbody>
		 <% ArrayList<StudentModel> students = (ArrayList<StudentModel>)request.getAttribute("students");
        for(StudentModel s:students){%>
            <tr>
       			<td><%=s.getName() %></td>
       			<td><%=s.getAge() %></td>
       			<td><%=s.getClassNumber() %></td>
       			<td><%=s.getSection() %></td>
            </tr>
            <%}%>
            </tbody>
	</table>
	<a href="/LearnerAcademy/DashBoard.jsp" class="btn btn-success">Go Back</a>
</div>
 
</body>
</html>