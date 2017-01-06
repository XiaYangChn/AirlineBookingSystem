
window.onload = function(){ 
	initDate();
}

function initDate(){
	document.getElementById('dDate').valueAsDate = new Date();
//	document.getElementById('aDate').valueAsDate = new Date();
}

function radioButClick(element){
	if(element.value=="oneWay"){
		document.getElementById("s_returnDate").disabled=true;
	}else{
		document.getElementById("s_returnDate").disabled=false;
	}
}