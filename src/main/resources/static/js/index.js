
$(document).ready(function(){
	$(function() {

	    var didScroll = false;
			
	    $(window).on('scroll', function() { didScroll = true; });
	    
	    setInterval(function() {
	        var bottomHeight = $(window).scrollTop() + $(window).height() + 600;
	        var docHeight = $(document).height();

	        if (didScroll) {
	            didScroll = false;
	            if (bottomHeight > docHeight) infiniteScrollContent();
	        }
	    }, 250);
	    
	    function infiniteScrollContent() {
	      
	        var scrollcon = '';
	        for (var i = 0; i < 12; i++) {
	            scrollcon += 
	            	`<div class="col-12">
	            		<p>asdasdasd</p>
	            		<p>asdasdasd</p>
	            	</div>`;
	        }			
	        $("#content_main").append(scrollcon);
	    }
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

$(window).on('load',function(){
    let price = $(".price");
    let dis_price = $(".discount_price");
    let dis_priceInt = parseInt($(".discount_price").text());
    let dis = $('.discount');
    let count = $('.content').length;
    
    for(let i = 0; i <= count - 1; i++){
    	let discount = parseInt($(dis[i]).text());
    	price[i].attr('id', 'dis_' + i);
    	console.log(discount);
    	if(discount[i] > 0){
	        price[i].css('text-decoration' , 'line-through');
	        price[i].css('color' , '#e9e9e9');
	        dis[i].css('display' , 'block');
	        dis_price[i].css('display' , 'block');
	        $(".discount_price").text(dis_priceInt);
	        $(dis_price[i].text(dis_priceInt[i] + '원'));
	    }else if(discount[i] <= 0){
	        dis[i].css('display' , 'none');
	        dis_price[i].css('display' , 'none');
	    }
    }
    
});
