-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation FROM city WHERE city_name = 'Columbus'

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, area, state_name FROM city
JOIN state ON state.state_abbreviation = city.state_abbreviation
WHERE city_name = 'Columbus'

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation FROM park
JOIN park_state ON park_state.park_id = park.park_id

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name FROM park
JOIN park_state ON park_state.park_id = park.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation


-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state_name, city_name AS capital_city FROM park
JOIN park_state ON park_state.park_id = park.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation
JOIN city ON city.city_id = state.capital

-- using aliases
SELECT p.park_name, s.state_name, c.city_name AS capital_city FROM park p
JOIN park_state ps ON ps.park_id = p.park_id
JOIN state s ON s.state_abbreviation = ps.state_abbreviation
JOIN city c ON c.city_id = s.capital

-- Modify the previous query to include the area of each park.
SELECT p.park_name, p.area AS park_area , s.state_name, c.city_name AS capital_city FROM park p
JOIN park_state ps ON ps.park_id = p.park_id
JOIN state s ON s.state_abbreviation = ps.state_abbreviation
JOIN city c ON c.city_id = s.capital

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT city_name, c.population FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE census_region = 'Midwest'

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state_name, COUNT(*) AS city_count FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name


-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state_name, COUNT(*) AS city_count FROM city c
JOIN state s ON s.state_abbreviation = c.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name
ORDER BY city_count DESC


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established) FROM state s
JOIN park_state ps ON ps.state_abbreviation = s.state_abbreviation
JOIN park p ON p.park_id = ps.park_id
GROUP BY state_name


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established) FROM state s
LEFT JOIN park_state ps ON ps.state_abbreviation = s.state_abbreviation
LEFT JOIN park p ON p.park_id = ps.park_id
GROUP BY state_name


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name FROM city WHERE city_name LIKE 'W%'

UNION

SELECT state_name AS place_name FROM state WHERE state_name LIKE 'W%'
ORDER BY place_name 

-- Modify the previous query to include a column that indicates whether the place is a city or state.

SELECT city_name AS place_name, 'CITY' AS place_type FROM city WHERE city_name LIKE 'W%'

UNION

SELECT state_name AS place_name, 'STATE' AS place_type FROM state WHERE state_name LIKE 'W%'
ORDER BY place_name 

-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name FROM genre

-- The titles of all the Comedy movies
SELECT title, genre_name FROM movie m
JOIN movie_genre mg ON mg.movie_id = m.movie_id
JOIN genre g ON g.genre_id = mg.genre_id
WHERE genre_name = 'Comedy' or genre_name = 'comedy'
