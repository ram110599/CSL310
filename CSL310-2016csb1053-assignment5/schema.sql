DROP SCHEMA IF EXISTS TEAM;					
CREATE SCHEMA TEAM;							
USE TEAM;

CREATE TABLE contact (
    contact_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    street_address VARCHAR(200),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50),
    pincode NUMERIC(6),
    phone NUMERIC(12),
    mobile NUMERIC(12),
    email VARCHAR(30),
	primary key (contact_id)
);

CREATE TABLE person (
	person_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50),
	dob DATE NOT NULL,
	contact_id INT UNSIGNED,
	primary key (person_id),
	FOREIGN KEY (contact_id) references contact(contact_id) on delete set null
);	

CREATE TABLE team (
	team_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	creation_date DATE NOT NULL,
	status VARCHAR(50),
	name VARCHAR(100),
	office_id INT UNSIGNED,
	primary key (team_id),
	FOREIGN KEY (office_id) references contact(contact_id) on delete set null
);

CREATE TABLE team_member (
	member_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	team_id INT UNSIGNED,
	person_id INT UNSIGNED,
	salary DOUBLE(10,2),
	hire_date DATE NOT NULL,
	role VARCHAR(100),
	remarks VARCHAR(150),
	primary key (member_id),
	FOREIGN KEY (team_id) references team(team_id) on delete set null,
	FOREIGN KEY (person_id) references person(person_id) on delete set null	
);