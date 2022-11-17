$(function(){ 
    $("#coupon").click(function(){
        $(".modal").fadeIn();
        $("body").css('position', 'fixed');
    });        
    $(".modal_out_btn").click(function(){
        $(".modal").fadeOut();
        $("body").css('position', 'static');
    });        
});

