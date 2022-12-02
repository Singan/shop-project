

function check(){
	const emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; // 
	const passwordRegex = /^[A-Za-z0-9]{6,18}$/; //대,소문자 + 숫자 6자리부터 18자리
	const idRegx = /^[a-z]+[a-z0-9]{5,16}$/g; // 소문자, 숫자 5자리부터 19자리까지
	const nameRegx = /[ㄱ-힣]/; // 한글만 가능

	let id = $("input[name='id']");
	let pwd = $("input[name='pwd']");
	let address = $("input[name='address']");
	let email = $("input[name='email']");
	let name = $("input[name='name']");
	let repwd = $("input[name='pwd_confirm']");
	let email_add = $("#sign_up_email option:selected");

	let email_check = emailRegex.test(email.val() + "@" + email_add.val());
	let pwd_check = passwordRegex.test(pwd.val());
	let id_check = idRegx.test(id.val());
	let name_check = nameRegx.test(name.val());
	

	if(id.val() == ""){
        alert("아이디를 입력해주세요.");
        return;
    }
    if(!id_check){
        alert("아이디 형식을 맞춰주세요..");
        return;
    }


    if(!name_check){
    	alert("형식에 맞춰 작성해주세요.");
    	name.focus();
    	console.log(name_check);
    	console.log(nameRegx.test(name));
    	return;
    }

    if(!pwd_check) {
      alert("형식에 맞춰서 비밀번호를 입력해주세요.");
      pwd.focus();
      return;
    }


    if(email.val() == ""){
        alert("이메일을 입력해주세요");
        email.focus();
        return;
    }

    if(!email_check){
        alert("이메일형식에 맞게 입력해주세요")
        email.focus();
        return;
    }

}


$(document).ready(function(){
	let pwd = $("input[name='pwd']");
	let repwd = $("input[name='pwd_confirm']");
	$(pwd).change(function(){
		$(repwd).change(function(){
			if(pwd.val() != repwd.val()){ 
		   		$("#checkpwd").text("비밀번호가 다릅니다.");

		    }else if(pwd.val() == repwd.val()){
				$("#checkpwd").text("비밀번호가 맞습니다.");
		    }
		});
	});
	$(repwd).change(function(){
		$(pwd).change(function(){
			if(pwd.val() != repwd.val()){ 
		   		$("#checkpwd").text("비밀번호가 다릅니다.");

		    }else if(pwd.val() == repwd.val()){
				$("#checkpwd").text("비밀번호가 맞습니다.");
		    }
		});
	});
});


$(document).ready(function(){

	var submit = $("#submit")
    let idCheckV = false;
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
        check();
        for(let i = 0; i<phoneInput.length;i++){

            phone += phoneInput[i].value ;
            if(i<phoneInput.length-1)
                phone+= "-"
        }
        console.log("아아아")
        if(!idCheckV){
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
                    console.log("아아아")
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
    $("input[name='id']").on("change",function(){
        idCheckV = false;
    })
    function idCheck(){
        let id = $("input[name='id']").val();
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
                    idCheckV= data;
                    if(idCheckV){
                    text = "사용 가능한 아이디입니다."
                    }
                $("#checkResult").text(text);
            },
        })


    }

});
