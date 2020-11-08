DROP SCHEMA IF EXISTS oblig4 CASCADE; 
CREATE SCHEMA oblig4; 
SET search_path = oblig4; 

CREATE TABLE participant
(
	firstName CHARACTER VARYING (20),
	lastName CHARACTER VARYING (20),
	phoneNumber CHARACTER VARYING (20),
	password_hash CHARACTER  (256),
	password_salt CHARACTER (32),
	sex CHARACTER VARYING (15),
	PRIMARY KEY (phonenumber)
	
); 