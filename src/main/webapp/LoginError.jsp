<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Something went wrong</title>
</head>
<script>
function onLoad() {
  alert("Invalid Credentials");
}
</script>
<body onload="onLoad()">

<%@ include file="AdminLogin.jsp" %>
</body>
</html>