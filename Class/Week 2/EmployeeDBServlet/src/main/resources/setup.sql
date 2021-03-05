DROP TABLE IF EXISTS MatthewL.employee;
--DROP TABLE IF EXISTS MatthewL.employee CASCADE; this is possible too
CREATE TABLE MatthewL.employee
(
	id SERIAL PRIMARY KEY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	username VARCHAR(50),
	pass_word VARCHAR(50)
);

INSERT INTO MatthewL.employee(first_name, last_name, username, pass_word)
VALUES
("Timmy", "Maximoff", "tmax", "secret");
