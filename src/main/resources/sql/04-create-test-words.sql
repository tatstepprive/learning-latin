CREATE DATABASE  IF NOT EXISTS `learning_latin`;
USE `learning_latin`;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `test_word`;
CREATE TABLE `test_word` (
  `test_id` int(11) NOT NULL,
  `word_id` int(11) NOT NULL,

  PRIMARY KEY (`test_id`,`word_id`),

  KEY `FK_WORD_idx` (`word_id`),

  CONSTRAINT `FK_TEST` FOREIGN KEY (`test_id`)
  REFERENCES `test` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_word` FOREIGN KEY (`word_id`)
  REFERENCES `word` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;