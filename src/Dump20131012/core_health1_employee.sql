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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` char(2) DEFAULT NULL,
  `zip` char(5) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `hourly_wage` decimal(7,2) DEFAULT NULL,
  `salary` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_role.id_idx` (`role_id`),
  KEY `fk_employee_status.id_idx` (`status_id`),
  CONSTRAINT `fk_employee_role.id` FOREIGN KEY (`role_id`) REFERENCES `employee_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_employee_status.id` FOREIGN KEY (`status_id`) REFERENCES `employee_status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,1,1,'Brown','Kathleen','s73 w2398 Hickory St','Milwaukee','WI','53188','262-486-4616','k@brown.com','2007-09-02',NULL,90000.00),(2,2,1,'Lite','Bobby','w235 Main St.','Racine','WI','53486','626-478-3186','bobb@bobby.com','2008-09-01',NULL,50000.00),(3,3,1,'Chinger','Timmy','s252 Bloddy St','Kenosha','WI','64863','514-789-4514','chiner@chiner.com','2009-02-02',NULL,40000.00),(4,4,1,'Walrus','Jawface','s573 Rafli St.','Waukesha','WI','53188','748-564-4658','ks@fas.com','2010-09-04',NULL,50000.00),(5,5,1,'Jawface','Danny','s358 Main St','Brookfield','WI','53147','125-789-4567','sfa@asfa.com','2011-05-25',NULL,42000.00),(6,6,1,'Kiggins','Bobby','35 Safaa Ave.','Genesse','WI','54863','518-154-4894','asfa@afa.com','2012-06-01',18.00,NULL),(7,7,1,'Huggins','Bob','s3085 w353 bobby St.','Waukesha','WI','57564','879-515-6875','asfaf@afafa.com','2011-04-05',10.00,NULL),(8,7,2,'Anus','Johnny','s24 Badass St.','Racine','WI','64864','789-789-7894','asfa@afa.com','2012-06-05',9.00,NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-12 18:23:58
