--DROP SCHEMA IF EXISTS library;
--CREATE SCHEMA library;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  email_id VARCHAR(250) NOT NULL
);
INSERT INTO user (id,name,email_id) VALUES
  (1,'Abc','a@gmail.com'),
  (2,'KMN', 'b@yahoo.com'),
  (3,'Xyz', 'c@yahoo.com');

DROP TABLE IF EXISTS book;

CREATE TABLE book (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  user_Id INT(11) NULL,
  number_copy INT(11) NOT NULL DEFAULT 1,
  CONSTRAINT user_id_fk1 FOREIGN KEY (user_id) REFERENCES user(id)
);

INSERT INTO book (id, name,author,number_copy) VALUES
  (1,'M1','HK DAS',2),
  (2,'M2', 'RD Sharma',3),
  (3,'Physics', 'RD Sharma',1);

