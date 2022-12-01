const Time = 400;
let count = 0;

$(document).ready( function() {

		$("#wishlist").click( function() {
  			if($("#wishlist_content").css("display") == "block"){ 
				$("#wishlist_content").slideUp(Time);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#wishlist_content").css("display") == "none"){
				$("#wishlist_content").slideDown(Time);
				$("#basketlist_content").slideUp(Time);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
				$("#wishlist_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	

		$("#basketlist").click( function() {
  			if($("#basketlist_content").css("display") == "block"){ 
				$("#basketlist_content").slideUp(Time);
				$("#basket_dropdown").css({'transform':'rotate(0deg)'});
			}else if($("#basketlist_content").css("display") == "none"){
				$("#basketlist_content").slideDown(Time);
				$("#wishlist_content").slideUp(Time);
				$("#wishlist_dropdown").css({'transform':'rotate(0deg)'});
				$("#basket_dropdown").css({'transform':'rotate(180deg)'});
			}
		});	

      	getContentList();
    });

      	

    if(localStorage.getItem('1')){
		var lastData = localStorage.getItem('1');
		console.log(lastData);
	}  	
});
>>>>>>> Stashed changes

function getContentList(){
    let category = $("#category").text();
    console.log(category)
    $.ajax({
        				url:"/product/category/get?category="+category+"&pageNo="+count,
        				type:"get",
        				dataType : "json",
        				contentType: 'application/json',
        				success:function(data){
                            count++;
                            let str ="";

                            data.map((product)=>{
                                str =str+`
                                <div class="col-3 content">
                                    <a href="/product/detail?no=${product.productNo}">
                                        <img src="data:image/jpeg;base64,${product.productThumbnail}"/>
                                        <p>${product.productShort}</p>
                                        <h2>${product.productPrice} 원</h2>
                                    </a>
                                </div>`
                            })
                            $(".content_main").append(str);
        				}
    })
}

