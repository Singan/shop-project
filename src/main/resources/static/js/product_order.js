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
});

$(document).ready(function(){
    let add_check = $('#new_address');
    let add_input = $('.address');
    let zone = $('input[name=zonecode]');
    let add_detali_input = $('.address_detail');
    let default_address = add_input.val();
    let add_detali = add_detali_input.val();
    let zonecode = zone.val();
    let def_add = $('#default_address');
    let search_btn = $('#addrSearch');
    add_check.click(function(){
        add_input.attr('disabled', false);
        add_detali_input.attr('disabled', false);
        add_input.val("");
        add_detali_input.val("");
        zone.val("");
    });
    def_add.click(function(){
        add_input.attr('disabled', true);
        add_detali_input.attr('disabled', true);
        add_input.val(default_address);
        add_detali_input.val(add_detali);
        zone.val(zonecode);
    });
    let check = def_add.is(':checked');
    if(check){
        search_btn.attr('disabled', true);
    }else if(!check){
        search_btn.attr('disabled', false);
    }

});

