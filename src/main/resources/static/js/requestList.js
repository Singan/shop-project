requestBasketList();
console.log("으으으으")
var basketList = 0;
function requestBasketList(){
	$.ajax({
			url:"/member/basketList",
			type:"GET",
			dataType : "json",
			contentType: 'application/json',
			success:(data)=>{
			console.log("으음")
			console.log(data);
			basketList = data;
			}
	})
}