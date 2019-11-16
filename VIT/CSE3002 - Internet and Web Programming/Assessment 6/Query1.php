<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}

	$queryString = "SELECT name FROM movies WHERE name LIKE '%space%' ORDER BY rating DESC;";
	$result = $conn->query($queryString);

	echo 'Write a query that lists the names of the movies whose title contains the word “space” in descending order by rank.<br><br>';
	echo $queryString."<br><br>";

	while($row = mysqli_fetch_array($result)) print_r($row[0]."<br>");
?>