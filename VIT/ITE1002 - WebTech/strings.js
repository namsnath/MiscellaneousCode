var name = "N. Nathwani";
var nameCheck = /^[A-Z]\. [A-Z][a-z]{2,}$/;
var punc = /\W+/;

window.onload = function() {
	document.getElementById('nameField').onkeyup = checkMagic;
}

function addDigits(n) {
	if(n <= 0) return 0;
	return (n % 10) + addDigits(Math.trunc(n/10));
}

function sumASCII(str) {
	var sum = 0
	for(var i = 0; i < str.length; i++)
		sum += str.charCodeAt(i);
	return sum;
}

function checkMagic() {
	var name = document.getElementById('nameField').value;
	if(nameCheck.test(name)) {
		// console.log(str);
		var str = name.split(punc).join("");
		// console.log(str);

		var sum = sumASCII(str);
		// console.log(sum);

		while(sum >= 10) {
			sum = addDigits(sum);
			// console.log(sum);
		}

		if(sum == 1) console.log(`${name} - It's magic, It's magic`);
		else console.log(`${name} - Na Na Na`);
	} else console.log(`${name} = Invalid String`);
}