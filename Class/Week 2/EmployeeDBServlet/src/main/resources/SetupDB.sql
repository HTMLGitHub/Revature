DROP TABLE IF EXISTS employee;
CREATE TABLE employee
(
	id SERIAL PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	username VARCHAR(50),
	password VARCHAR(50)
);

INSERT INTO employee(firstname, lastname, username, password) VALUES
('Timmy', 'Maximoff', 'tmax', 'secret');

SELECT * FROM employee