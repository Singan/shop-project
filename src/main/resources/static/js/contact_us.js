$(function(){ 
    $("#inquiry_btn").click(function(){
        $(".modal").fadeIn();
    });
    $(".modal_out_btn").click(function(){
        $(".modal").fadeOut();
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