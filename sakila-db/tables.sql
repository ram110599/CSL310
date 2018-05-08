
CREATE TABLE authentication (
  user_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  password blob,
  PRIMARY KEY (user_id)
); 

CREATE TABLE profile (
  profile_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  mobile_no TEXT NOT NULL,
  email_id varchar(255) DEFAULT NULL,
  PRIMARY KEY  (profile_id),
  CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES authentication (user_id) 
);

CREATE TABLE news_article (
  news_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  title TEXT ,
  description TEXT ,
  read_more TEXT,
  update_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  upvote_count SMALLINT,
  downvote_count SMALLINT,
  PRIMARY KEY  (news_id)
);

CREATE TABLE voting( 
  voting_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT, 
  flag SMALLINT,
  user_id int(10) unsigned , 
  news_id SMALLINT UNSIGNED , 
  PRIMARY KEY (voting_id), 
  FOREIGN KEY ( user_id) REFERENCES authentication (user_id) 
  ON DELETE SET NULL ON UPDATE CASCADE,
  FOREIGN KEY ( news_id) REFERENCES news_article (news_id)
  ON DELETE SET NULL ON UPDATE CASCADE 
);