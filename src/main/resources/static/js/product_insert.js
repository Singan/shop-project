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
    let formData = new formData($("#product_form"));

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

            }

        });
    });
});

