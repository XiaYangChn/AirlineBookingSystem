
window.onload = function(){ 
	initDate();
}

function initDate(){
	document.getElementById('dDate').valueAsDate = new Date();
//	document.getElementById('aDate').valueAsDate = new Date();
}

function InitSelect(deparureCity, arrivalCity){
	var departureSelect = document.getElementById("departureSelect").options;
	var arrivalSelect = document.getElementById("arrivalSelect").options ;

	for (var i = departureSelect.length - 1; i >= 0; i--) {
		if(departureSelect[i].value == deparureCity){
			departureSelect[i].selected = true; 
			break;
		}
	}

	for (var i = arrivalSelect.length - 1; i >= 0; i--) {
		if(arrivalSelect[i].value == arrivalCity){
			arrivalSelect[i].selected = true; 
			break;
		}
	}
}

function textOnFocus(element){
	element.parentNode.style.borderColor = '#5D9DE5';
}

function textOnBlur(element){
	element.parentNode.style.borderColor = '#CCCCCC';
}

function changeSortType(labelID){
	for(var i = 1; i <= 3; i++){
		var id = "r_label_" + i;
		
		if(labelID != id){
			var e = document.getElementById(id);
			e.style.color = "black";

			var sortIcon = e.querySelectorAll("img");
			sortIcon[0].src="images/icon_up_gray.png";
			sortIcon[1].src="images/icon_down_gray.png";
		}
	}

	var element = document.getElementById(labelID);

	element.style.color = "#0066CC";
	var sortIcon = element.querySelectorAll("img");

	var imgRegExp = /\/([^\/]*?\.png)/i;

	var a = imgRegExp.exec(sortIcon[0].src)[1];
	var b = imgRegExp.exec("images/icon_up_blue.png")[1];

	if(a == b){	//	逆序
		sortIcon[0].src="images/icon_up_gray.png";
		sortIcon[1].src="images/icon_down_blue.png";
		
		if(labelID=="r_label_1"){
			sortByDepatureTime("down");
		}
		if(labelID=="r_label_2"){
			sortByArrivalTime("down");		
		}
		if(labelID=="r_label_3"){
			sortByFare("down");
		}
	}else{		//	顺序
		sortIcon[0].src="images/icon_up_blue.png";
		sortIcon[1].src="images/icon_down_gray.png";
		
		if(labelID=="r_label_1"){
			sortByDepatureTime("up");
		}
		if(labelID=="r_label_2"){
			sortByArrivalTime("up");		
		}
		if(labelID=="r_label_3"){
			sortByFare("up");
		}
	}
}

function selectChange(element){
	if(element.value=="oneWay"){
		document.getElementById("s_returnDate").disabled=true;
	}else{
		document.getElementById("s_returnDate").disabled=false;
	}
}


function sortByDepatureTime(sortType){
	var itemContainer = document.getElementById("tripItemContainer");
	var items = document.querySelectorAll(".tripItem");
	var tripItems = new Array(items.length);
	
	if(sortType=="up"){
		for (var i =  0; i < items.length ; i++) {
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);		
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) { 		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {	
				var weight_1 = tripItems[j].querySelector('.r_departureTime').innerHTML;
				var weight_2 = tripItems[j + 1].querySelector('.r_departureTime').innerHTML;

				weight_1 = /(\d+)\:(\d+)/g.exec(weight_1)[0];
				weight_2 = /(\d+)\:(\d+)/g.exec(weight_2)[0];

				var time_1 = new Date("1900/1/1 " + weight_1);
				var time_2 = new Date("1900/1/1 " + weight_2);
																
				if(time_1 > time_2){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}else{
		for (var i =  0; i < items.length ; i++) { 
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) {		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {
				var weight_1 = tripItems[j].querySelector('.r_departureTime').innerHTML;	
				var weight_2 = tripItems[j + 1].querySelector('.r_departureTime').innerHTML;

				weight_1 = /(\d+)\:(\d+)/g.exec(weight_1)[0];
				weight_2 = /(\d+)\:(\d+)/g.exec(weight_2)[0];

				var time_1 = new Date("1900/1/1 " + weight_1);
				var time_2 = new Date("1900/1/1 " + weight_2);
																
				if(time_1 < time_2){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}
}


function sortByArrivalTime(sortType){
	var itemContainer = document.getElementById("tripItemContainer");
	var items = document.querySelectorAll(".tripItem");
	var tripItems = new Array(items.length);
	
	if(sortType=="up"){
		for (var i =  0; i < items.length ; i++) {
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);		
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) { 		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {	
				var weight_1 = tripItems[j].querySelector('.r_destinationTime').innerHTML;
				var weight_2 = tripItems[j + 1].querySelector('.r_destinationTime').innerHTML;

				weight_1 = /(\d+)\:(\d+)/g.exec(weight_1)[0];
				weight_2 = /(\d+)\:(\d+)/g.exec(weight_2)[0];

				var time_1 = new Date("1900/1/1 " + weight_1);
				var time_2 = new Date("1900/1/1 " + weight_2);
																
				if(time_1 > time_2){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}else{
		for (var i =  0; i < items.length ; i++) { 
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) {		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {
				var weight_1 = tripItems[j].querySelector('.r_destinationTime').innerHTML;	
				var weight_2 = tripItems[j + 1].querySelector('.r_destinationTime').innerHTML;

				weight_1 = /(\d+)\:(\d+)/g.exec(weight_1)[0];
				weight_2 = /(\d+)\:(\d+)/g.exec(weight_2)[0];

				var time_1 = new Date("1900/1/1 " + weight_1);
				var time_2 = new Date("1900/1/1 " + weight_2);
																
				if(time_1 < time_2){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}
}

function sortByFare(sortType){
	var itemContainer = document.getElementById("tripItemContainer");
	var items = document.querySelectorAll(".tripItem");
	var tripItems = new Array(items.length);
	
	if(sortType=="up"){
		for (var i =  0; i < items.length ; i++) {
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);		
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) { 		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {	
				var weight_1 = tripItems[j].querySelector('.r_price').querySelector('span').innerHTML;	
				var weight_2 = tripItems[j + 1].querySelector('.r_price').querySelector('span').innerHTML;
													
				weight_1 = /(\d+)/g.exec(weight_1)[0];	
				weight_2 = /(\d+)/g.exec(weight_2)[0];		

				if(Number(weight_1) > Number(weight_2)){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}else{
		for (var i =  0; i < items.length ; i++) { 
			tripItems[i] = items[i].cloneNode(true);
			itemContainer.removeChild(items[i]);
		}

		for (var i =  0; i < tripItems.length - 1 ; i++) {		
			for (var j =  0; j < tripItems.length - 1 - i ; j++) {
				var weight_1 = tripItems[j].querySelector('.r_price').querySelector('span').innerHTML;	
				var weight_2 = tripItems[j + 1].querySelector('.r_price').querySelector('span').innerHTML;
				
				weight_1 = /(\d+)/g.exec(weight_1)[0];	
				weight_2 = /(\d+)/g.exec(weight_2)[0];	

				if(Number(weight_1) < Number(weight_2)){
					var tmp = tripItems[j];
					tripItems[j] = tripItems[j + 1];
					tripItems[j + 1] = tmp;
				}
			}
		}

		for (var i =  0; i < tripItems.length ; i++) {
			itemContainer.appendChild(tripItems[i]);
		}
	}
}
