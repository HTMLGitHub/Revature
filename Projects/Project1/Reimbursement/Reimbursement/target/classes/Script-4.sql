DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info
(
	id SERIAL PRIMARY KEY UNIQUE,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50),
	username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(50) NOT NULL,
	position INTEGER NOT NULL
);

DROP TABLE IF EXISTS employee CASCADE;
CREATE TABLE employee
(
	id INTEGER,
	reimbursement_id INTEGER PRIMARY KEY UNIQUE,
	
	FOREIGN KEY(id)
		REFERENCES user_info(id),
			
	FOREIGN KEY(reimbursement_id)
		REFERENCES reimbursment_info(id)
);

DROP TABLE IF EXISTS manager CASCADE;
CREATE TABLE manager
(
	id INTEGER,
	reimbursement_id INTEGER PRIMARY KEY UNIQUE,
	
	FOREIGN KEY (id)
		REFERENCES user_info(id),
			
	FOREIGN KEY(reimbursement_id)
		REFERENCES reimbursment_info(id)
);

DROP TABLE IF EXISTS reimbursment_info;
CREATE TABLE reimbursment_info
(
	id SERIAL PRIMARY KEY UNIQUE,
	submitted date NOT NULL,
	finished date,
	reason VARCHAR(50) NOT NULL,
	other_reason VARCHAR(50),
	amount NUMERIC NOT NULL,
	submittedby VARCHAR(50) NOT NULL,
	completedby VARCHAR(50),
	pending boolean NOT NULL,
);

INSERT INTO MATTHEWL.USER_INFO (firstname, lastname, username, password, position) VALUES
('Timmy', 'Maximoff', 'tmax', 'secret', 1),
('Wade', 'Watts', 'WOW', 'Parzival', 1),
('Wade', 'Wilson', 'Deadpool', 'Dead1', 1),
('James', 'Howlett', 'Wolverene', 'Logan', 1),
('Ken', 'Adams', 'Kenny', 'Kenny', 1),
('Ashli', 'Lee', 'Ash', 'pw1', 2),
('Krystal', 'Lee', 'Coco', 'pw2', 2),
('Bridget', 'Lee', 'Bridge', 'pw3', 2),
('Rileigh', 'Lee', 'Rye', 'pw4', 2),
('Emelia', 'Lee', 'Emmy', 'pw5', 2)


TRUNCATE TABLE MATTHEWL.USER_INFO CASCADE;

UPDATE user_info SET password = 'Kenny' WHERE password = 'Joey';

SELECT * FROM employee
SELECT * FROM MATTHEWL.REIMBURSMENT_INFO RI
SELECT * FROM manager
select * from MATTHEWL.USER_INFO UI 
UPDATE MATTHEWL.REIMBURSMENT_INFO SET COMPLETEDBY = 'Ashli', pending=FALSE 
WHERE id= (SELECT REIMBURSEMENT_ID FROM manager );

SELECT * FROM MATTHEWL.REIMBURSMENT_INFO RI 
SELECT id FROM user_info WHERE id = (SELECT id FROM employee) AND firstname = 'James';