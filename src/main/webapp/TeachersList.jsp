<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.models.TeacherModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="Header.jsp" %>
<title>Teacher Result Page</title>
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
	<h1 style="color:red">Teacher Result are:</h1>
	<table class="table table-hover">
		<thead>
		<tr>
		<th scope="col">
			Teacher ID
		</th>
		<th scope="col">
			Teacher Name
		</th>
		<th scope="col">
			Age
		</th>
		<th scope="col">
			Subject
		</th>
		
		</tr>
		</thead>
		<tbody>
		 <% ArrayList<TeacherModel> teachers = (ArrayList<TeacherModel>)request.getAttribute("teachers");
        for(TeacherModel t:teachers){%>
            <tr>
       			<td><%=t.getId() %></td>
       			<td><%=t.getName() %></td>
       			<td><%=t.getAge() %></td>
       			<td><%=t.getSubjectName() %>
            </tr>
            <%}%>
            </tbody>
	</table>
	<a href="/LearnerAcademy/DashBoard.jsp" class="btn btn-success">Go Back</a>
</div>
 
</body>
</html>