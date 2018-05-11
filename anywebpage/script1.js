function calculate()
{
	var height = parseFloat(document.getElementById("height").value);
	var weight = parseFloat(document.getElementById("weight").value);
	var bleh = document.getElementById("bleh");
	
	//document.write(String(height));
	//document.write(String(weight));
	var bmi = (weight/(height*height))*(10000.00);
	bmi = Math.round(bmi*100) / 100;
	bleh.innerHTML = "Your BMI is: \n " + String(bmi);
	
}