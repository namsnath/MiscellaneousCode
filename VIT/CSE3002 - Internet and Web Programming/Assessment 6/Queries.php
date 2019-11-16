<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}
	echo

	$queryString = "SELECT name FROM movies WHERE name LIKE '%space%';";
	$result = $conn->query($queryString);

	while($row = mysqli_fetch_array($result)) print_r($row[0]."<br>");
?>