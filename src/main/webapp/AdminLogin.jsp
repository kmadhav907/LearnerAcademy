<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Academy</title>  
<%@ include file="Header.jsp" %>

<style>
.container {
	margin:0;
	padding:0;
	display:flex;
	align-items:center;
	justify-content:center;
	height:100vh;
	width:100vw;
}
.form-container {
	width:50vw;
	min-height:60vh;
	display:flex;
	align-items:center;
	justify-content:center;
	flex-direction:column;
}
.input-container{
	width:100%;
	height:100%;
}
</style>
</head>
<body>
	<div class="container">
	<form action=AdminLogin class="form-container" method="post">
		<div class="mb-3 input-container" style="text-align:center; font-size:1.1em;font-weight:bold">
			Admin Login
		</div>
		<div class="mb-3 input-container">
  			<label for="exampleFormControlInput1" class="form-label">Email address</label>
  			<input type="text" class="form-control" id="email-control" name="email" placeholder="name@example.com">
		</div>
		<div class="mb-3 input-container">
 			<label for="exampleFormControlInput1" class="form-label">Password</label>
  			<input type="password" class="form-control" id="password-control" name="password">
		</div>
		<div class="mb-3 input-container">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form> 	
</div>
</body>

</html>