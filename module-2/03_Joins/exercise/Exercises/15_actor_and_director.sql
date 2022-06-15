-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT title, person_name FROM person p
JOIN movie m ON p.person_id = m.director_id
JOIN movie_actor ma ON m.movie_id = ma.movie_id
WHERE ma.actor_id = p.person_id
