function func(form) {
	//alert("hihgh");
	var fname = form.fname.value;
	var lname = form.lname.value;
	var phone = form.phone.value;
	var email = form.email.value;
	var pass = form.pass.value;
	var cpass = form.cpass.value;
	
	var checkfname=checking_Name(fname);
	alert(checkfname);
	/*if(!checkfname){
		alert("Name cannot be numeric.");
		return false;
	}*/
	
/*	
	var checklname=checking_Name(lname);
	
	
	if (pass != cpass) {
		alert('Enter Correct Password!');
	}*/
	
	
	
}

function checking_Name(name)
{

	return fname.match("\\[a-zA-Z]+\\");
}