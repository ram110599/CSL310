DROP SCHEMA IF EXISTS BANK;					
CREATE SCHEMA BANK;							
USE BANK;									

CREATE TABLE contact (
    contact_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    street_address VARCHAR(100),
    city VARCHAR(20),
    state VARCHAR(20),
    country VARCHAR(20),
    pincode NUMERIC(6),
    phone NUMERIC(12),
    mobile NUMERIC(12),
    email VARCHAR(30),
	primary key (contact_id)
);
	
CREATE TABLE account_holder (
	person_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	pan_number VARCHAR(10) NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20),
	dob DATE NOT NULL,
	contact_id INT UNSIGNED,
	primary key (person_id),
	UNIQUE (pan_number),
	FOREIGN KEY (contact_id) references contact(contact_id) on delete set null
);

CREATE TABLE bank_account(
	account_id INT NOT NULL AUTO_INCREMENT,
	opening_date DATE,		
	closing_date DATE, 
	status VARCHAR(15),
	person_id INT UNSIGNED,
	account_type VARCHAR(20),
	current_balance DOUBLE(10,2),
	last_transaction TIMESTAMP,
	primary key (account_id),
	FOREIGN KEY (person_id) references account_holder(person_id) on delete set null
);

CREATE TABLE account_transaction(
	transaction_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	transaction_type VARCHAR(15),
	transaction_time DATE,
	amount DOUBLE(10,2),
	account_id INT,
	category VARCHAR(15),
	remarks VARCHAR(200),
	primary key (transaction_id),
	FOREIGN KEY (account_id) references bank_account(account_id) on delete set null 
);