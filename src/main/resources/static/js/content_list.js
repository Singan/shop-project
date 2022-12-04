const Time = 400;
let count = 0;

$(document).ready(function() {

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
    

    let dis = $('.discount');
    let discount = parseInt(dis.text());
    for(let i = 0; i <= dis.length ; i++){
        console.log(i);
        if(discount[i] == 0){
            console.log('22');
            $(dis[i]).css('display','none');
        }
    }
    if(localStorage.getItem('1')){
		var lastData = localStorage.getItem('1');
		console.log(lastData);
	}  	
});

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
            console.log(data);

            data.map((product)=>{
                str =str+`
                <div class="col-3 content">
                    <a href="/product/detail?no=${product.productNo}">
                        <img src="data:image/jpeg;base64,${product.productThumbnail}"/>
                        <p>${product.productName}</p>
                        <h2 class="price">${product.productPrice} 원</h2>
                        <h2 class="discount">${product.productDiscount}</h2>
                    </a>
                </div>`
            })
            $(".content_main").append(str);
   	    }
    })
}

$(document).ready(function(){
    $(function() {

        var didScroll = false;
            
        $(window).on('scroll', function() { didScroll = true; });
        
        setInterval(function() {
            var bottomHeight = $(window).scrollTop() + $(window).height() + 600;
            var docHeight = $(document).height();
            if (didScroll) {
                didScroll = false;
                if (bottomHeight > docHeight){
                    getContentList();
                }
            }
        }, 250);
        

        
    });    
});

$( document ).ready( function() {
    $( window ).scroll( function() {
        if ( $( this ).scrollTop() > 200 ) {
            $( '.top' ).fadeIn();
        } else {
            $( '.top' ).fadeOut();
        }
    } );
    $( '.top' ).click( function() {
        $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
        return false;
    } );
} );

$(window).on('load', function(){

});
