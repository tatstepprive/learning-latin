--CREATE DATABASE  IF NOT EXISTS `learning_latin` /*!40100 DEFAULT CHARACTER SET latin1 */;
--USE `learning_latin`;
-- POSTGRES 

CREATE TABLE word (
  id SERIAL PRIMARY KEY ,
  name_nl varchar(45) DEFAULT NULL,
  first_column_lat varchar(45) DEFAULT NULL,
  second_column_lat varchar(45) DEFAULT NULL,
  gender varchar(1) DEFAULT NULL,
  type varchar(45) DEFAULT NULL,
  image_path varchar(45) DEFAULT NULL
);

--
-- Dumping data for table `word`
--


--/*insert per bunch of 10 words 1/10*/
INSERT INTO word (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
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
	commit;
--/*insert per bunch of 10 words 2/10*/
INSERT INTO word (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
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
        commit;
--/*insert per bunch of 10 words 3/10*/
INSERT INTO word (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
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
        commit;
--/*insert per bunch of 10 words 4/10*/
INSERT INTO word (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
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
	('moeder', 'mater','matris','v', 'noun', null);
        commit;
--/*insert per bunch of 10 words 5/10*/
INSERT INTO word (name_nl, first_column_lat, second_column_lat, gender, type, image_path)
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
     commit;

