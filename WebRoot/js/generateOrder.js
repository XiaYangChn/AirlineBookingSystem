
window.onload = function(){ 
	var timeAreas = document.querySelectorAll('.gf_info_time');

	for (var i = timeAreas.length - 1; i >= 0; i--) {
		var times = timeAreas[i].querySelectorAll('.gfi_time'); 	
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
		timeAreas[i].querySelector('.gfi_costTime').innerHTML = h + "h" + m + "m";
	}
}