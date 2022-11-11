const Time = 400;
$(document).ready( function() {
		$("#wishlist").click( function() {
  			if($("#wishlist_content").css("display") == "block"){ 
				$("#wishlist_content").slideUp(Time);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#wishlist_content").css("display") == "none"){
				$("#wishlist_content").slideDown(Time);
				$("#basketlist_content").slideUp(Time);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
				$("#wishlist_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	

		$("#basketlist").click( function() {
  			if($("#basketlist_content").css("display") == "block"){ 
				$("#basketlist_content").slideUp(Time);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#basketlist_content").css("display") == "none"){
				$("#basketlist_content").slideDown(Time);
				$("#wishlist_content").slideUp(Time);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
				$("#basket_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	
      	
    });

