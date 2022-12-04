function productinsert(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        $('.insert_img').attr('src', e.target.result);
        a = e.target.result;
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
        formData = new formData($("#product_form"));
        let name = $('input[name=name]');
        let shortContent = $('input[name=shortContent]');
        let price = $('input[name=price]');
        let count = $('input[name=count]');
        let discountRate = $('input[name=discountRate]');
        let category = $('select[name=category]');
        let categorydetail = $('select[name=categorydetail]');

        formData.append("name",name.val());
        formData.append("shortContent",shortContent.val());
        formData.append("price",price.val());
        formData.append("count",count.val());
        formData.append("discountRate",discountRate.val());
        formData.append("category",category.val());
        formData.append("categorydetail",categorydetail.val());
        formData.append("image", $("#product_content_img")[0].files[0]);
        formData.append("content", $(".product_insert_contents").html());
        $.ajax({
            type : "POST",
            url : "/product/insert",
            data : formData,
            processData: false,
            contentType: false,
            success : function(data){
                console.log(data);
                return false;
            }

        });
    });
});

