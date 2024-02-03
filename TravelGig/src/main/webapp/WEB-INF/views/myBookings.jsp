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

    var userName = "${username}";  // without quotations, it thinks evaluated ${username} is a variable and complains variable username is not found.
    
    $.get("findAllByUserName/" + userName, function(res) {  // call findAllByUserName of TravelGig (this project), get response.
        $("#tblBookings tr:not(:first)").remove();  // remove all but first row which is table header
        console.log(res);
        
        $.each(res, function(idx, val) {
        	var hotelName = "n/a";
            $.get("findHotelById/" + val.hotelId, function(hotel) {  // call findHotelById of TravelGig (this project), get response.
            	$.get("findRoomTypeById/" + val.roomType, function(roomType) {  // call findHotelById of TravelGig (this project), get response.
            	
            	$("#tblBookings").append("<tr>" + "<td>" + hotel.hotelName + "</td>" + "<td>" + val.noRooms + "</td>"
                    + "<td>" + val.checkInDate + "</td>" + "<td>" + val.checkOutDate + "</td>"
                    + "<td>" + roomType.name + "</td>"
                    // + "<td>" + "<a class='hotelDetailOnImage' href='#'><img length=300 width=200 src='" + val.imageURL + "'></img></a>" + "</td>"
                    // + "<td>" + "<img length=300 width=200 src='" + val.imageURL + "' class='hotelDetailOnImage' attrHotelId='" + val.hotelId + "'></img>" + "</td>"
                    + "<td>" + val.status + "</td>" + "<td>" + val.price + "</td>"
                    // + "<td>" + "<button type='button' class='open-my-Modal btn btn-primary' data-toggle='modal' data-target='#searchHotelRoomsModal' attrHotelId='" + val.hotelId + "'>Hotel Detail</button>" + "</td>"
                    + "</tr>");
            	});
            });
        });
    });
});
</script>

</head>
<body>
<div class="container" style="margin-left:100px">
<h1>My Bookings</h1>
<%
Object username = request.getAttribute("username");  // request.getAttribute("username") can be in java codes. ${username} can be in jsp codes.
if(username != null){
%>
<span>Welcome <%=username%>! &nbsp; <a href='login?logout'>Logout</a> &nbsp; <a href='home'>Home</a></span>
<%}else{%>
<a href='login'>Login</a>
<%}%>
</div>

<br/><br/>
<div class="row">

<div class="col-11 border rounded" style="margin-left:50px;">
    <div style='text-align:center;font-size:20px;font-family:"Trebuchet MS", Helvetica, sans-serif'>List of My Bookings:</div>   
    
    <div id="listHotel">
        <table class="table table-striped table-primary", id="tblBookings" border="1">
            <!-- <tr> <th>Name</th> <th>Address</th> <th>City</th> <th>State</th> <th>Price</th> <th>Image</th> <th>Rating</th> <th>Detail</th> </tr> -->
            <tr> <th>Hotel</th> <th>Number of Rooms</th> <th>Check In</th> <th>Check Out</th> <th>Room Type</th> <th>Booking Status</th> <th>Total Price</th> </tr>
        </table>
    </div>

</div>
</div>


</body>
</html>
