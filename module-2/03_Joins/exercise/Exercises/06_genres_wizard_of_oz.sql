-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT genre_name FROM genre
JOIN movie_genre mg ON genre.genre_id = mg.genre_id
JOIN movie ON mg.movie_id = movie.movie_id
WHERE title = 'The Wizard of Oz'

