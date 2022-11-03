var login = false;
$.ready($.ajax({
       			url:"/loginCheck",
       			type:"GET",
       			dataType : "json",
       			contentType: 'application/json',
       			success:(data)=>{
       			console.log(data);
                    if(data){
                        console.log('왜안됨?')
                        login = true;
                    }else{
                        login=false;
                    }
                    console.log('확인?')
                    var headerString = `					<li><a href="#">공지사항</a></li>
                                        					<li><a href="#">장바구니</a></li>
                                        					<li><a href="#">주문정보</a></li>
                    `
                    if(login == false){
                        headerString +=`                    					<li><a href="/login">로그인</a></li>
                                                            					<li><a href="/member/join">회원가입</a></li>`
                    }else{
                        headerString +="<li><a href='/mypage'>마이페이지</a></li><li><a href='/logout'>로그아웃</a></li>"
                    }
                    console.log("login +" + login)
       			},
  })
)