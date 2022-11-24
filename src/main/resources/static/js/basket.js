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

