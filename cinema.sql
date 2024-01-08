-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: cinema
-- ------------------------------------------------------
-- Server version	11.2.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `angajati`
--

DROP TABLE IF EXISTS `angajati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `angajati` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `data_angajare` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `angajati`
--

LOCK TABLES `angajati` WRITE;
/*!40000 ALTER TABLE `angajati` DISABLE KEYS */;
INSERT INTO `angajati` VALUES (1,'Flavis=us','user','user','2023-11-07');
/*!40000 ALTER TABLE `angajati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filme`
--

DROP TABLE IF EXISTS `filme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(255) NOT NULL,
  `durata` int(11) NOT NULL,
  `descriere` longtext DEFAULT NULL,
  `data_lansare` date NOT NULL,
  `pret` float NOT NULL,
  `regizor` varchar(255) NOT NULL,
  `gen` varchar(255) NOT NULL,
  `parental_guidance` varchar(255) NOT NULL,
  `sala_rulare` int(11) NOT NULL,
  `poster` longblob DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filme`
--

LOCK TABLES `filme` WRITE;
insert into filme(id, nume, durata, descriere, data_lansare, pret, regizor, gen, parental_guidance, sala_rulare, poster) 
values (1,'Film Actiune',120,'Film de actiune cu Brad Pitt','2015-08-12',31.29,'Quentin Tarantino', 'actiune', 'PG13', 2,null),
       (2,'Drama',110,'Sad family','2017-11-02',21.33,'Sergiu Nicolaescu', 'Drama', 'Mature', 4,null);
	   UNLOCK TABLES;
	   
/*!40000 ALTER TABLE `filme` DISABLE KEYS */;


--
-- Table structure for table `meniuri`
--

DROP TABLE IF EXISTS `meniuri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meniuri` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pret` float(11,0) NOT NULL,
  `nume` text NOT NULL,
  `continut` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meniuri`
--

LOCK TABLES `meniuri` WRITE;
/*!40000 ALTER TABLE `meniuri` DISABLE KEYS */;
INSERT INTO `meniuri` VALUES (1,30,'Mic','Popcorn'),(2,50,'Mai mic','Nachos'),(3,60,'mediu ','produse');
/*!40000 ALTER TABLE `meniuri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produse`
--

DROP TABLE IF EXISTS `produse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tip_produse` varchar(255) NOT NULL,
  `nume` varchar(255) NOT NULL,
  `producator` varchar(255) NOT NULL,
  `continut` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produse`
--

