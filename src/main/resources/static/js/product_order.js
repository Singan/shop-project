$(document).ready(function () {
	$(".view_image").click(function (e) {
		console.log(event.target.id);
		$("#" + event.target.id).remove();
		count -= 1;
	})
});


$(document).ready(function() {
    let plus = $(".plus")
    let minus = $(".minus")
    let count = 1;
    let in_val = 1;
    let btn;
    let number;
    let num;

    for(let i = 0;i <= plus.length; i++){
        $(plus[i]).attr("id", "p"+count);
        $(minus[i]).attr("id", "m"+count);
        count += 1;
    }
    plus.click(function(event) {
        let btn = event.target.id;
        let number = $("#"+btn).next();
        let num = parseInt(number.val());
        num += 1;
        number.val(num);
    });
    minus.click(function(event) {
        btn = event.target.id;
        number = $("#"+btn).prev();
        num = parseInt(number.val());

        if(num > 1){
            num -= 1;
            number.val(num);
        }else{
            num = 1;

        }
    });

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
