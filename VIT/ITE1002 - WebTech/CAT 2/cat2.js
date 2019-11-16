var words = ['i', 'like', 'sam', 'sung', 'samsung', 'mobile', 'ice', 'cream', 'icecream', 'man', 'go', 'mango'];
words = words.sort(compareLen);
words = words.reverse();

function compareLen(a, b) {
	if(a.length > b.length)
		return 1;
	else if(a.length == b.length)
		return 0;
	return -1;
}

console.log(words);

function doSplit(input) {
	var str = input;
	var arr = [];
	var finalStr = "";
	var strArr = [];

	for(var i = 0; i < words.length; i++) {
		arr = str.split(words[i]);

		for(var j = 0; j < arr.length; j++)
			if(words.includes(arr[j]))
				str = arr.join(" " + words[i] + " ");

		if(!strArr.includes(str) && str != input) 
			strArr.push(str);
		
		finalStr = str;
	}

	console.log(strArr);
	finalStr = strArr.join("<br>");

	if(strArr.length == 0)
		finalStr = "Invalid words in the string";

	$('#result').html(finalStr);
	$('#result').animate("slideDown", 4000);
}

function doThatThingy() {
	var inp = $('#inputText').val();
	doSplit(inp);
	// doSplit("ilike");
}

$(document).ready(function() {
	$('#submit').click(doThatThingy);
});