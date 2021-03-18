--CREATE DATABASE  IF NOT EXISTS `learning_latin`;
--USE `learning_latin`;

DROP TABLE IF EXISTS test_word;
CREATE TABLE test_word (
  test_id int NOT NULL,
  word_id int NOT NULL,

  PRIMARY KEY (test_id,word_id),

  FOREIGN KEY (word_id)
	REFERENCES word (id)
	ON DELETE NO ACTION ON UPDATE NO ACTION,

  FOREIGN KEY (test_id)
    REFERENCES test (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
);

