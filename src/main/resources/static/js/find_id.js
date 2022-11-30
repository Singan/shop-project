$(document).ready(function(){
	let modal = $('.modal');
	let text = $('.model_layout > h2');
	$('.submit').click(function(){
		let name = $("input[name='name']").val();
		$.ajax(
			{
				url:"/find/id",
				type:"post",
				data:JSON.stringify({
					name:name,
				}),
				dataType : "text",
				contentType: 'application/json',
				success:function(data){
					text.text(`당신의 아이디는 [${data}]입니다.`);
					modal.fadeIn();
					$("body").css("overflow","hidden");
					$('.modal_content').css({
						"top": (($(window).height() - $(".modal_content").outerHeight()) / 2 + $(window).scrollTop()) + "px"
					}).show();
				},

			}
		);
	});
	$(".modal_out_btn").click(function(){
        $(".modal").fadeOut();
        $("body").css("overflow","auto");
    });
});