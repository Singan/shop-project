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
	basketList.map(function(basket){
		htmlString +=
			`<a href="/product/detail?no=${basket.productNo}">
				<div class='col-12 list_contents'>
					<div class="col-2 list_image">
						<img src="data:image/jpeg;base64,${basket.productThumbnail}">
					</div>
					<div class="col-9 list_text">
					<h2>${basket.productName}</h2>
						<p>${basket.productShort}</p>
						<h4 class="list_count_title">수량</h4>
						<h4 class="list_count">${basket.productCount}</h4>
					</div>

				</div>
			</a>`;
	})
	htmlString +=`<div class="col-12 list_more"><button>더보기</button></div>`
	basketlistContent.html(htmlString)
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