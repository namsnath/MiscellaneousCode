<?php 
	include "data_gen.php";

	$data[$_POST["day"]][0] = $_POST["starter"];
	$data[$_POST["day"]][1] = $_POST["main"];
	$data[$_POST["day"]][2] = $_POST["dessert"];

	$strData = array();
	$dayData = array();

	foreach($days as $day) {
		$dayData[$day] = $day . ":!:" . implode(":!:", $data[$day]);
	}


	$fileData = implode("\n", $dayData);
	echo $fileData;


	// unlink('food.txt');
	$fileW = fopen("food.txt", "w+");
	if($fileW)
		fwrite($fileW, $fileData);
		
	header('Location: /IWP-Ass5/food_menu.php');	
?>