<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}

	$queryString = "UPDATE movies_genres SET genre='Horror' WHERE genre='Action';";
	$result = $conn->query($queryString);

	echo 'Write update query -update “action”genres into “horror” and display no.of rows affected.<br><br>';
	echo $queryString."<br><br>";

	echo "Affected Rows: " . mysqli_affected_rows($conn);
?>