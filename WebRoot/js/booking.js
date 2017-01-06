var itemID = 1;		 // 用作 item 排序id

window.onload = function(){ 
	var timeAreas = document.querySelectorAll('.bo_info_timeArea');

	for (var i = timeAreas.length - 1; i >= 0; i--) {
		var times = timeAreas[i].querySelectorAll('.bo_info_time'); 	
		var time1 = /(\d+)\:(\d+)/g.exec(times[0].innerHTML)[0];
		var time2 = /(\d+)\:(\d+)/g.exec(times[1].innerHTML)[0];

		var h1 =  Number(/(\d+)/g.exec(time1)[0]);
		var h2 =  Number(/(\d+)/g.exec(time2)[0]);
		var m1 =  Number(/(\d+)/g.exec(/\:(\d+)/g.exec(time1)[0])[0]);
		var m2 =  Number(/(\d+)/g.exec(/\:(\d+)/g.exec(time2)[0])[0]);
		var h = h2 - h1;
		var m = m2 - m1;
		if(m < 0){
			m += 60;
			h--;
		}
		if(h < 0){
			h += 24;
		}
		timeAreas[i].querySelector('.bo_info_costTime').innerHTML = h + "h" + m + "m";
	}
}

function addItem(){
	var tmp = document.querySelector('#b_formItem').querySelector('div');
	var item = tmp.cloneNode(true);

	item.querySelector('span').innerHTML = ++itemID;

	var radioBut = item.querySelector('.bf_item_seatType').querySelectorAll('input'); 
	for(var i = 0; i < radioBut.length; i++){
		radioBut[i].name = 'seatType' + itemID.toString();
	}

	document.getElementById("b_formItem_container").appendChild(item);
	updateNum();
}

function deleteItem(element){
	if(itemID > 1){
		var itemNode = element.parentNode.parentNode.parentNode;
		var parent = itemNode.parentNode;

		parent.removeChild(itemNode);

		itemID--;

		var childs = parent.querySelectorAll('.b_form_item'); 
		for(var i = 0; i < childs.length; i++){
			childs[i].querySelector('span').innerHTML = i + 1;

			var radioBut = childs[i].querySelector('.bf_item_seatType').querySelectorAll('input'); 
			for(var j = 0; j < radioBut.length; j++){
				radioBut[j].name = 'seatType' + (i + 1).toString();
			}
		}
		updateNum();
	}
}

function updateNum(){
	var nodes = document.querySelectorAll('.bo_detail_num');
	for (var i = nodes.length - 1; i >= 0; i--) {
		nodes[i].innerHTML = itemID;
	}

	var fares = document.querySelectorAll('.bo_detail_fare');
	var sum = 0;
	for (var i = fares.length - 1; i >= 0; i--) {
		sum += Number(fares[i].innerHTML);
	}

	var totalFare = document.getElementById("o_totalFare");
	totalFare.innerHTML = sum * itemID;

}


function textOnFocus(element){
	element.parentNode.style.borderColor = '#5D9DE5';
}

function textOnBlur(element){
	element.parentNode.style.borderColor = '#CCCCCC';
}
