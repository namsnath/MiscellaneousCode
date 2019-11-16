<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}

	$queryString = "SELECT actors.first_name, actors.last_name, movies.name, movies_genres.genre
	FROM actors
		LEFT JOIN roles
			ON roles.actor_id = actors.id
		LEFT JOIN movies
			ON movies.id = roles.movie_id
		LEFT JOIN movies_genres
			ON movies_genres.movie_id = movies.id
	WHERE actors.id IN (
		SELECT actors.id 
			FROM actors 
			LEFT JOIN roles ON roles.actor_id = actors.id 
			LEFT JOIN movies ON movies.id = roles.movie_id 
			LEFT JOIN movies_genres ON movies_genres.movie_id = movies.id 
			GROUP BY actors.id
			HAVING COUNT(movies_genres.genre) > 1
		);";
	$result = $conn->query($queryString);

	echo 'Write  a  query  that  lists  all  actors  who  have  been  in  two  or  more movies of different genres. List their name, movie and their respective genres.<br><br>';
	echo $queryString."<br><br>";

	echo "<table><tr> <th>Actor</th> <th>Movie</th> <th>Genre</th> </tr>";

	while($row = mysqli_fetch_array($result)) 
		echo "<tr> <td>$row[0] $row[1]</td> <td>$row[2]</td> <td>$row[3]</td> </tr>";
	echo '</table>';	
?>