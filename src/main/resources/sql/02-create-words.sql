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

/*insert per bunch of 10 words 1/10*/
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
	('meester', 'magister','magistri','m', 'noun', '/images/intranet-logo.png');
/*insert per bunch of 10 words 2/10*/
INSERT INTO `word` (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
    VALUES
	('muur', 'murus','muri','m', 'noun', '/images/intranet-logo.png'),
	('oog', 'oculus','oculi','m', 'noun', '/images/intranet-logo.png'),
	('volk', 'populus','populi','m', 'noun', '/images/intranet-logo.png'),
	('slaaf', 'servus','servi','m', 'noun', '/images/intranet-logo.png'),
	('poort', 'porta','portae','v', 'noun', '/images/intranet-logo.png'),
	('gevecht', 'pugna','pugnae','v', 'noun', '/images/intranet-logo.png'),
	('aarde', 'terra','terrae','v', 'noun', '/images/intranet-logo.png'),
	('land', 'terra','terrae','v', 'noun', '/images/intranet-logo.png'),
	('leven', 'vita','vitae','v', 'noun', '/images/intranet-logo.png'),
	('gebouw', 'aedificium','aedificii','o', 'noun', '/images/intranet-logo.png');
/*insert per bunch of 10 words 3/10*/
INSERT INTO `word` (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
VALUES
	('voorbeeld', 'exemplum','exempli','o', 'noun', null),
	('forum (Romeins marktplein)', 'forum','fori','o', 'noun', null),
	('wonder', 'monstrum','monstri','o', 'noun', null),
	('monster', 'monstrum','monstri','o', 'noun', null),
	('tempel', 'templum','templi','o', 'noun', null),
	('wijn', 'vinum','vini','o', 'noun', null),
	('goed', 'bonus','-a, -um','o', 'noun', null),
	('Grieks', 'Graecus','-a, -um','o', 'noun', null),
	('woedend', 'iratus','-a, -um','o', 'noun', null),
	('lang', 'longus','-a, -um','o', 'noun', null);
/*insert per bunch of 10 words 4/10*/
INSERT INTO `word` (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
VALUES
    ('prachtig', 'magnificus','-a, -um','o', 'noun', null),
	('groot', 'magnus','-a, -um','o', 'noun', null),
	('belangrijk', 'magnus','-a, -um','o', 'noun', null),
	('slecht', 'malus','-a, -um','o', 'noun', null),
	('nieuw', 'novus','-a, -um','o', 'noun', null),
	('beste', 'optimus','-a, -um','o', 'noun', null),
	('zeer goed', 'optimus','-a, -um','o', 'noun', null),
	('Romeins', 'Romanus','-a, -um','o', 'noun', null),
	('leider', 'dux','ducis','m', 'noun', null),
	('moeder', 'meter','matris','v', 'noun', null);
/*insert per bunch of 10 words 5/10*/
INSERT INTO `word` (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
VALUES
     ('lichaam', 'corpus','corporis','o', 'noun', null),
     ('liefde', 'amor','amoris','m', 'noun', null),
     ('tand', 'dens','dentis','m', 'noun', null),
     ('mens', 'homo','hominis','m', 'noun', null),
     ('soldaat', 'miles','militis','m', 'noun', null),
     ('zon', 'sol','solis','m', 'noun', null),
     ('boom', 'arbor','arboris','v', 'noun', null),
     ('licht', 'lux','lucis','v', 'noun', null),
     ('dood', 'mors','mortis','v', 'noun', null),
     ('nacht', 'nox','noctis','v', 'noun', null);


/*!40000 ALTER TABLE `word` ENABLE KEYS */;
UNLOCK TABLES;
