/*
$(document).ready(function(){
	$(function() {

		// 스크롤 감지
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
	        for (var k = 0; k < 6; k++) {
	            scrollcon += 
	            	`<div class="col-3 content" th:each="product : ${productList}">
						<a th:href="@{/product/detail(no=${product.getProductNo()})}">
							<img th:src="'data:image/jpeg;base64,'+${product.getProductThumbnail()}"
								 th:if="${product.getProductThumbnail()!= null}">
							<p th:text="${product.getProductName()}"></p>
							<h2 th:text="${product.getProductPrice()} +' 원'"></h2>
						</a>
					</div>`;
	        }			
	        $("#content_main").append(scrollcon);
	    }
	});	

});

*/