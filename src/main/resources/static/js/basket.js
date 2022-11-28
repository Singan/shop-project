function count(type)  {
	
	  const resultElement = document.getElementById('result');
	  
	  let number = resultElement.innerText;
	  let min_minus = document.getElementsByName("min")[0];
		
	  if(type === 'plus') {
	    number = parseInt(number) + 1;
	  	min_minus.removeAttribute('disabled');
	  
	  }else if(type === 'minus')  {
	  	if (number <= 1) {
	  		alert("더이상 내릴 수 없습니다.");
	  		number = 1;
	  		min_minus.setAttribute('disabled', true);

	  	}else{
	  		number = parseInt(number) - 1;
	  		min_minus.removeAttribute('disabled');
	  	}
	   
	  }
	  resultElement.innerText = number;
}

$(document).ready(function(){
	let id = 1;
	let allCheck = $("input[name=all_checkbox_button]");
	let checks = $("input[name=checkbox_button]");

	$('input[name="checkbox_button"]').each(function() {
		console.log(this);
	    this.checked = true; 
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
		} 
		else{
			checks.prop("checked", false);
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

	let prices = $(".price > p");
	let total = $(".totalPrice > p");
	let sum = 0;

	for(var i = 0; i <= prices.length; i++){
		let a = $("#price_"+i).text();
		let b = parseInt(a);
		sum = isNaN(b) ? sum : sum + b;
	}

	console.log(sum);
	total.text(sum + "원");
	
});



$(document).ready(function() {
	let plus = $(".plus")
    let minus = $(".minus")
    let count = 1;
    let in_val = 1;
    let btn;
    let number;
    let num;

    for(let i = 0;i <= plus.length; i++){
    	$(plus[i]).attr("id", "p"+count);
    	$(minus[i]).attr("id", "m"+count);
    	count += 1;
    }
    plus.click(function(event) {
    	let btn = event.target.id;
    	let number = $("#"+btn).next();
    	let num = parseInt(number.val());
    	num += 1;
        number.val(num);
    });
    minus.click(function(event) {
    	btn = event.target.id;
    	number = $("#"+btn).prev();
    	num = parseInt(number.val());

		if(num > 1){
            num -= 1;
            number.val(num);
        }else{
            num = 1;

        }
    });
});

