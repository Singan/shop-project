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
    let formData;
    formData = new formData($("#product_form"));
    let name = $('input[name=name]');
    let shortContent = $('input[name=shortContent]');
    let price = $('input[name=price]');
    let count = $('input[name=count]');
    let discountRate = $('input[name=discountRate]');
    let category = $('select[name=category]');
    let categorydetail = $('select[name=categorydetail]');

    formData.append("product_name",name.val());
    formData.append("product_count",shortContent.val());
    formData.append("product_price",price.val());
    formData.append("product_count",count.val());
    formData.append("product_discount",discountRate.val());
    formData.append("product_category",category.val());
    formData.append("product_categorydetail",categorydetail.val());
    formData.append("product_image", $("#product_content_img")[0].files[0]);
    formData.append("product_content", $(".product_insert_contents").html());

    $('#submit').click(function(){
        $.ajax({
            type : "POST",
            url : "/product/insert",
            data : formData,
            processData: false,
            contentType: false,
            success : function(data){
                console.log(data);
            }

        });
    });
});

