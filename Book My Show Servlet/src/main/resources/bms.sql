-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 25, 2019 at 04:29 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bms`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `bookingId` int(11) NOT NULL,
  `movieId` int(11) DEFAULT NULL,
  `theatreId` int(11) DEFAULT NULL,
  `showtiming` time DEFAULT NULL,
  `showDate` date DEFAULT NULL,
  `ticketsBooked` int(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `cityId` int(11) NOT NULL,
  `cityName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`cityId`, `cityName`) VALUES
(1, 'Hyderabad');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `pincode` int(11) NOT NULL,
  `cityId` int(11) DEFAULT NULL,
  `areaName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`pincode`, `cityId`, `areaName`) VALUES
(500081, 1, 'Gachibowli'),
(500082, 1, 'Madhapur'),
(500083, 1, 'Raidurgam'),
(500084, 1, 'Kukatpally'),
(500085, 1, 'Ameerpet');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movieId` int(11) NOT NULL,
  `movieName` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movieId`, `movieName`) VALUES
(1, 'war'),
(2, 'joker'),
(3, 'housefull4'),
(4, 'terminator');

-- --------------------------------------------------------

--
-- Table structure for table `moviebylocation`
--

CREATE TABLE `moviebylocation` (
  `movieId` int(11) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `moviebylocation`
--

INSERT INTO `moviebylocation` (`movieId`, `pincode`) VALUES
(1, 500081),
(1, 500082),
(1, 500083),
(1, 500084),
(1, 500085),
(2, 500081),
(2, 500082),
(2, 500083),
(2, 500084),
(2, 500085),
(3, 500081),
(3, 500082),
(3, 500083),
(3, 500084),
(3, 500085),
(4, 500081),
(4, 500082),
(4, 500083),
(4, 500084),
(4, 500085);

-- --------------------------------------------------------

--
-- Table structure for table `pricerange`
--

CREATE TABLE `pricerange` (
  `rangeId` int(11) NOT NULL,
  `tier` varchar(10) DEFAULT NULL,
  `cost` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pricerange`
--

INSERT INTO `pricerange` (`rangeId`, `tier`, `cost`) VALUES
(1, 'silver', 100),
(2, 'gold', 150),
(3, 'platinum', 200);

-- --------------------------------------------------------

--
-- Table structure for table `showtiming`
--

CREATE TABLE `showtiming` (
  `timingId` int(11) NOT NULL,
  `show1` time DEFAULT NULL,
  `show2` time DEFAULT NULL,
  `show3` time DEFAULT NULL,
  `show4` time DEFAULT NULL,
  `availableSeats` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `showtiming`
--

INSERT INTO `showtiming` (`timingId`, `show1`, `show2`, `show3`, `show4`, `availableSeats`) VALUES
(1, '10:00:00', '13:00:00', '18:00:00', '22:00:00', 100),
(2, '11:00:00', '14:00:00', '17:00:00', '21:00:00', 100),
(3, '10:00:00', '14:00:00', '16:00:00', '20:00:00', 100),
(4, '12:00:00', '15:00:00', '18:00:00', '22:15:00', 100);

-- --------------------------------------------------------

--
-- Table structure for table `theatre`
--

CREATE TABLE `theatre` (
  `theatreId` int(11) NOT NULL,
  `theatreName` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `theatre`
--

INSERT INTO `theatre` (`theatreId`, `theatreName`) VALUES
(1, 'pvr cyberabad'),
(2, 'PVR Galleria Mall'),
(3, 'BR Hitech Theatre'),
(4, 'PVR Inorbit Mall');

-- --------------------------------------------------------

--
-- Table structure for table `theatrebymovie`
--

CREATE TABLE `theatrebymovie` (
  `theatreId` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  `timingId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `theatrebymovie`
--

INSERT INTO `theatrebymovie` (`theatreId`, `movieId`, `timingId`) VALUES
(1, 1, 1),
(1, 2, 2),
(1, 3, 3),
(1, 4, 4),
(2, 1, 1),
(2, 2, 2),
(2, 3, 3),
(2, 4, 4),
(3, 1, 1),
(3, 2, 2),
(3, 3, 3),
(3, 4, 4),
(4, 1, 1),
(4, 2, 2),
(4, 3, 3),
(4, 4, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`bookingId`),
  ADD KEY `theatreId` (`theatreId`),
  ADD KEY `movieId` (`movieId`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`cityId`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`pincode`),
  ADD KEY `cityId` (`cityId`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieId`);

--
-- Indexes for table `pricerange`
--
ALTER TABLE `pricerange`
  ADD PRIMARY KEY (`rangeId`);

--
-- Indexes for table `showtiming`
--
ALTER TABLE `showtiming`
  ADD PRIMARY KEY (`timingId`);

--
-- Indexes for table `theatre`
--
ALTER TABLE `theatre`
  ADD PRIMARY KEY (`theatreId`);

--
-- Indexes for table `theatrebymovie`
--
ALTER TABLE `theatrebymovie`
  ADD KEY `timingId` (`timingId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `bookingId` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
