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