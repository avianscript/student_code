DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS art_piece;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;

CREATE TABLE artist (
	
	artist_id		SERIAL PRIMARY KEY,
	artist_name		VARCHAR(150) NOT NULL
	
);

CREATE TABLE art_piece (
	
	art_piece_id	SERIAL,
	title			VARCHAR(500) NOT NULL,
	artist_id		INTEGER NOT NULL,
	CONSTRAINT pk_art_piece PRIMARY KEY (art_piece_id),
	CONSTRAINT fk_art_piece_artist_id FOREIGN KEY (artist_id) REFERENCES artist (artist_id)	
);

CREATE table customer (
	
	customer_id			SERIAL PRIMARY KEY,
	first_name			VARCHAR(100) NOT NULL,
	last_name 			VARCHAR(100) NOT NULL,
	phone				VARCHAR(25),
	street_address 		VARCHAR(250) NOT NULL,
	city				VARCHAR(100) NOT NULL,
	state				VARCHAR(100) NOT NULL,
	zipcode				VARCHAR(25) NOT NULL
	
);

CREATE TABLE purchase (
	purchase_id		SERIAL PRIMARY KEY,
	customer_id		INTEGER, 
	art_piece_id	INTEGER, 
	sale_price		NUMERIC(12, 2) NOT NULL,
	purchase_date	TIMESTAMP NOT NULL,
	CONSTRAINT fk_purchase_cust_id FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
	CONSTRAINT fk_purchase_art_id FOREIGN KEY (art_piece_id) REFERENCES art_piece (art_piece_id)
);