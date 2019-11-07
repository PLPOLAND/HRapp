-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 07, 2019 at 07:16 PM
-- Server version: 5.7.27-0ubuntu0.18.04.1
-- PHP Version: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `Permissions`
--

DROP TABLE IF EXISTS `Permissions`;
CREATE TABLE `Permissions` (
  `ID` int(11) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Permissions`
--

INSERT INTO `Permissions` (`ID`, `admin`) VALUES
(1, 1),
(2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `Stanowiska`
--

DROP TABLE IF EXISTS `Stanowiska`;
CREATE TABLE `Stanowiska` (
  `ID_s` int(11) NOT NULL,
  `Nazwa` text NOT NULL,
  `NazwaSkr` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Stanowiska`
--

INSERT INTO `Stanowiska` (`ID_s`, `Nazwa`, `NazwaSkr`) VALUES
(1, 'Programista', 'Prog');

-- --------------------------------------------------------

--
-- Table structure for table `TypyUmowy`
--

DROP TABLE IF EXISTS `TypyUmowy`;
CREATE TABLE `TypyUmowy` (
  `ID_T` int(11) NOT NULL,
  `nazwaSkr` text NOT NULL,
  `nazwa` text NOT NULL,
  `podatek` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TypyUmowy`
--

INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`, `nazwa`, `podatek`) VALUES
(1, 'UoP', 'Umowa o prace', 0.15);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `nickname` text NOT NULL,
  `email` text NOT NULL,
  `pass` text NOT NULL,
  `oldpass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`ID`, `nickname`, `email`, `pass`, `oldpass`) VALUES
(1, 'PLPOLAND', 'marekpaldyna@wp.pl', 'Makowiec1', ''),
(2, 'Kozak', 'kozak@gmail.com', 'Kozak1', 'Kozak1');

-- --------------------------------------------------------

--
-- Table structure for table `UsersData`
--

DROP TABLE IF EXISTS `UsersData`;
CREATE TABLE `UsersData` (
  `ID` int(11) NOT NULL,
  `imie` text NOT NULL,
  `nazwisko` text NOT NULL,
  `kontoBankowe` text NOT NULL,
  `wyplataBrutto` double NOT NULL,
  `id_s` int(11) NOT NULL,
  `id_t_u` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UsersData`
--

INSERT INTO `UsersData` (`ID`, `imie`, `nazwisko`, `kontoBankowe`, `wyplataBrutto`, `id_s`, `id_t_u`) VALUES
(1, 'Marek', 'Pałdyna', '25213129921111580206782827', 8000, 1, 1),
(2, 'Adam', 'Mickiewicz', '22345642126845567534542247', 4000, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Permissions`
--
ALTER TABLE `Permissions`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Stanowiska`
--
ALTER TABLE `Stanowiska`
  ADD PRIMARY KEY (`ID_s`);

--
-- Indexes for table `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  ADD PRIMARY KEY (`ID_T`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `UsersData`
--
ALTER TABLE `UsersData`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TypUmowy` (`id_t_u`),
  ADD KEY `Stanowisko` (`id_s`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Permissions`
--
ALTER TABLE `Permissions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `Stanowiska`
--
ALTER TABLE `Stanowiska`
  MODIFY `ID_s` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  MODIFY `ID_T` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Permissions`
--
ALTER TABLE `Permissions`
  ADD CONSTRAINT `Permissions_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`);

--
-- Constraints for table `UsersData`
--
ALTER TABLE `UsersData`
  ADD CONSTRAINT `Stanowisko` FOREIGN KEY (`id_s`) REFERENCES `Stanowiska` (`ID_s`),
  ADD CONSTRAINT `TypUmowy` FOREIGN KEY (`id_t_u`) REFERENCES `TypyUmowy` (`ID_T`),
  ADD CONSTRAINT `UsersData_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
