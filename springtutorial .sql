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
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(60) NOT NULL,
  `authority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('fatiha', 'ROLE_ADMIN'),
('lupin', 'ROLE_USER'),
('obin', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE IF NOT EXISTS `notices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `text` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`id`, `name`, `email`, `text`) VALUES
(1, 'Tanzim', 'tahmid.tanzim@gmail.com', 'Alerts don''t have default classes, only base and modifier classes. A default gray alert doesn''t make too much sense, so you''re required to specify a type via contextual class. Choose from success, info, warning, or danger.'),
(2, 'Hasina', 'hasina@yahoo.com', 'Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(60) NOT NULL,
  `password` varchar(80) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `email`,`enabled`) VALUES
('fatiha', 'fatiha', 'fatiha@gmail.com', 1),
('lupin', 'lupin', 'lupin@yahoo.com', 1),
('obin', 'obin', 'obin@live.com', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
