<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}

	$queryString = "SELECT actors.first_name, actors.last_name, movies.name, movies.year 
	FROM actors
	JOIN roles ON actors.id = roles.actor_id
	JOIN movies ON movies.id = roles.movie_id
	WHERE movies.year > 1989 AND movies.year < 2000 AND actors.gender='Female'";
	$result = $conn->query($queryString);

	echo 'Write a query that lists the female actors who appeared in a movie during the 90s (1990-1999) that was rated higher than 8.5.<br><br>';
	echo $queryString."<br><br>";

	echo "<table><tr> <th>Actor</th> <th>Movie</th> <th>Year</th> </tr>";

	while($row = mysqli_fetch_array($result)) 
		echo "<tr> <td>$row[0] $row[1]</td> <td>$row[2]</td> <td>$row[3]</td> </tr>";
	echo '</table>';	
?>