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
        }
        if(productNo.length>0){
            data.productNo = productNo.val();
        }else{
        }
        formData.append('product', new Blob([ JSON.stringify(data) ], {type : "application/json"}));
        formData.append("image", $("#product_content_img")[0].files[0]);
        $.ajax({
            type : "POST",
            url : "/product/insert",
            data : formData,
            error: function(data){
                console.log(data);
            },
            cache: false,
            enctype : 'multipart/form-data',
            contentType: false,
            processData: false,
            success : function(data){
                location.href="/product/detail?no="+data;
            }

        });
    });
});

