<?php
	$server = "localhost";
	$username = "root";
	$password = "";

	$conn = new mysqli($server, $username, $password, "IMDB");

	if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
	}
	echo "Connected successfully";

	$createQueries = array(
		'CREATE TABLE IF NOT EXISTS actors (id INT PRIMARY KEY, first_name VARCHAR(20), last_name VARCHAR(20), gender VARCHAR(20));',
		'CREATE TABLE IF NOT EXISTS directors (id INT PRIMARY KEY, first_name VARCHAR(20), last_name VARCHAR(20));',
		'CREATE TABLE IF NOT EXISTS directors_genres (id INT PRIMARY KEY, director_id INT, genre VARCHAR(20), prob VARCHAR(20), FOREIGN KEY(director_id) REFERENCES directors(id));',
		'CREATE TABLE IF NOT EXISTS movies (id INT PRIMARY KEY, name VARCHAR(20), year INT, rating DOUBLE(5, 1));',
		'CREATE TABLE IF NOT EXISTS movies_directors (id INT PRIMARY KEY, director_id INT, movie_id INT, FOREIGN KEY(director_id) REFERENCES directors(id), FOREIGN KEY(movie_id) REFERENCES movies(id));',
		'CREATE TABLE IF NOT EXISTS roles (id INT PRIMARY KEY, actor_id INT, movie_id INT, FOREIGN KEY(actor_id) REFERENCES actors(id), FOREIGN KEY(movie_id) REFERENCES movies(id), role VARCHAR(20));',
		'CREATE TABLE IF NOT EXISTS movies_genres (id INT PRIMARY KEY, movie_id INT, genre VARCHAR(20), FOREIGN KEY(movie_id) REFERENCES movies(id));',
	);

	foreach($createQueries as $query) {
		if($conn->query($query)) 
			echo "<br>Created Table";
		else 
			echo "<br>Could not create table";
	}

	$tables = array('actors', 'directors', 'directors_genres', 'movies', 'movies_directors', 'roles', 'movie_genres');
	$data = array(
		'actors' => array(
			array(1, 'John', 'Bellion', 'Male'),
			array(2, 'Billie', 'Eilish', 'Female'),
			array(3, 'John', 'Legend', 'Male'),
			array(4, 'Katy', 'Perry', 'Female'),
		),
		'directors' => array(
			array(1, 'Steven', 'Spielberg'),
			array(2, 'Martin', 'Scorsese'),
			array(3, 'Quentin', 'Tarantino'),
		),
		'directors_genres' => array(
			array(1, 1, 'Thriller', ''),
			array(2, 2, 'Crime', ''),
			array(3, 3, 'Drama', ''),
		),
		'movies' => array(
			array(1, 'SomeMovie1', 1995, 8.6),
			array(2, 'SomeMovie2', 1999, 7.5),
			array(3, 'SomeMovie3', 1993, 9.4),
			array(4, 'SpaceMovie1', 2012, 5.7),
			array(5, 'SpaceMovie2', 2001, 8.3),
			array(6, 'SomeSadMovie1', 2003, 2.7),
			array(7, 'SomeSadMovie2', 2004, 2.8),
		),
		'movies_directors' => array(
			array(1, 1, 1),
			array(2, 2, 2),
			array(3, 3, 3),
			array(4, 1, 4),
			array(5, 2, 5),
			array(6, 3, 6),
			array(7, 1, 7),
		), 
		'roles' => array(
			array(1, 2, 1, 'SomeRole1'),
			array(2, 4, 1, 'SomeRole2'),
			array(3, 4, 3, 'SomeRole1'),
			array(4, 2, 4, 'SomeRole3'),
			array(5, 1, 5, 'SomeRole4'),
			array(6, 3, 2, 'SomeRole5'),
			array(7, 1, 6, 'SomeSadRole1'),
			array(8, 2, 6, 'SomeSadRole2'),
			array(9, 1, 7, 'SomeSadRole1'),
			array(10, 2, 7, 'SomeSadRole2'),
		), 
		'movie_genres' => array(
			array(1, 1, 'Action'),
			array(2, 2, 'Horror'),
			array(3, 3, 'Thriller'),
			array(4, 4, 'Crime'),
			array(5, 5, 'Drama'),
			array(6, 6, 'Action'),
			array(7, 7, 'RomCom'),
		),
	);

	echo "<br><br>Actors:";
	foreach($data['actors'] as $queryData) {
		$query = "INSERT actors VALUES($queryData[0], '$queryData[1]', '$queryData[2]', '$queryData[3]');";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br><br>Directors:";
	foreach($data['directors'] as $queryData) {
		$query = "INSERT directors VALUES ($queryData[0], '$queryData[1]', '$queryData[2]');";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br>Directors Genres:";
	foreach($data['directors_genres'] as $queryData) {
		$query = "INSERT directors_genres VALUES ($queryData[0], $queryData[1], '$queryData[2]', '$queryData[3]');";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br><br>Movies:";
	foreach($data['movies'] as $queryData) {
		$query = "INSERT movies VALUES ($queryData[0], '$queryData[1]', $queryData[2], $queryData[3]);";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br><br>Movies Directors:";
	foreach($data['movies_directors'] as $queryData) {
		$query = "INSERT movies_directors VALUES ($queryData[0], $queryData[1], $queryData[2]);";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br><br>Roles:";
	foreach($data['roles'] as $queryData) {
		$query = "INSERT roles VALUES ($queryData[0], $queryData[1], $queryData[2], '$queryData[3]');";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}

	echo "<br><br>Movie Genres:";
	foreach($data['movie_genres'] as $queryData) {
		$query = "INSERT movies_genres VALUES ($queryData[0], $queryData[1], '$queryData[2]');";

		if($conn->query($query)) 
			echo "<br>Added Data";
		else 
			echo "<br>".mysqli_error($conn);
	}	
?>