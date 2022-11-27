requestBasketList();
function requestBasketList(){
	$.ajax({
			url:"/member/basketList",
			type:"GET",
			dataType : "json",
			contentType: 'application/json',
			success:(data)=>{
			console.log("으음")
			console.log(data);
			basketSetting(data);
			}
	})
}
var drop =  $("#basket_dropdown");
function basketSetting(basketList){
	var basketlistContent= $("#basketlist_content");
	var htmlString = "";
	var totalPrice = 0;
	basketList.map(function(basket){
	    totalPrice += basket.productPrice *basket.productCount;
		htmlString +=
			`<div class='col-12 list_contents' >
					<div class="listChoice">
						<input type="checkbox" class='check' id=${basket.productNo} checked>
					</div>
					<div class="col-2 list_image">
						<img src="data:image/jpeg;base64,${basket.productThumbnail}">
					</div>
					<div class="col-7 list_text">
						<a href="/product/detail?no=${basket.productNo}">
					    	<h2>${basket.productName}</h2>
					    </a>
						<p>${basket.productShort}</p>
						<h4 class="list_count_title">수량</h4>
						<input class="list_count" id=count_${basket.productNo} value="${basket.productCount}">
					</div>
					<div class="col-2 listMoney">
                        <h2>가격</h2>
                        <p id=price_${basket.productNo}>${basket.productPrice}</p>
				    </div>
				</div>`;
	})
	htmlString +=`
		<div class="col-12 listTotal"><h1>총가격</h1>
			<h2 id='totalPrice'>${totalPrice}</h2>
		</div>
		<div class="col-12 list_more">
			<button id="order">구매하기</button>
		</div>`
	basketlistContent.html(htmlString)
	$(".check").map(function(index,obj){
        obj.onclick=function(e){
            var id =e.target.id;
            var price = Number($("#price_"+id).text());
            var count = Number($("#count_"+id).text());
            var totalPrice = Number($("#totalPrice").text());

            if(!obj.checked){
                console.log("체크해제")
                totalPrice= totalPrice-price*count;
                console.log(totalPrice)

            }else{
                console.log("체크")
                console.log(price)
                console.log(count)
                totalPrice= totalPrice+price*count;
                console.log(totalPrice)
            }
            $("#totalPrice").html(totalPrice)
        }
    })
	$("#order").on("click",order);
}

function order(){
	console.log("구매하기 클릭")
	let link = "/product/order?";
	let c = 0;
	$(".check").map(function(index,obj){
		if(obj.checked){
			let count = Number($("#count_"+obj.id).text());
			if(count>0){
			if(c>0){
				link+="&"
			}
			link+="no="+obj.id+"&count="+count;

			c++;
			}
		}
	})
	location.href= link;

}

//
// < div
// className = "col-12 list_contents" >
// 	< div
// className = "col-2 list_image" >
// 	< img
// src = "" >
// 	< /div>
// <div className="col-9 list_text">
// 	<h2>제품명</h2>
// 	<p>이것은 엄청난 제품 이것은 엄청난 제품</p>
// </div>
// </div>
