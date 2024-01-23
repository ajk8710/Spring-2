$(document).ready(function(){
    
    $("#searchBtn").click(function(){
        var searchText = $("#searchLocation").val();
        $('#tblHotel tr').not(':first').remove();
        $.get("http://localhost:8282/searchHotel/"+searchText, {
            }, function(responseText) {
                $.each(responseText, function(key1, value1) {
                $("#tblHotel").append("<tr><td>"+value1.hotelName+"</td><td><img class='hotelImage' src='"+value1.imageURL+"' width='300' heigth='300'/></td><td>"+value1.averagePrice+"</td><td>"+value1.starRating+"</td></tr>")
            });
                                 
         });        
    });
    
    $("#filterBtn").click(function(){
        var price = parseInt($("#priceValue").text());
        var flag = 0;
        $('#tblHotel tr').not(':first').each(function() {
            $(this).show();
            var hotelPrice = parseInt($(this).children("td").eq(2).text());
            var starRating = parseInt($(this).children("td").eq(3).text());
                
            $('.star_rating').each(function () {
                 if (this.checked) {
                   var rating = $(this).val();
                   if(rating==starRating){
                        flag = 1;
                        
                        
                   } 
                 }
            });
            if(flag==0)
            {
                $(this).hide();
            }
            else if(hotelPrice>price){
                $(this).hide(); 
            }
        });         
    });
    
    $("#tblHotel").on('click','.hotelImage',function() {
        var hotelName = $(this).parent().parent().children("td").eq(0).text();
        $("#myModal").modal();
        $("#modal_hotelName").val(hotelName);   
        $("#modal_noGuests").val($("#noGuests").val());
        $("#modal_checkInDate").val($("#checkInDate").val());
        $("#modal_checkOutDate").val($("#checkOutDate").val());
        $("#modal_noRooms").val($("#noRooms").val());
        
                
    });
    
    $("#myModal").on('click','.btn-searchHotelRooms',function() {
        $("#bookingHotelRoomModal").modal();
                
    }); 
    
});
