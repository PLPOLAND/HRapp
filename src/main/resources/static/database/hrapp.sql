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
(1, 'Programista', 'Prog'),(2,'Ksiegowy', 'Ks'),(3,'Manager', 'Mng'),(4,'Sprzatacz', 'Sprz');

-- --------------------------------------------------------

--
-- Table structure for table `TypyUmowy`
--

DROP TABLE IF EXISTS `TypyUmowy`;
CREATE TABLE `TypyUmowy` (
  `ID_T` int(11) NOT NULL,
  `nazwaSkr` text NOT NULL,
  `nazwa` text NOT NULL,
  `funduszPracy` float DEFAULT 0.0,
  `ubWypadkowe` float DEFAULT 0.0,
  `ubRentowePracodawca` float DEFAULT 0.0,
  `ubRentowePracownik` float DEFAULT 0.0,
  `ubEmerytalnePracodawca` float DEFAULT 0.0,
  `ubEmerytalnePracownik` float DEFAULT 0.0,
  `ubChorobowe` float DEFAULT 0.0,
  `ubZdrowotne` float DEFAULT 0.0,
  `zaliczkaPIT` float DEFAULT 0.0,
  `FGSP` float DEFAULT 0.0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TypyUmowy`
--

INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`, `nazwa`, `funduszPracy`, `UbWypadkowe`,`ubRentowePracodawca`, `ubRentowePracownik`,`ubEmerytalnePracodawca`,`ubEmerytalnePracownik`,`ubChorobowe`,`ubZdrowotne`,`zaliczkaPIT`) VALUES
(1, 'UoP', 'Umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 3.65);

INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`,`nazwa`,`ubWypadkowe`) VALUES (2,'UnZ', 'Umowa na zlecenie', 1.64);
INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`,`nazwa`,`zaliczkaPIT`) VALUES (3,'UoD', 'Umowa o Dzielo', 13.6);

INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`, `nazwa`, `funduszPracy`, `ubWypadkowe`,`ubRentowePracodawca`, `ubRentowePracownik`,`ubEmerytalnePracodawca`,`ubEmerytalnePracownik`,`ubChorobowe`,`ubZdrowotne`,`zaliczkaPIT`,`FGSP`) VALUES
(4, 'UoPiUnZ', 'Umowa na zlecenie z umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 5.05,0.08), (5, 'UoPiUoD', 'Umowa o dzielo z umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 5.05, 0.08);
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
  `pesel` decimal(11) NOT NULL,
  `nrTelefonu` decimal(11) NOT NULL,
  `dataUrodzenia` date NOT NULL,
  `kontoBankowe` text NOT NULL,
  `wyplataBrutto` double NOT NULL,
  `id_s` int(11) NOT NULL,
  `id_t_u` int(11) NOT NULL,
  `ulica` text NOT NULL,
  `nrDomu` text NOT NULL,
  `nrMieszkania` int(5) DEFAULT 0,
  `miasto` text NOT NULL,
  `kodPocztowy` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UsersData`
--

INSERT INTO `UsersData` (`ID`, `imie`, `nazwisko`,`pesel`,`nrTelefonu`,`dataUrodzenia`, `kontoBankowe`, `wyplataBrutto`, `id_s`, `id_t_u`,`ulica`,`nrDomu`,`nrMieszkania`,`miasto`,`kodPocztowy`) VALUES
(1, 'Marek', 'Pałdyna', 98072694616, 678567467, '1998-07-26','25213129921111580206782827', 8000, 1, 1, 'Malinowa', 11, NULL, 'Warszawa', '03-234'),
(2, 'Adam', 'Mickiewicz', 57072558199, 999333000, '1957-07-25', '22345642126845567534542247', 4000, 1, 1, 'Przekatna',34,109,'Warszawa', '05-345');

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
-- AUTO_INCREMENT for table `Stanowiska`
--
ALTER TABLE `Stanowiska`
  MODIFY `ID_s` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  MODIFY `ID_T` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
