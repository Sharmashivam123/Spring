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
  `bookingId` int(255) NOT NULL AUTO_INCREMENT,
  `movieId` int(11) DEFAULT NULL,
  `theatreId` int(11) DEFAULT NULL,
  `showtiming` time DEFAULT NULL,
  `showDate` date DEFAULT NULL,
  `ticketBooked` int(11) DEFAULT NULL,
  `seatId` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `movieId` (`movieId`),
  KEY `theatreId` (`theatreId`),
  CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movie` (`movieId`),
  CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`theatreId`) REFERENCES `theatre` (`theatreId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (32,1,1,'18:00:00','2019-11-07',2,'A1 B1 '),(33,1,1,'18:00:00','2019-11-07',2,'A1 B1 '),(34,1,1,'18:00:00','2019-11-08',3,'A2 B6 C5 '),(35,1,1,'22:00:00','2019-11-08',3,'A2 B4 C4 '),(36,1,1,'22:00:00','2019-11-08',3,'A2 B4 C4 '),(37,1,1,'22:00:00','2019-11-08',4,'A10 A4 B4 C3 ');
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
-- Table structure for table `seatarrangements`
--

DROP TABLE IF EXISTS `seatarrangements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seatarrangements` (
  `seatId` varchar(4) NOT NULL,
  `Tier` varchar(20) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  PRIMARY KEY (`seatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seatarrangements`
--

LOCK TABLES `seatarrangements` WRITE;
/*!40000 ALTER TABLE `seatarrangements` DISABLE KEYS */;
INSERT INTO `seatarrangements` VALUES ('A1','silver',150),('A10','silver',150),('A2','silver',150),('A3','silver',150),('A4','silver',150),('A5','silver',150),('A6','silver',150),('A7','silver',150),('A8','silver',150),('A9','silver',150),('B1','gold',200),('B10','gold',200),('B2','gold',200),('B3','gold',200),('B4','gold',200),('B5','gold',200),('B6','gold',200),('B7','gold',200),('B8','gold',200),('B9','gold',200),('C1','platinum',250),('C10','platinum',250),('C2','platinum',250),('C3','platinum',250),('C4','platinum',250),('C5','platinum',250),('C6','platinum',250),('C7','platinum',250),('C8','platinum',250),('C9','platinum',250);
/*!40000 ALTER TABLE `seatarrangements` ENABLE KEYS */;
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
  PRIMARY KEY (`theatreId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatre`
--

LOCK TABLES `theatre` WRITE;
/*!40000 ALTER TABLE `theatre` DISABLE KEYS */;
INSERT INTO `theatre` VALUES (1,'pvr cyberabad'),(2,'PVR Galleria Mall'),(3,'BR Hitech Theatre'),(4,'PVR Inorbit Mall');
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
  `movieId` int(11) NOT NULL,
  `timingId` int(11) DEFAULT NULL,
  KEY `timingId` (`timingId`),
  CONSTRAINT `theatrebymovie_ibfk_1` FOREIGN KEY (`timingId`) REFERENCES `showtiming` (`timingId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theatrebymovie`
--

LOCK TABLES `theatrebymovie` WRITE;
/*!40000 ALTER TABLE `theatrebymovie` DISABLE KEYS */;
INSERT INTO `theatrebymovie` VALUES (1,1,1),(1,2,2),(1,3,3),(1,4,4),(2,1,1),(2,2,2),(2,3,3),(2,4,4),(3,1,1),(3,2,2),(3,3,3),(3,4,4),(4,1,1),(4,2,2),(4,3,3),(4,4,4);
/*!40000 ALTER TABLE `theatrebymovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `ticketreport`
--

DROP TABLE IF EXISTS `ticketreport`;
/*!50001 DROP VIEW IF EXISTS `ticketreport`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ticketreport` AS SELECT 
 1 AS `fullName`,
 1 AS `phone`,
 1 AS `bookingId`,
 1 AS `movieName`,
 1 AS `showtiming`,
 1 AS `showDate`,
 1 AS `ticketBooked`,
 1 AS `seatId`,
 1 AS `totalCost`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `userdetails`
--

DROP TABLE IF EXISTS `userdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdetails` (
  `phone` varchar(10) DEFAULT NULL,
  `fullName` varchar(30) DEFAULT NULL,
  `bookingId` int(255) DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  KEY `bookingId_idx` (`bookingId`),
  CONSTRAINT `bookingId` FOREIGN KEY (`bookingId`) REFERENCES `bookings` (`bookingId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetails`
--

LOCK TABLES `userdetails` WRITE;
/*!40000 ALTER TABLE `userdetails` DISABLE KEYS */;
INSERT INTO `userdetails` VALUES ('9691061996','shivam',32,300),('9691061996','shivam',33,385.85999999999996),('9691061996','shivam sharma',34,819.9347999999999),('9691061996','shivam sharma',35,819.9347999999999),('9691061996','shivam sharma',36,819.9347999999999),('9681348871','sumit trivedi',37,1110.7514639999997);
/*!40000 ALTER TABLE `userdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `ticketreport`
--

/*!50001 DROP VIEW IF EXISTS `ticketreport`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ticketreport` AS select `userdetails`.`fullName` AS `fullName`,`userdetails`.`phone` AS `phone`,`bookings`.`bookingId` AS `bookingId`,`movie`.`movieName` AS `movieName`,`bookings`.`showtiming` AS `showtiming`,`bookings`.`showDate` AS `showDate`,`bookings`.`ticketBooked` AS `ticketBooked`,`bookings`.`seatId` AS `seatId`,`userdetails`.`totalCost` AS `totalCost` from ((`movie` join `userdetails`) join `bookings`) where ((`bookings`.`movieId` = `movie`.`movieId`) and (`bookings`.`bookingId` = `userdetails`.`bookingId`)) */;
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

-- Dump completed on 2019-11-08 23:04:25
