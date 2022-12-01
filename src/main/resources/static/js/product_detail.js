$(window).on('load',function(){
    let price = $(".price");
    let dis_price = $(".discount_price");
    let dis_priceInt = parseInt($(".discount_price").text());
    let dis = $('.discount');
    let discount = parseInt($(dis).text());
    

    if(discount > 0){
        price.css('text-decoration' , 'line-through');
        price.css('color' , '#e9e9e9');
        dis.css('display' , 'block');
        dis_price.css('display' , 'block');
        $(".discount_price").text(dis_priceInt);
        $(dis_price.text(dis_priceInt + '원'));
    }else if(discount <= 0){
        dis.css('display' , 'none');
        dis_price.css('display' , 'none');
    }
});
