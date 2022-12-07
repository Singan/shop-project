$(document).ready(function() {
	let plus = $(".plus");
    let minus = $(".minus");
    let count = 0;
    let in_val = 1;
    let btn;
    let number;
    let num;
	let id = 1;
	let allCheck = $("input[name=all_checkbox_button]");
	let checks = $("input[name=checkbox_button]");
	let amount = $(".number");
	let prices = $(".price > p");
	let total = $(".totalPrice > p");
	let sum = 0;
    for(let i = 0;i <= plus.length; i++){
    	$(plus[i]).attr("id", "p"+count);
    	$(minus[i]).attr("id", "m"+count);
    	$(checks[i]).attr("id", count);
    	$(amount[i]).attr("id", "amount_"+count);

    	count += 1;
    }
    plus.click(function(event) {
    	let col = String(plus.index(this));
    	let price_ind = $('.price > p').index();
    	let pri = parseInt($('#price_' + col).text());
    	btn = event.target.id;
    	
    	number = $("#"+btn).next();
    	num = parseInt(number.val());
    	num += 1;
        number.val(num);
        sum = sum + pri;
        total.text(sum);
    });
    minus.click(function(event) {
    	let col = String(minus.index(this));
    	let pri = parseInt($('#price_' + col).text());
    	btn = event.target.id;
    	number = $("#"+btn).prev();
    	num = parseInt(number.val());
    	let price_ind = $('.price > p').index();
		if(num > 1){
            num -= 1;
            number.val(num);
            sum = sum - pri;
        total.text(sum);
        }else{
            num = 1;

        }
    });

    

	
 	
 	$(".price > p")
	    .attr("id", function(arr){
	    	return "price_" + arr;
	    })
	    .each(function(){
	    	console.log(this);
	    	$("p", this).attr("id", this.id);
	    	
		});
	  
	  
	 

	allCheck.click(function() {
		
		if(allCheck.is(":checked")){
			checks.prop("checked", true);
			totalPrice();
		} 
		else{
			checks.prop("checked", false);
			sum = 0;
			total.text(sum);
		} 
	});

	checks.click(function() {
		var total = checks.length;
		var checked = $("input[name=checkbox_button]:checked").length;

		if(total != checked){
			allCheck.prop("checked", false);
		} 
		else{
			allCheck.prop("checked", true);	
		}  
	});

	
	
	function totalPrice(){
		for(var i = 0; i <= prices.length; i++){
			let a = $("#price_"+i).text();
			let amo = $("#amount_"+i).val();
			let b = parseInt(a);
			let num = parseInt(amo);
			sum = isNaN(b) ? sum : sum + (b * num);
		}

		total.text(sum);
	}
	totalPrice();

	checks.click(function(e){
		let notCheck = $("#"+e.target.id);
		let minPrice = $("#price_" + e.target.id).text();
		let amo = $("#amount_" + e.target.id).val();
		let num = parseInt(amo)
		let a = parseInt(minPrice);
		if(!notCheck.is(':checked')){
			sum = isNaN(a) ? sum : sum - (a * num);
		}else if(notCheck.is(':checked')){
			sum = isNaN(a) ? sum : sum + (a * num);
		}
		console.log(num);
		console.log(e.target.id);
		total.text(sum);
	});
	$('input[name="checkbox_button"]').each(function() {
		console.log(this);
	    this.checked = true; 
 	});

});

