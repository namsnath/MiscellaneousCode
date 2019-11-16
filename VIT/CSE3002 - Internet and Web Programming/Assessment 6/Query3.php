<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}

	$queryString = "SELECT CONCAT('', actors.first_name, ' ',  actors.last_name) as actor_name, movies.name, movies.rating
	FROM roles
	JOIN actors ON actors.id = roles.actor_id
	JOIN movies ON movies.id = roles.movie_id
	WHERE movies.rating < 3.0
	GROUP BY actor_name
	HAVING Count(actor_name) >= 2
	ORDER BY actors.last_name, actors.first_name";
	$result = $conn->query($queryString);

	echo 'Write  a  query  that  lists  all  actors  who  was  in  a  movie  rated  lower than 3.0 two or more times. List the name of the actor, the movie and each rating, ordered ascendingby the actors’ last name then first name.<br><br>';
	echo $queryString."<br><br>";

	echo "<table><tr> <th>Actor</th> <th>Movie</th> <th>Rating</th> </tr>";

	while($row = mysqli_fetch_array($result)) 
		echo "<tr> <td>$row[0]</td> <td>$row[1]</td> <td>$row[2]</td> </tr>";
	echo '</table>';	
?>