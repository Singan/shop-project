$(document).ready( function() {
		$("#wishlist").click( function() {
  			if($("#wishlist_content").css("display") == "block"){ 
				$("#wishlist_content").hide(300);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#wishlist_content").css("display") == "none"){
				$("#wishlist_content").show(300);
				$("#basketlist_content").hide(300);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
				$("#wishlist_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	

		$("#basketlist").click( function() {
  			if($("#basketlist_content").css("display") == "block"){ 
				$("#basketlist_content").hide(300);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#basketlist_content").css("display") == "none"){
				$("#basketlist_content").show(300);
				$("#wishlist_content").hide(300);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
				$("#basket_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	
      	
    });

