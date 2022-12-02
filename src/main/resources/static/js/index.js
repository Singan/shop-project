
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
    let price_num = parseInt(price.text());
    let dis_price = $(".discount_price");
    let dis_priceInt = parseInt($(".discount_price").text());
    dis_price.text(dis_priceInt + '원');
    price.each(function (index, item) {
	    $(this).attr('id', index);
	});

	for(let i = 0; i <= price.length - 1; i++){
		if(!dis_price[i]){
			$('#' + i).css({
				'text-decoration' : 'line-through',
				'font-size' : '1.0em',
				'color' : '#e9e9e9'
			});
		}
	}
   
});
