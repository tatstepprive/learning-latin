CREATE DATABASE  IF NOT EXISTS `learning_latin` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `learning_latin`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: learning_latin
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `word`
--

DROP TABLE IF EXISTS `word`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;

CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_nl` varchar(45) DEFAULT NULL,
  `first_column_lat` varchar(45) DEFAULT NULL,
  `second_column_lat` varchar(45) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `image_path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `word`
--

LOCK TABLES `word` WRITE;
/*!40000 ALTER TABLE `word` DISABLE KEYS */;

INSERT INTO `word` (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
    VALUES
	('grootvader', 'avus','avi','m', 'noun', '/images/intranet-logo.png'),
	('roos', 'rosa','rosae','v', 'noun', '/images/intranet-logo.png'),
	('geschenk', 'donum','doni','o', 'noun', '/images/intranet-logo.png'),
	('vriend', 'amicus','amici','m', 'noun', '/images/intranet-logo.png'),
	('jaar', 'annus','anni','m', 'noun', '/images/intranet-logo.png'),
	('ezel', 'asinus','asini','m', 'noun', '/images/intranet-logo.png'),
	('god', 'deus','dei','m', 'noun', '/images/intranet-logo.png'),
	('meester', 'dominus','domini','m', 'noun', '/images/intranet-logo.png'),
	('zwaard', 'gladius','gladii','m', 'noun', '/images/intranet-logo.png'),
	('meester', 'magister','magistri','m', 'noun', '/images/intranet-logo.png'),
	('muur', 'murus','muri','m', 'noun', '/images/intranet-logo.png'),
	('oog', 'oculus','oculi','m', 'noun', '/images/intranet-logo.png'),
	('volk', 'populus','populi','m', 'noun', '/images/intranet-logo.png'),
	('slaaf', 'servus','servi','m', 'noun', '/images/intranet-logo.png'),
	('poort', 'porta','portae','v', 'noun', '/images/intranet-logo.png'),
	('gevecht', 'pugna','pugnae','v', 'noun', '/images/intranet-logo.png'),
	('aarde', 'terra','terrae','v', 'noun', '/images/intranet-logo.png'),
	('land', 'terra','terrae','v', 'noun', '/images/intranet-logo.png'),
	('leven', 'vita','vitae','v', 'noun', '/images/intranet-logo.png'),
	('gebouw', 'aedificium','aedificii','o', 'noun', '/images/intranet-logo.png'),
	('voorbeeld', 'exemplum','exempli','o', 'noun', '/images/intranet-logo.png');

/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
