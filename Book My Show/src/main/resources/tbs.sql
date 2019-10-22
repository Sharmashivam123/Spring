-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bms
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `movieId` int(11) DEFAULT NULL,
  `theatreId` int(11) DEFAULT NULL,
  `showtiming` time DEFAULT NULL,
  `showDate` date DEFAULT NULL,
  `ticketsBooked` int(100) DEFAULT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `theatreId` (`theatreId`),
  KEY `movieId` (`movieId`),
  CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`theatreId`) REFERENCES `theatre` (`theatreId`),
  CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`movieId`) REFERENCES `movie` (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `cityId` int(11) NOT NULL,
  `cityName` varchar(30) NOT NULL,
  PRIMARY KEY (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Hyderabad');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `pincode` int(11) NOT NULL,
  `cityId` int(11) DEFAULT NULL,
  `areaName` varchar(30) NOT NULL,
  PRIMARY KEY (`pincode`),
  KEY `cityId` (`cityId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (500081,1,'Gachibowli'),(500082,1,'Madhapur'),(500083,1,'Raidurgam'),(500084,1,'Kukatpally'),(500085,1,'Ameerpet');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL,
  `movieName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`movieId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'war'),(2,'joker'),(3,'housefull4'),(4,'terminator');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moviebylocation`
--

DROP TABLE IF EXISTS `moviebylocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moviebylocation` (
  `movieId` int(11) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moviebylocation`
--

LOCK TABLES `moviebylocation` WRITE;
/*!40000 ALTER TABLE `moviebylocation` DISABLE KEYS */;
INSERT INTO `moviebylocation` VALUES (1,500081),(1,500082),(1,500083),(1,500084),(1,500085),(2,500081),(2,500082),(2,500083),(2,500084),(2,500085),(3,500081),(3,500082),(3,500083),(3,500084),(3,500085),(4,500081),(4,500082),(4,500083),(4,500084),(4,500085);
/*!40000 ALTER TABLE `moviebylocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pricerange`
--

DROP TABLE IF EXISTS `pricerange`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pricerange` (
  `rangeId` int(11) NOT NULL,
  `tier` varchar(10) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`rangeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pricerange`
--

LOCK TABLES `pricerange` WRITE;
/*!40000 ALTER TABLE `pricerange` DISABLE KEYS */;
INSERT INTO `pricerange` VALUES (1,'silver',100),(2,'gold',150),(3,'platinum',200);
/*!40000 ALTER TABLE `pricerange` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showtiming`
--

DROP TABLE IF EXISTS `showtiming`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `showtiming` (
  `timingId` int(11) NOT NULL,
  `show1` time DEFAULT NULL,
  `show2` time DEFAULT NULL,
  `show3` time DEFAULT NULL,
  `show4` time DEFAULT NULL,
  `availableSeats` int(11) DEFAULT NULL,
  PRIMARY KEY (`timingId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showtiming`
--

LOCK TABLES `showtiming` WRITE;
/*!40000 ALTER TABLE `showtiming` DISABLE KEYS */;
INSERT INTO `showtiming` VALUES (1,'10:00:00','13:00:00','18:00:00','22:00:00',100),(2,'11:00:00','14:00:00','17:00:00','21:00:00',100),(3,'10:00:00','14:00:00','16:00:00','20:00:00',100),(4,'12:00:00','15:00:00','18:00:00','22:15:00',100);
/*!40000 ALTER TABLE `showtiming` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatre`
--

DROP TABLE IF EXISTS `theatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatre` (
  `theatreId` int(11) NOT NULL,
  `theatreName` varchar(30) DEFAULT NULL,
  `timingId` int(11) DEFAULT NULL,
  PRIMARY KEY (`theatreId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES (1,'pvr cyberabad',1),(2,'PVR Galleria Mall',3),(3,'BR Hitech Theatre',2),(4,'PVR Inorbit Mall',4);
/*!40000 ALTER TABLE `theatre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theatrebymovie`
--

DROP TABLE IF EXISTS `theatrebymovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `theatrebymovie` (
  `theatreId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatrebymovie`
--

LOCK TABLES `theatrebymovie` WRITE;
/*!40000 ALTER TABLE `theatrebymovie` DISABLE KEYS */;
INSERT INTO `theatrebymovie` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,2),(2,3),(2,4),(3,1),(3,2),(3,3),(3,4),(4,1),(4,2),(4,3),(4,4);
/*!40000 ALTER TABLE `theatrebymovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `theatrewithshow`
--

DROP TABLE IF EXISTS `theatrewithshow`;
/*!50001 DROP VIEW IF EXISTS `theatrewithshow`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `theatrewithshow` AS SELECT 
 1 AS `theatreId`,
 1 AS `theatreName`,
 1 AS `show1`,
 1 AS `show2`,
 1 AS `show3`,
 1 AS `show4`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `theatrewithshow`
--

/*!50001 DROP VIEW IF EXISTS `theatrewithshow`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `theatrewithshow` AS select `t`.`theatreId` AS `theatreId`,`t`.`theatreName` AS `theatreName`,`s`.`show1` AS `show1`,`s`.`show2` AS `show2`,`s`.`show3` AS `show3`,`s`.`show4` AS `show4` from (`theatre` `t` join `showtiming` `s` on((`t`.`timingId` = `s`.`timingId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-22 18:00:00
