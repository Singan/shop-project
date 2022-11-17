$(function(){ 
    $("#inquiry_btn").click(function(){
        $(".modal").fadeIn();
        $("body").css('position', 'fixed');
    });
    $(".modal_out_btn").click(function(){
        $(".modal").fadeOut();
        $("body").css('position', 'static');
    });
});

$(function(){ 
    $("#admin_answer").click(function(){
        $(".modal_admin").fadeIn();
    });
    $(".modal_out_btn").click(function(){
        $(".modal_admin").fadeOut();
    });
});