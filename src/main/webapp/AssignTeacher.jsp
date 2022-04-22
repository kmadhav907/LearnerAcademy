<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <%@page import="java.util.ArrayList"%>
<%@ include file="Header.jsp" %>
<title>Assign Class</title>
<style>
	body {
	height:100vh;
	width:100vw;
	padding:0;
	margin:0;
	display:flex;
	align-items:center;
	justify-content:center;
	}
	.container {
		min-height: 50vh;
		width: 50vw;
	}
	.button {
		margin-top:5vh;
	}
	.button-group {
		display:flex;
	}
</style>
</head>
<body>
	<form action="AssignTeacher" method="post" class="container">
	<h1 style="color:red;margin:2vh;">Enter the Teacher Details</h1>
  <div class="form-group">
    <label style="margin-top:2vh;" >Enter the first Name</label>
    <input type="text" class="form-control" id="section" aria-describedby="sectionHelp" name ="fname" placeholder="Enter first Name">
  </div>
   <div class="form-group">
    <label style="margin-top:2vh;" >Enter the Last Name</label>
    <input type="text" class="form-control" id="section" aria-describedby="sectionHelp" name ="lname" placeholder="Enter last Name">
  </div>
     <div class="form-group">
    <label style="margin-top:2vh;" >Enter the age</label>
    <input type="number" class="form-control" id="section" aria-describedby="sectionHelp" name ="age" placeholder="age">
  </div>
   <div class="form-group">
    <label for="exampleFormControlSelect1" style="margin-top:2vh;">Select Subject</label>
    <select class="form-control" id="exampleFormControlSelect1" name="selected-subject">
  		<% ArrayList<String> subjects = (ArrayList<String>)request.getAttribute("subjects");
        for(String s:subjects){%>
       			<option value=<%=s %>><%=s %></option>
            <%}%>
    </select>
  </div>
	<div class="button-group">
	  <button type="submit" class="btn btn-primary button">Submit</button>
  <a href="/LearnerAcademy/DashBoard.jsp" class="btn btn-success button" style="margin-left:5vh;">Go Back</a>
	</div>

</form>
</body>
</html>