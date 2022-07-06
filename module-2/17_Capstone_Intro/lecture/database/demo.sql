BEGIN TRANSACTION;

DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS demo_user;
DROP SEQUENCE IF EXISTS seq_demo_user_id;

CREATE SEQUENCE seq_demo_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE demo_user (
	user_id int NOT NULL DEFAULT nextval('seq_demo_user_id'),
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	CONSTRAINT PK_demo_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE TABLE employee (
	employee_id serial PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	birthdate date NOT NULL
	
);

CREATE TABLE department (
	department_id serial PRIMARY KEY,
	department_name varchar(100) NOT NULL,
	department_head_id int NOT NULL,
	CONSTRAINT FK_dept_dept_head_id FOREIGN KEY (department_head_id) REFERENCES demo_user (user_id)
);

CREATE TABLE employee_department (
	employee_id int NOT NULL,
	department_id int NOT NULL,
	CONSTRAINT PK_employee_department PRIMARY KEY (employee_id, department_id),
	CONSTRAINT FK_employee_dept_emp_id FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
	CONSTRAINT FK_employee_dept_dept_id FOREIGN KEY (department_id) REFERENCES department (department_id) 
);

INSERT INTO demo_user VALUES (DEFAULT, 'yoavtest1', '$2a$10$pe5CR5tkMVszpwU5OvmD7ehB/h6Ku6Mv3J3/Eihb6mGHxDVzCDssm');
INSERT INTO demo_user VALUES (DEFAULT, 'tech_boss', '$2a$10$NvfLfzwFsJKICxwWDriujuth4llKxcuEISh1NmCTa6Utn94g9ZKSG');
INSERT INTO demo_user VALUES (DEFAULT, 'mkt_boss', '$2a$10$3OJ7Y6sDq7bN.plpNedxVuBpD/KC5TwEpIMtgKaS7fwo8aMQE50E.');
INSERT INTO demo_user VALUES (DEFAULT, 'hr_boss', '$2a$10$jAu1lwo9.2vavQIHVlRQluWx.GJju9BNBz4XIoc9DLlWmnyLvuTJC');

INSERT INTO department VALUES (DEFAULT, 'Engineering', 1002);
INSERT INTO department VALUES (DEFAULT, 'Marketing', 1003);
INSERT INTO department VALUES (DEFAULT, 'Human Resources', 1004);

INSERT INTO employee VALUES (DEFAULT, 'Linda', 'C', '1939-10-11');
INSERT INTO employee VALUES (DEFAULT, 'Kenneth', 'C', '1965-07-26');
INSERT INTO employee VALUES (DEFAULT, 'Jamie', 'M', '1952-07-05');
INSERT INTO employee VALUES (DEFAULT, 'Jane', 'S', '1970-09-10');

INSERT INTO employee_department VALUES (1, 3);
INSERT INTO employee_department VALUES (2, 1);
INSERT INTO employee_department VALUES (3, 2);
INSERT INTO employee_department VALUES (4, 2);

COMMIT;
