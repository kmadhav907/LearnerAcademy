<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<%@ include file="Header.jsp" %>
<title>Subject Result Page</title>
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
	<h1 style="color:red">Subject Result are:</h1>
	<table class="table table-hover">
		<thead>
		<tr>
		<th scope="col">
			Subject Name
		</th>
		</tr>
		</thead>
		<tbody>
		 <% ArrayList<String> subjects = (ArrayList<String>)request.getAttribute("subjects");
        for(String s:subjects){%>
            <tr>
       			<td><%=s %></td>
    
            </tr>
            <%}%>
            </tbody>
	</table>
	<a href="/LearnerAcademy/DashBoard.jsp" class="btn btn-success">Go Back</a>
</div>
 
</body>
</html>