--drop tables
DROP TABLE IF EXISTS member_interest_org;
DROP TABLE IF EXISTS member_event;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS interest_org;
DROP TABLE IF EXISTS member;


--Create table member
CREATE TABLE member(
	member_id serial NOT NULL,
	last_name varchar(100) NOT NULL,
	first_name varchar(100) NOT NULL,
	email_address varchar(100) NOT NULL,
	phone_number varchar(20) NOT NULL,
	date_of_birth date NOT NULL,
	follow_up boolean NOT NULL,
	CONSTRAINT PK_member PRIMARY KEY (member_id)
);

INSERT INTO member (member_id, last_name, first_name, email_address, phone_number, date_of_birth, follow_up) VALUES
	(1, 'Smith', 'Chuck', 'chucksmith@email.com', '123-346-7890', '1980-01-01', true),
	(2, 'Smart', 'Carla', 'carlasmart@email.com', '346-789-0123', '1981-02-02', true),
	(3, 'Smalls', 'Carlos', 'carlossmall@email.com', '789-012-3456', '1982-03-03', true),
	(4, 'Smiles', 'Cecil', 'cecilsmiles@email.com', '012-345-6789', '1983-04-04', true),
	(5, 'Jones', 'Bob', 'bobjones@email.com', '345-678-9012', '1990-05-05', false),
	(6, 'Johnson', 'Barb', 'barbjohnson@email.com', '678-901-2345', '1991-06-06', false),
	(7, 'James', 'Bonnie', 'bonniejames@email.com', '901-234-5678', '1992-07-07', false),
	(8, 'Jeffreys', 'Blair', 'blairjeffreys@email.com', '234-567-8901', '1993-08-08', false);


CREATE TABLE interest_org(
	org_id serial NOT NULL,
	org_name varchar(100) NOT NULL,
	CONSTRAINT PK_interest_org PRIMARY KEY (org_id)
);

INSERT INTO interest_org (org_id, org_name) VALUES
	(1, 'MeetupsRUs'),
	(2, 'I Think This is the Wrong Group'),
	(3, 'We are Family');


CREATE TABLE event(
	event_id serial NOT NULL,
	event_name varchar(100) NOT NULL,
	description varchar(1000) NOT NULL,
	start_date date NOT NULL,
	start_time time NOT NULL,
	duration_minutes int NOT NULL,
	hosting_org_id int NOT NULL,
CONSTRAINT PK_event PRIMARY KEY (event_id),
CONSTRAINT FK_event_interest_org FOREIGN KEY (hosting_org_id) REFERENCES interest_org (org_id)
);

INSERT INTO event (event_id, event_name, description, start_date, start_time, duration_minutes, hosting_org_id) VALUES
	(1, 'Meetapalooza', 'A great meetup!', '2022-01-01', '12:00:00', 300, 1),
	(2, 'MeetStock', 'A groovy meetup', '2022-02-02', '13:00:00', 120, 2),
	(3, 'Meetaroo', 'Not your average meetup', '2022-03-03', '14:00:00', 240, 3),
	(4, 'SpringMeet', 'Like Summerfest, but not!', '2022-04-04', '15:00:00', 200, 1);


CREATE TABLE member_event(
	member_id int NOT NULL,
	event_id int NOT NULL,
	CONSTRAINT PK_member_event PRIMARY KEY (member_id, event_id),
	CONSTRAINT FK_member_event_member FOREIGN KEY (member_id) REFERENCES member (member_id),
	CONSTRAINT FK_member_event_event FOREIGN KEY (event_id) REFERENCES event (event_id)
);

INSERT INTO member_event (member_id, event_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(8, 3),
(1, 3),
(2, 4),
(4, 4),
(6, 4);


CREATE TABLE member_interest_org(
	member_id int NOT NULL,
	org_id int NOT NULL,
	CONSTRAINT PK_member_interest_org PRIMARY KEY (member_id, org_id),
	CONSTRAINT FK_member_interest_org_member FOREIGN KEY (member_id) REFERENCES member (member_id),
	CONSTRAINT FK_member_interest_org_interest_org FOREIGN KEY (org_id) REFERENCES interest_org (org_id)
);

INSERT INTO member_interest_org (member_id, org_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(8, 3),
(1, 3);



	


	




	