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
        $('#modal_coupon').fadeIn();
        $('#coupon_content').css({
            "top": (($(window).height() - $("#coupon_content").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        }).show();

        $("body").css("overflow","hidden");
    });
    $(".modal_out_btn").click(function(){
        	$("#modal_coupon").fadeOut();
        	$("body").css("overflow","auto");
    });

    $('#my_review').click(function() {
        $('#modal_review').fadeIn();
        $('#review_content').css({
            "top": (($(window).height() - $("#review_content").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        }).show();

        $("body").css("overflow","hidden");
    });
    $(".modal_out_btn").click(function(){
            $("#modal_review").fadeOut();
            $("body").css("overflow","auto");
    });
});

