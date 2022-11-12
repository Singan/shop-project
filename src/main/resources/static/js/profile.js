let a;
function readprofile(obj) {
    let reader = new FileReader();
    if(!obj.files.length) {
        return;
    }
    reader.readAsDataURL(obj.files[0]);
    reader.onload = function (e) {
        $('.profile_image').attr('src', e.target.result);    
        a = e.target.result;
    }
}

$(document).ready( function(){
	var submit = $('#profile_btn');
	submit.click(function(){
		console.log(a);
	});
	
});