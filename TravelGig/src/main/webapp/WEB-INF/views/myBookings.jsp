<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>My Booking</title>

<script>
$(document).ready(function() {
    
});
</script>

</head>
<body>
<h1>My Bookings</h1>
<%
Object username = request.getAttribute("username");  // request.getAttribute("username") can be in java codes. ${username} can be in jsp codes.
if(username != null){
%>
<span>Welcome <%=username%>! &nbsp; <a href='login?logout'>Logout</a> &nbsp; <a href='home'>Home</a></span>
<%}else{%>
<a href='login'>Login</a>
<%}%>


</body>
</html>
