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
DROP TABLE IF EXISTS `student_input`;

CREATE TABLE `student_input` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_column_lat` varchar(45) DEFAULT NULL,
  `second_column_lat` varchar(45) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;

