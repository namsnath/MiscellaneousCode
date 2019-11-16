<?php 
	$file = fopen("food.txt", "r") or die("Could not open file.");
	$days = array("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY");

	$data = array();

	while(!feof($file)) {
		$line = fgets($file);
		$lineData = explode(":!:", $line);
		
		if($lineData[0] != "")
			$data[$lineData[0]] = array_slice($lineData, 1);
	}
	fclose($file);
?>	