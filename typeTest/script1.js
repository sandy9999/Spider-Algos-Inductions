

function showthetime(){
	var timer = document.getElementById("timer");
	var textbox = document.getElementById("textbox");
	var speed = document.getElementById("speed");
	var time = 60;
	var texts = document.getElementById("texts");
	var words;
	function countwords(s)
	{
		return s.split(" ").length;
	}
	//alert("hello");
	var showtime = setInterval(function(){
	time--;
	//document.write(String(time));
	timer.innerHTML = String(time) + " seconds";
	//document.write(texts);
	if(!texts.startsWith(textbox.value))
		windows.alert("Hey! You've typed wrong stuff. Hereafter your words won't be counted.");
	words = countwords(textbox.value);
	if(texts==textbox.value)
	{
		clearInterval(showtime);
		speed.innerHTML = "Your speed: " + words / (60 - time) + " per minute";
	}
	else if(time==0)
	{
		clearInterval(showtime);
		speed.innerHTML = "Your speed: " + words / (60 - time) + " per minute";
	}
	
},1000);

}

var load = function()
{
	timer.innerHTML = "60 seconds";
	showthetime();
};