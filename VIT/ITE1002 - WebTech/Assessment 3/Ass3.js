var nameField = document.getElementById('name');
var dateField = document.getElementById('dateField');
var res = document.getElementById('result');

name.onblur = doCheck;
dateField.onblur = doCheck;

function doCheck() {
	var nameVal = nameField.value;
	var dateVal = dateField.value;
	var dateElems = dateVal.split("-");
	var sum = parseInt(dateElems[1]) + parseInt(dateElems[2]) + parseInt(dateElems[0].substring(2));

	if(sum < 65 || (sum > 90 && sum < 97))
		sum += 32;
	if(sum > 122)
		sum -= 32;

	if(((sum >= 65 && sum <= 90) || (sum >= 97 && sum <= 122)) && sum == nameVal.charCodeAt(0))
		res.innerHTML = "Numerological match.";
	else
		res.innerHTML = "Nope, not a match.";
}