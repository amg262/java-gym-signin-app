CREATE DATABASE  IF NOT EXISTS `core_health1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `core_health1`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: core_health1
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mem_type` int(11) NOT NULL,
  `mem_payment` int(11) NOT NULL,
  `free_session` int(11) NOT NULL,
  `mem_status` int(11) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_membership_payment.id_idx` (`mem_payment`),
  KEY `fk_membership_status.id_idx` (`mem_status`),
  KEY `fk_membership_type.id_idx` (`mem_type`),
  KEY `fk_free_session.id_idx` (`free_session`),
  CONSTRAINT `fk_freesession` FOREIGN KEY (`free_session`) REFERENCES `free_session` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_membership_payment.id` FOREIGN KEY (`mem_payment`) REFERENCES `membership_payment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_membership_status.id` FOREIGN KEY (`mem_status`) REFERENCES `membership_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_membership_type.id` FOREIGN KEY (`mem_type`) REFERENCES `membership_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,1,1,1,1,'Gunn','Andrew','33 Main St.','Mukwonago','WI','53149','262-719-3232','a@a.com','2009-11-09'),(2,2,2,2,1,'Koehler','Erik','s35 w23785 Hickory St','Oconomowoc','WI','51684','554-849-6513','erock@erock.com','2009-12-12'),(3,2,2,2,1,'Uhan','Kyle','334 Main St.','Waukesha','WI','53187','262-456-7894','uhan@uhan.com','2010-11-11'),(4,1,1,1,2,'Brown','Kathleen','s74 w39857 Grove St.','Milwaukee','WI','48643','414-789-1324','kbrown@wctc.edu','2009-05-25'),(5,2,2,2,2,'Brazeau','Nick','s454 w35325 Locust Ave.','Milwaukee','WI','53148','414-789-1684','nick@nick.com','2009-03-30'),(6,1,2,2,1,'buczynski','Dan','s90 Main st','Delafield','WI','78913','262-456-1478','dan@dan.com','2010-02-24'),(7,2,2,2,2,'White','Walter','Main St.','Tuscon','AZ','19843','414-789-4641','afsa@af.com','2001-09-23'),(8,1,2,2,1,'White','Skylar','Main St.','Tuscon','AZ','84964','414-789-6543','afa@asfa.com','2009-05-05'),(9,2,1,1,2,'Goon','James','Aagaa St','Racine','WI','74894','414-789-7898','afa@afa.com','2010-04-25'),(10,2,2,2,2,'Giggity','Goo','fasfa Ave.','Kenosha','WI','46846','414-123-4567','afa@afafa.com','2011-05-05'),(11,1,1,1,1,'Griffin','Peter','Spooner St.','Quahog','RI','78945','747-878-4564','asfa@a.com','2009-02-24'),(12,2,1,1,1,'Griffin','Lois','Spooner St.','Quahog','RI','48641','477-648-1654','afafa@af.com','2009-01-02');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-12 18:23:57
