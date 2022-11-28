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
});
