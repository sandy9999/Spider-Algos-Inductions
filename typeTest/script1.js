var timer = document.getElementById("timer");
var textbox = document.getElementById("textbox");
var speed = document.getElementById("speed");
var time = 60;
var text = "She is a person. She lives in a place. She goes to a school";

var showtime = setInterval(function(){
	time--;
	timer.innerHTML = time + " seconds";
	
	if(time==0)
	{
		clearInterval(showtime);
		speed.innerHTML = "Your speed: " + 14 / (60 - time) + " per minute";
	}
});

function checkwrongword()
{
	if(!text.startsWith(textbox.value))
		var 
}
