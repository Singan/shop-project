// $(function(){ 
//     $("#coupon").click(function(){
//         $(".modal").fadeIn();
//         //$("body").css('position', 'fixed');
//     });        
//     $(".modal_out_btn").click(function(){
//         $(".modal").fadeOut();
//         //$("body").css('position', 'static');
//     });        
// });

$(document).ready(function(){
	$('#coupon').click(function() {
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
});