LOCK TABLES `produse` WRITE;
/*!40000 ALTER TABLE `produse` DISABLE KEYS */;
INSERT INTO `produse` VALUES (1,'Cipsuri','Lays Barbeque','Lays','1x Lays 180gr'),(2,'Bauturi','Mirinda','Mirinda','1x Mirinda 0,5L'),(3,'Cipsuri','Lays Sare','Lays','1x Lays 180gr'),(4,'Meniu Popcorn','Meniu Duet','Cinema','1x Popcorn Mare 4,8L(190gr) + 2x Bautura Medie 0,5L'),(5,'Meniu Popcorn','Meniu Mare','Cinema','1x Popcorn Mare 4,8L(190gr) + 1x Bautura Mare 0,75L'),(6,'Meniu Popcorn','Meniu Mediu','Cinema','1x Popcorn Mediu 2,3L(90gr) + 1x Bautura Medie 0,5L'),(7,'Jeleuri','Haribo','Haribo','1x jeleuri 200gr'),(8,'Dulciuri','Kinder Delice','Ferrero SpA','1x Kinder Delice 39gr'),(9,'Bauturi','Pepsi','Pepsi','1x Pepsi 0,5L'),(10,'Meniu Nachos','Meniu Duet','Cinema','Cipsuri 150gr + Sos 160gr + 2x Bautura Medie 0,5L'),(11,'Meniu Nachos','Meniu Mare','Cinema','Cipsuri 150gr + Sos 160gr 1x Bautura Mare 0,75L'),(12,'Meniu Nachos','Meniu Mediu','Cinema','Cipsuri 80gr + Sos 60gr 1x Bautura Medie 0,5L'),(13,'Extra','Sos Salsa','Cinema','1x sos salsa 60gr'),(14,'Extra','Sos Branza','Cinema','1x sos branza 60gr'),(15,'Dulciuri','Kinder Buenno','Ferrero SpA','1x Kinder Bueno'),(16,'Bauturi','Sprite','Sprite','1x Sprite 0,5L'),(17,'Bauturi','Coca Cola','Coca Cola','1x Coca Cola 0,5L'),(18,'Popcorn','Popcorn Mare','Cinema','1x Popcorn Mare 4,8L(190gr)'),(19,'Popcorn','Popcorn Mediu','Cinema','1x Popcorn Mediu 2,3L(90gr)'),(20,'Bauturi','Cappy','Cappy','1x Cappy Pulpy 0,33L'),(21,'Bauturi','Aqua Carpatica','Aqua Carpatica','1x Aqua Carpatica 0,5L'),(22,'Bauturi','Dorna','Dorna','1x Dorna 0,5L'),(23,'Bauturi','Schweppes','Schweppes','1x Scheppes 0,5L'),(24,'Dulciuri','Bounty','Bounty','1x Bounty 47gr'),(25,'Dulciuri','M&Ms','M&M','1x M&M 95gr'),(26,'Dulciuri','Nestle Fitness','Nestle','1x Nestle Fitness 22gr'),(27,'Dulciuri','Nestle Nestquick','Nestle','1x Nestle Nestquick 25gr'),(28,'Dulciuri','Twix','Twix','1x Twix 55gr'),(29,'Dulciuri','Tic Tac','Tic Tac','1x Tic Tac 19gr');
/*!40000 ALTER TABLE `produse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stoc_produse`
--

DROP TABLE IF EXISTS `stoc_produse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stoc_produse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_produs` int(11) NOT NULL,
  `cantitate` int(11) DEFAULT NULL,
  `pret` float NOT NULL,
  `data_expirare` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stoc_produse_produse_id_fk` (`id_produs`),
  CONSTRAINT `stoc_produse_produse_id_fk` FOREIGN KEY (`id_produs`) REFERENCES `produse` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stoc_produse`
--

LOCK TABLES `stoc_produse` WRITE;
/*!40000 ALTER TABLE `stoc_produse` DISABLE KEYS */;
INSERT INTO `stoc_produse` VALUES (30,1,99,8,'2024-01-01'),(31,2,194,7.9,'2024-01-02'),(32,3,100,8,'2024-05-07'),(33,4,NULL,20.5,NULL),(34,5,NULL,17.5,NULL),(35,6,NULL,14.5,NULL),(36,7,100,8.3,'2026-08-09'),(37,8,192,2.9,'2024-01-02'),(38,9,230,7.9,'2024-01-02'),(39,10,NULL,27.9,NULL),(40,11,NULL,22.9,NULL),(41,12,NULL,17.9,NULL),(42,13,NULL,2,NULL),(43,14,NULL,2,NULL),(44,15,300,4,'2024-11-07'),(45,16,200,7.9,'2024-11-07'),(46,17,200,7.9,'2024-11-07'),(47,18,NULL,13,NULL),(48,19,NULL,9,NULL),(49,20,120,7.9,'2024-11-07'),(50,21,200,5,'2024-10-02'),(51,22,200,5,'2024-10-02'),(52,23,150,7.9,'2024-06-09'),(53,24,200,3.9,'2024-01-12'),(54,25,200,9.5,'2024-04-11'),(55,26,200,2.9,'2024-01-02'),(56,27,200,2.9,'2024-09-12'),(57,28,200,3.5,'2024-01-07'),(58,29,200,3.5,'2024-07-08');
/*!40000 ALTER TABLE `stoc_produse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vanzari`
--

DROP TABLE IF EXISTS `vanzari`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vanzari` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produse_vandute` longtext DEFAULT NULL,
  `id_angajat` int(11) DEFAULT NULL,
  `pret` float NOT NULL,
  `data_bon` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vanzari_angajati_id_fk` (`id_angajat`),
  CONSTRAINT `vanzari_angajati_id_fk` FOREIGN KEY (`id_angajat`) REFERENCES `angajati` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vanzari`
--

LOCK TABLES `vanzari` WRITE;
/*!40000 ALTER TABLE `vanzari` DISABLE KEYS */;
INSERT INTO `vanzari` VALUES (1,NULL,1,227.5,'2023-12-04'),(2,NULL,1,62,'2023-12-26'),(3,NULL,1,0,'2023-12-30'),(4,NULL,1,2.9,'2023-12-30');
/*!40000 ALTER TABLE `vanzari` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'cinema'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-30 20:42:22
