-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 15, 2015 at 10:24 PM
-- Server version: 5.5.44-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `springtutorial`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `authority` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`name`, `username`, `password`, `email`, `authority`, `enabled`) VALUES
('Kazi Fatiha', 'fatiha', 'f35c314fabec38e90b1e3fc0242d8a14fb32b3261276e282590736bf13fe699a937b47e47c3646ba', 'fatiha@gmail.com', 'ROLE_ADMIN', 1),
('Tahmid Tanzim', 'lupin', '22b2a991a55ddb0cf9fc84ee866c5763fe6f9e4957cc9ac68687a2ec4598871a4775e51a5c348dda', 'lupin@yahoo.com', 'ROLE_USER', 1),
('Tahmid Tahsan', 'obin', '123d04ebdd92e771308c97eb954c19585ab653c307f20690d4017d5b1cdd314fd4f892ff18d45ba7', 'obin123@live.com', 'ROLE_USER', 1);

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE IF NOT EXISTS `notices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text,
  `username` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`username`) REFERENCES `users`(`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`id`, `text`, `username`) VALUES
(1, 'Alerts dont have default classes, only base and modifier classes. A default gray alert doesnt make too much sense,.', 'fatiha'),
(2, 'So you''re required to specify a type via contextual class. Choose from success, info, warning, or danger', 'fatiha'),
(3, 'Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.', 'lupin');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `name` varchar(100) DEFAULT 'Anonymous',
  `email` varchar(60),
  `username` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`username`) REFERENCES `users`(`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
