-- ORDERING RESULTS

SELECT census_region, state_name FROM state WHERE census_region IS NOT NULL ORDER BY census_region

SELECT census_region, state_name FROM state WHERE census_region IS NOT NULL ORDER BY census_region DESC, state_name 

-- Populations of all states from largest to smallest.
SELECT state_name, population FROM state ORDER BY population DESC

-- Can order by any column in table even if not SELECT the column
SELECT state_name FROM state ORDER BY population DESC

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.

SELECT census_region, state_name FROM state WHERE census_region IS NOT NULL ORDER BY census_region DESC, state_name

SELECT census_region, state_name, population / area AS population_density FROM state 
WHERE census_region IS NOT NULL AND population / area > 100
ORDER BY population_density DESC

-- The name of  parks sorted by largest to smallest area
SELECT park_name FROM park ORDER BY area DESC




-- LIMITING RESULTS

SELECT census_region, state_name, population / area AS population_density FROM state 
WHERE census_region IS NOT NULL
ORDER BY population_density DESC
LIMIT 10

-- The names of the 10 largest cities by populations
SELECT city_name FROM city ORDER BY population DESC LIMIT 10

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

SELECT CURRENT_DATE

SELECT park_name, date_established FROM park ORDER BY date_established LIMIT 20

SELECT park_name, (CURRENT_DATE - date_established) / 365 AS age_in_years FROM park ORDER BY date_established LIMIT 20

SELECT CURRENT_DATE

SELECT date_part('year', CURRENT_DATE)
SELECT date_part('month', CURRENT_DATE)



SELECT (date_part('year', CURRENT_DATE) - date_part('year', date_established)) AS age FROM park  park_name


SELECT park_name, (EXTRACT(year FROM CURRENT_DATE) - EXTRACT(year FROM date_established)) AS age FROM park  park_name

SELECT park_name, to_char(date_established,  'MM/dd/YYYY') FROM park ORDER BY date_established LIMIT 20
SELECT to_char(timestamp '2002-04-20 17:31:12.66', 'HH12:MI:SS')

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.

-- Wilmington, DE

SELECT city_name, state_abbreviation FROM city

SELECT city_name || ', ' || state_abbreviation AS city_state FROM city

-- All parks names and dates established.
SELECT 'Name: ' || park_name || '      Established: ' || date_established AS name_date FROM park

SELECT 'Name: ' || park_name || '      Established: ' || to_char(date_established,  'MM/dd/YYYY') AS name_date FROM park
-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_population FROM state
SELECT SUM(population) AS total_population FROM state


-- Total population in the West and South census regions
SELECT SUM(population) AS total_population FROM state WHERE census_region IN ('West', 'South');

-- The number of cities with populations greater than 1 million
SELECT COUNT(*) FROM city WHERE population > 1000000
SELECT city_name FROM city WHERE population > 1000000


-- The number of state nicknames.

-- return count of all rows
SELECT COUNT(*) FROM state

-- return count of all rows returned that DO NOT HAVE NULL in the state_nickname field
SELECT COUNT(state_nickname) FROM state

-- more explicit way?
SELECT COUNT(*) FROM state WHERE state_nickname IS NOT NULL

SELECT state_nickname FROM state ORDER BY state_nickname

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest_area, MAX(area) AS largest FROM park



-- GROUP BY

SELECT * FROM city
-- Count the number of cities in each state, ordered from most cities to least.
SELECT  state_abbreviation, COUNT(*) AS city_count FROM city GROUP BY state_abbreviation ORDER BY city_count DESC

SELECT  state_abbreviation, SUM(population) AS total_population FROM city GROUP BY state_abbreviation ORDER BY total_population DESC
SELECT  state_abbreviation, AVG(population) AS average_population FROM city GROUP BY state_abbreviation ORDER BY average_population DESC
SELECT  state_abbreviation, MIN(population) AS smallest_population FROM city GROUP BY state_abbreviation ORDER BY smallest_population
SELECT  state_abbreviation, MAX(population) AS largest_population FROM city GROUP BY state_abbreviation ORDER BY largest_population DESC


SELECT DISTINCT state_abbreviation FROM city
SELECT DISTINCT state_abbreviation, city_name FROM city
SELECT  state_abbreviation, city_name FROM city

SELECT  state_abbreviation, COUNT(*) AS city_count FROM city GROUP BY state_abbreviation ORDER BY city_count DESC
SELECT  state_abbreviation, city_name, COUNT(*) AS city_count FROM city GROUP BY state_abbreviation, city_name ORDER BY city_count DESC

SELECT *  FROM city

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) FROM park GROUP BY has_camping
SELECT * FROM park

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS total_population, AVG(area) as average_area FROM city GROUP BY state_abbreviation ORDER BY state_abbreviation


-- The smallest city population in each state ordered by smallest population.
SELECT state_abbreviation, MIN(population) AS smallest_city_population FROM city GROUP BY state_abbreviation ORDER BY smallest_city_population



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)

SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 2 ROWS FETCH NEXT 10 ROWS ONLY;
-- Increment/decrement the OFFSET value by 10 each time you want the next/previous "page".
-- OFFSET may not be less than 0. Doh!



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT state_abbreviation, COUNT(*) AS total_cities FROM city GROUP BY state_abbreviation ORDER BY total_cities DESC

SELECT * FROM city

SELECT 
( SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation )
, COUNT(*) AS total_cities FROM city GROUP BY state_abbreviation ORDER BY total_cities DESC

SELECT 
( SELECT state_name FROM state AS s WHERE s.state_abbreviation = c.state_abbreviation )
, COUNT(*) AS total_cities FROM city AS c GROUP BY state_abbreviation ORDER BY total_cities DESC

SELECT 
( SELECT state_name FROM state s WHERE s.state_abbreviation = c.state_abbreviation )
, COUNT(*)  total_cities FROM city c GROUP BY state_abbreviation ORDER BY total_cities DESC


SELECT state_name FROM state WHERE state_abbreviation = 'DE'

-- Display the names of the smallest and largest parks

SELECT MIN(area) AS smallest_area, MAX(area) AS largest_area FROM park

SELECT * FROM park 

SELECT DISTINCT
 (SELECT park_name FROM park WHERE area = (SELECT MIN(area) FROM park))
 FROM park 
 
 SELECT 
 	(SELECT park_name FROM park WHERE area = (SELECT MIN(area) FROM park)) AS smallest_park,
	(SELECT park_name FROM park WHERE area = (SELECT MAX(area) FROM park)) AS largesgt_park


SELECT park_name FROM park WHERE area = (SELECT MIN(area) FROM park)

-- List the capital cities for the states in the Northeast census region.

SELECT capital, state_abbreviation FROM state

SELECT capital, state_abbreviation FROM state
SELECT city_name FROM city WHERE city_id = 91

SELECT (SELECT city_name FROM city WHERE city.city_id = state.capital), state_abbreviation FROM state

SELECT state_abbreviation FROM state WHERE census_region = 'West'

SELECT city_name FROM city WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE census_region = 'West')

