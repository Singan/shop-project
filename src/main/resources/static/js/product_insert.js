let image ;
function productinsert(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        $('.insert_img').attr('src', e.target.result);
        a = e.target.result;
        image = e.target.result;
    }
}
function productcontent(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        let img = $('<img />');
        $(img).attr('src', e.target.result);
        $('.product_insert_contents').append(img);
    }
}

$(document).ready(function(){
    $('#submit').click(function(){
        let formData;
        formData = new FormData($("#product_form")[0]);
        let name = $('input[name=name]');
        let shortContent = $('input[name=shortContent]');
        let price = $('input[name=price]');
        let count = $('input[name=count]');
        let discountRate = $('input[name=discountRate]');
        let category = $('select[name=category]');
        let categorydetail = $('select[name=categorydetail]');
        let productNo = $('input[name=productNo]');
        let content = $(".product_insert_contents");
        console.log(productNo)


        console.log("아아아아아아")

        let data = {
            name : name.val(),
            shortContent : shortContent.val(),
            price : price.val(),
            count : count.val(),
            discountRate : discountRate.val(),
            category : category.val(),
            categorydetail : categorydetail.val(),
            content : content.html(),
            image:image
        }

        $.ajax({
            type : "POST",
            url : "/product/insert",
            data : data,
            error: function(data){
                console.log(data);
            },
            cache: false,
            contentType: "application/json",
            processData: false,
            success : function(data){
                console.log(data);
            }

        });
    });
});

