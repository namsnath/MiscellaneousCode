SELECT actors.id, movies_genres.genre
FROM actors
LEFT JOIN roles ON roles.actor_id = actors.id
LEFT JOIN movies ON movies.id = roles.movie_id
LEFT JOIN movies_genres ON movies_genres.movie_id = movies.id
WHERE COUNT(movies_genres.genre) > 1
GROUP BY actors.id, movies_genres.genre



SELECT actors.id FROM actors LEFT JOIN roles ON roles.actor_id = actors.id LEFT JOIN movies ON movies.id = roles.movie_id LEFT JOIN movies_genres ON movies_genres.movie_id = movies.id GROUP BY actors.id, movies_genres.genre;

SELECT actors.id, movies_genres.genre, COUNT(movies_genres.genre) as cnt FROM actors LEFT JOIN roles ON roles.actor_id = actors.id LEFT JOIN movies ON movies.id = roles.movie_id LEFT JOIN movies_genres ON movies_genres.movie_id = movies.id GROUP BY actors.id HAVING cnt > 1;


SELECT actors.first_name, actors.last_name, movies.name, movies_genres.genre
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
		);