const emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const passwordRegex = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/;
const idRegx = /^[a-z]+[a-z0-9]{5,19}$/g;
const nameRegx = /[ㄱ-힣]/;
let a = false;


$("input").on("propertychange change paste input", function() {
	let id = $("input[name='id']").val();
	let pwd = $("input[name='pwd']").val();
	let address = $("input[name='address']").val();
	let email = $("input[name='email']").val();
	let name = $("input[name='name']").val();
	let repwd = $("input[name='pwd_confirm']").val();
	let email_add = $("#sign_up_email option:selected").text();
	
	

	let email_check = emailRegex.test(email + "@" + email_add);
	let pwd_check = passwordRegex.test(pwd);
	let id_check = idRegx.test(id);
	let name_check = nameRegx.test(name);
	
	console.log(name_check);
	console.log(id_check);
	console.log(pwd_check);
	console.log(email_check);

	const isUserValid = (pwd_check && email_check) && (id_check && name_check);
	a = isUserValid;
});

console.log(a);