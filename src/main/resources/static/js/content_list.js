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
            if(data.length <= 0){
                return false;
                console.log(data.length);
            }else if(data.length > 0){
                 console.log(data.length);
                data.map((product)=>{
                    str =str+`
                    <div class="col-3 content">
                        <a href="/product/detail?no=${product.productNo}">
                            <img src="data:image/jpeg;base64,${product.productThumbnail}"/>
                            <p>${product.productName}</p>
                            <h2 class="price">${product.productPrice} 원</h2>
                            <h2 class="discount_price"></h2>
                            <h2 class="discount">${product.productDiscount}</h2>
                        </a>
                    </div>`
                })
                $(".content_main").append(str);
            }
            discount();   
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

function discount(){
    let price = $('.price');    
    let dis = $('.discount');
    let discount = parseInt(dis.text());
    let sum2 = parseInt($('.price').text());
    let sum = 1-(discount/100);
    let disprice = sum2 * sum;
    let discount_price = $('.discount_price');
            
    price.each(function(index, item){
        $(this).attr('id', index);
        $(dis[index]).attr('id', 'dis_' + index);
        $(discount_price[index]).attr('id', 'dispri_' + index);
        let a = parseInt($(this).text());
        let b = parseInt($('#dis_' + index).text());
        $('#dispri_' + index).text(a * (1 - (b / 100)) + "원");
        console.log(index);
        if(b > 0){
            $(this).css({
                'text-decoration' : 'line-through',
                'font-size' : '1.0em',
                'color' : '#e9e9e9'
            });
        }else if(b <= 0){
            $('#dispri_' + index).text("");
        }
    });
}

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

