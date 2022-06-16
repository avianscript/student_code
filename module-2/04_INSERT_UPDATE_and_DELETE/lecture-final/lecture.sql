-- INSERT

SELECT * FROM park_state

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
INSERT into park (park_name, has_camping, date_established, area) VALUES ('Disneyland', false, '1955-07-17', 2.1)

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.

SELECT * FROM city

INSERT INTO city VALUES (DEFAULT, 'Hawkins', 'IN', 30000, 38.1)

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.

SELECT * FROM park WHERE park_name = 'Disneyland'

SELECT park_id FROM park WHERE park_name = 'Disneyland'

INSERT INTO park_state VALUES(
(SELECT park_id FROM park WHERE park_name = 'Disneyland')
 , 'CA');
 
 SELECT DISTINCT state_abbreviation FROM park_state WHERE state_abbreviation = 'DE'
 
SELECT * FROM park_state
INSERT INTO park_state (park_id, state_abbreviation )
SELECT park_id, 'NY' FROM park WHERE park_name IN ('Yellowstone', 'Yosemite', 'Disneyland')

-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state WHERE state_name = 'California'

UPDATE state SET state_nickname = 'The Happiest Place on Earth.' 
WHERE state_name = ('California')


UPDATE state SET state_nickname = 'The Happiest Place on Earth.' 
WHERE state_abbreviation IN
(SELECT state_abbreviation FROM state WHERE state_name = 'California' OR state_name = 'Ohio')

-- Increase the population of California by 1,000,000.
SELECT * FROM state WHERE state_name = 'California'

UPDATE state SET population = population + 1000000 WHERE state_name = 'California'

-- Change the capital of California to Anaheim.

SELECT * FROM city WHERE city_id = 264

UPDATE state SET capital =
(SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA') WHERE
 state_name = 'California'

-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state SET state_nickname = 'The Golden State', population = population - 1000000, capital =
(SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA') WHERE
state_name = 'California'


-- DELETE

SELECT city_id FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN'

-- Delete Hawkins, IN from the city table.
DELETE FROM city WHERE
city_id = (SELECT city_id FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN')

-- Delete all cities with a population of less than 1,000 people from the city table.

DELETE FROM city WHERE population < 1000



-- Aside.. back to normalizing data:



SELECT * FROM state WHERE state_name = 'California'

SELECT LOWER(state_name) FROM state WHERE state_name = 'California'

SELECT * FROM state WHERE LOWER(state_name) = 'california'


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city VALUES (DEFAULT, 'YoavVille', 'XX', 10, .5)

-- Try deleting California from the state table.
DELETE FROM state WHERE state_abbreviation='CA'

DELETE FROM park_state  WHERE state_abbreviation='CA'

SELECT * from park_state

SELECT * FROM city WHERE state_abbreviation = 'CA'

DELETE FROM city WHERE state_abbreviation = 'CA'
-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.



-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
SELECT * FROM city

INSERT INTO city (city_name, state_abbreviation) VALUES ('Smallville', 'KS')

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city (city_name, state_abbreviation, area) VALUES ('Smallville', 'KS', 5.5)

-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
UPDATE state SET state_nickname = 'Vacationland' WHERE state_abbreviation='CA'
SELECT * FROM state WHERE state_abbreviation='ME'
-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).

UPDATE state SET census_region = 'Southeast' WHERE state_abbreviation='FL'


-- TRANSACTIONS

SELECT * FROM city
-- Delete the record for Smallville, KS within a transaction.

START TRANSACTION

DELETE from city WHERE city_name='Smallville' AND state_abbreviation='KS'

COMMIT


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
START TRANSACTION

DELETE FROM park_state 

ROLLBACK

SELECT * FROM park_state
-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
START TRANSACTION


UPDATE city SET state_abbreviation = 'TX'

SELECT * FROM city

ROLLBACK


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.


SELECT * FROM city WHERE city_name = 'Philadelphia'

START TRANSACTION;

UPDATE city SET state_abbreviation = 'DE' WHERE city_name = 'Philadelphia';

ROLLBACK;