let count = 1;
function reviewImage(obj) {

    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $('.view_image').append(img);
        $(img).addClass('appndImage');
        $(img).attr('id','appndImage' + count);
        count += 1;
    }
}


$(document).ready(function () {
	$(".view_image").click(function (e) {
		console.log(event.target.id);
		$("#" + event.target.id).remove();
		count -= 1;
	})
});


$(document).ready(function() {
    let count = $(".number").val();
    let num = parseInt(count, 10);
    let plus = $(".plus");
    let minus = $(".minus");
    $(".number").on("propertychange change paste input", function(){
        num = parseInt($(".number").val(), 10);
    });
    

    plus.click(function(){
        num += 1; 
        $(".number").val(num);
    });
    minus.click(function(){
       if(num > 1){
            num -= 1;
            $(".number").val(num);
       }else{
            num = 1;
            return false;

       }
    });
        
});
