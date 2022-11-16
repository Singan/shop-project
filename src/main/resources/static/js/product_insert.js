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
        $('.content_img').attr('src', e.target.result); 
        a = e.target.result;
    }
}