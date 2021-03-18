--CREATE DATABASE  IF NOT EXISTS `learning_latin` /*!40100 DEFAULT CHARACTER SET latin1 */;
--USE `learning_latin`;
-- POSTGRES

DROP TABLE IF EXISTS knowledge;

CREATE TABLE knowledge (
  id SERIAL PRIMARY KEY,
  test_id int DEFAULT NULL,
  word_id int DEFAULT NULL,
  student_input_id int DEFAULT NULL,
  ok int DEFAULT NULL,

  FOREIGN KEY (test_id)
  REFERENCES test (id)

  ON DELETE NO ACTION ON UPDATE NO ACTION,

  FOREIGN KEY (word_id)
  REFERENCES word (id)

  ON DELETE NO ACTION ON UPDATE NO ACTION,

  FOREIGN KEY (student_input_id)
  REFERENCES student_input (id)

  ON DELETE NO ACTION ON UPDATE NO ACTION

);


