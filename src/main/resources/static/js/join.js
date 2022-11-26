function check(){
	const emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	const passwordRegex = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
	const idRegx = /^[a-z]+[a-z0-9]{5,19}$/g;
	const nameRegx = /[ㄱ-힣]/;

	let id = $("input[name='id']");
	let pwd = $("input[name='pwd']");
	let address = $("input[name='address']");
	let email = $("input[name='email']");
	let name = $("input[name='name']");
	let repwd = $("input[name='pwd_confirm']");
	let email_add = $("#sign_up_email option:selected");

	let email_check = emailRegex.test(email + "@" + email_add);
	let pwd_check = passwordRegex.test(pwd);
	let id_check = idRegx.test(id);
	let name_check = nameRegx.test(name);


	if(id.val() == ""){
        alert("아이디를 입력해주세요.");
        id.focus();
        return false;
    }

    if(!name_check){
    	alert("형식에 맞춰 작성해주세요.");
    	name.focus();
    	return false;
    }

    if(!pwd_check) {
      alert("형식에 맞춰서 비밀번호를 입력해주세요.");
      pwd.focus();
      return false;
    }

    if(pwd.val() != repwd.val()){ 
      alert("비밀번호가 다릅니다.");
      $("input[name='pwd']").val("");
      $("input[name='pwd_confirm']").val("");
      pwd.focus();
      return false;
    }

    if(email.val() == ""){
        alert("이메일을 입력해주세요");
        email.focus();
        return false;
    }

    if(!email_check){
        alert("이메일형식에 맞게 입력해주세요")
        email.focus();
        return false;
    }

    
    return true;
}



$(document).ready(function(){

	var submit = $("#submit")
    submit.on("click",function(){
        let id = $("input[name='id']").val();
        let pwd = $("input[name='pwd']").val();
        let birth = $("input[name='birth']").val();
        let gender = $("input[name='gender']").val();
        let address = $("input[name='address']").val();
        let email = $("input[name='email']").val();
        let zoneCode = $("input[name='zoneCode']").val();
        let email2 = $("#sign_up_email").val();
        let addressDetail = $("input[name='address_detail']").val();
        let phone = "";
        let phoneInput = $("input[name='phone']");

        for(let i = 0; i<phoneInput.length;i++){

            phone += phoneInput[i].value ;
            if(i<phoneInput.length-1)
                phone+= "-"
        }
        if(!idCheck()){
            $("input[name='id']").focus();
            return;
        }
        $.ajax(
        	{
                url:"/member/join",
                type:"POST",
                data:JSON.stringify({
                    name:name,
                    id:id,
                    pwd:pwd,
                    birth:birth,
                    gender:gender,
                    address:address,
                    email:email+"@"+email2,
                    zoneCode:zoneCode,
                    addressDetail:addressDetail,
                    phone:phone,
                }),
                dataType : "json",
                contentType: 'application/json',
                success:()=>{
                    location.href = "http://localhost:8080/login";
                }
		    }
		)
    })

    var addrSearch = $("#addrSearch");
    addrSearch.on("click",function(){
        new daum.Postcode({
            oncomplete: function(data) {
                console.log(data)
                $("input[name='zoneCode']").val(data.zonecode);
                $("input[name='address']").val(data.roadAddress)
                //roadAddress 주소
                //zonecode 우편번호
            }
        }).open();
    })

    $("#idCheck").on("click",idCheck);

    function idCheck(){
        let id = $("input[name='id']").val();
        let check = false;
        let text = "사용 불가능한 아이디입니다.";
        $.ajax({
            url:"/member/check",
            type:"POST",
            data:JSON.stringify({
                id: id,
            }),
            dataType : "json",
            contentType: 'application/json',
            success:function(data){
                    check= data;
                    if(check){
                    text = "사용 가능한 아이디입니다."
                    }
                $("#checkResult").text(text);
            },
        })


        return check;
    }

});
