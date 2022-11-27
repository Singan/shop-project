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
	let sum = 0;
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

	let prices = $("price > p").text();
	sum += parseInt(prices);

	console.log(sum);
});


// let count = 1;

// $(document).ready(function() {
// 	let plus = $(".plus");
// 	lie minus = $(".minus");
// 	$(plus).attr('id','appndImage' + count);
// 	count += 1;
// 	$(minus).attr('id','appndImage' + count);
// 	count += 1;
// 	 if($(".plus").length > 0){
        
//     }else{
//         console.log("jquery : 해당 객체 존재안함");
//     }
// });

// $(document).ready(function() {
//     let count = $(".number").val();
//     let num = parseInt(count, 10);
//     let plus = $(".plus");
//     let minus = $(".minus");
//     $(".number").on("propertychange change paste input", function(){
//         num = parseInt($(".number").val(), 10);
//     });
    

//     plus.click(function(){
//         num += 1; 
//         $(".number").val(num);
//     });
//     minus.click(function(){
//        if(num > 1){
//             num -= 1;
//             $(".number").val(num);
//        }else{
//             num = 1;

//        }
//     });
        
// });

