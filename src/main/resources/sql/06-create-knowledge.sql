CREATE DATABASE  IF NOT EXISTS `learning_latin` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `learning_latin`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: learning_latin
-- ------------------------------------------------------
-- Server version	5.6.16
--
-- Table structure for table `test`
--
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `knowledge`;

CREATE TABLE `knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `test_id` int(11) DEFAULT NULL,
  `word_id` int(11) DEFAULT NULL,
  `student_input_id` int(11) DEFAULT NULL,
  `ok` tinyint(1) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_TEST_KNOW_idx` (`test_id`),

  CONSTRAINT `FK_TEST_KNOW`
  FOREIGN KEY (`test_id`)
  REFERENCES `test` (`id`)

  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_WORD_KNOW_idx` (`word_id`),

  CONSTRAINT `FK_WORD_KNOW`
  FOREIGN KEY (`word_id`)
  REFERENCES `word` (`id`)

  ON DELETE NO ACTION ON UPDATE NO ACTION,

  KEY `FK_STUDENT_INPUT_KNOW` (`student_input_id`),

  CONSTRAINT `FK_STUDENT_INPUT_KNOW`
  FOREIGN KEY (`student_input_id`)
  REFERENCES `student_input` (`id`)

  ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

