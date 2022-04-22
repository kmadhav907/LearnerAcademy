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
	<form action="AssignClass" method="post" class="container">
	<h1 style="color:red;margin:2vh;">Enter the class Details</h1>
  <div class="form-group">
    <label style="margin-top:2vh;" >Enter the section</label>
    <input type="number" class="form-control" id="section" aria-describedby="sectionHelp" name ="section" placeholder="Enter section">
  </div>
   <div class="form-group">
    <label style="margin-top:2vh;">Enter the timings</label>
    <input type="text" class="form-control" id="section" aria-describedby="Timings"  name ="timings" placeholder="Enter the timings">
  </div>
   <div class="form-group">
    <label for="exampleFormControlSelect1" style="margin-top:2vh;">Select teacher</label>
    <select class="form-control" id="exampleFormControlSelect1" name="selected-teacher">
  		<% ArrayList<String> teachers = (ArrayList<String>)request.getAttribute("teachers");
        for(String s:teachers){%>
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