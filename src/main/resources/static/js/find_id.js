$(document).ready(function(){
	let modal = $('.modal');
	let text = $('.model_layout > h2');
	$('.submit').click(function(){
		modal.fadeIn();
		text.text("당신의 아이디는 [admin]입니다.");
		$("body").css("overflow","hidden");
		$('.modal_content').css({
            "top": (($(window).height() - $(".modal_content").outerHeight()) / 2 + $(window).scrollTop()) + "px"
        }).show();
	});
	$(".modal_out_btn").click(function(){
        $(".modal").fadeOut();
        $("body").css("overflow","auto");
    });
});