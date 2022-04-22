<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Header.jsp" %>
<title>Welcome Admin</title>
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
		<h1 style="color:red;margin:20vh 0">Welcome Admin</h1>
		<div class="button-container">
			<a href="/LearnerAcademy/ClassList" class="btn btn-primary">Class list</a>
			<a href="/LearnerAcademy/SubjectList" class="btn btn-secondary">Subject list</a>
			<a href="/LearnerAcademy/TeacherList" class="btn btn-warning">Teacher list</a>
			<a href="/LearnerAcademy/AssignTeacher" class="btn btn-dark">Assign Teacher</a>
			<a href="/LearnerAcademy/AssignClass" class="btn btn-success">Assign Class</a>
			<a href="/LearnerAcademy/StudentReport" class="btn btn-primary">Student Reports</a>

		</div>
		
	</div>
</body>
</html>