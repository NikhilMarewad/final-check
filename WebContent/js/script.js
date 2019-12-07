// Include form validation functions here
function validateForm(){
	
	var txt=document.forms["myForm"]["name1"].value;
	var no=document.forms["myForm"]["number1"].value;
	var dor=document.forms["myForm"]["dates1"].value;
	if (txt == "") {
	    alert("Title must be filled out");
        return false;		
	 } else if (no == "") {
	    alert("Number must be filled out");
		return false;
	 } else if (dor == "") {
	    alert("Date must be filled out");
		return false;
	 } else {
		return true;
	 }
	
	
}