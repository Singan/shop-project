$(document).ready(function(){
	$('.detail').click(function() {
        $('.modal').fadeIn();
        $('.modal_content').css({
            "top": (($(window).height() - $(".modal_content").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        }).show();

        $("body").css("overflow","hidden");
    });
    $(".modal_out_btn").click(function(){
        	$(".modal").fadeOut();
        	$("body").css("overflow","auto");
    });

        
        $('.numberButton').click(function(){
            let disCount = parseInt($('#productdisCount').text());
            let price = parseInt($('#productPrice').text());
            let disPrice;
            if(disCount > 0){
                disPrice = price * (1-(disCount/100));
                console.log(disPrice);
            }else if(disCount <= 0){
                $('#productdisCount').css('display','none');
            }
            console.log(disPrice);
        });

});


