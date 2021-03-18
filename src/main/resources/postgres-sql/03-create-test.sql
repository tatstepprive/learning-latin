--CREATE DATABASE  IF NOT EXISTS `learning_latin` ;
--USE `learning_latin`;
-- POSTGRES

DROP TABLE IF EXISTS test;

CREATE TABLE test (
  id SERIAL PRIMARY KEY,
  name varchar(45) DEFAULT NULL,
  date date DEFAULT NULL,
  start_index int DEFAULT NULL,
  end_index int DEFAULT NULL,
  number_words int DEFAULT NULL
);

