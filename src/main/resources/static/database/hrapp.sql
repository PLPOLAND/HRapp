-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 20 Paź 2019, 10:34
-- Wersja serwera: 5.7.27-0ubuntu0.18.04.1
-- Wersja PHP: 7.2.19-0ubuntu0.18.04.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `hrapp`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Permissions`
--

DROP TABLE IF EXISTS `Permissions`;
CREATE TABLE `Permissions` (
  `ID` int(11) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Stanowiska`
--

DROP TABLE IF EXISTS `Stanowiska`;
CREATE TABLE `Stanowiska` (
  `ID_s` int(11) NOT NULL,
  `Nazwa` text NOT NULL,
  `NazwaSkr` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `TypyUmowy`
--

DROP TABLE IF EXISTS `TypyUmowy`;
CREATE TABLE `TypyUmowy` (
  `ID_T` int(11) NOT NULL,
  `nazwaSkr` text NOT NULL,
  `nazwa` text NOT NULL,
  `podatek` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Users`
--

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `nickname` text NOT NULL,
  `email` text NOT NULL,
  `pass` text NOT NULL,
  `oldpass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `UsersData`
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
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `Permissions`
--
ALTER TABLE `Permissions`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `Stanowiska`
--
ALTER TABLE `Stanowiska`
  ADD PRIMARY KEY (`ID_s`);

--
-- Indeksy dla tabeli `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  ADD PRIMARY KEY (`ID_T`);

--
-- Indeksy dla tabeli `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);

--
-- Indeksy dla tabeli `UsersData`
--
ALTER TABLE `UsersData`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TypUmowy` (`id_t_u`),
  ADD KEY `Stanowisko` (`id_s`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `Permissions`
--
ALTER TABLE `Permissions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `Stanowiska`
--
ALTER TABLE `Stanowiska`
  MODIFY `ID_s` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  MODIFY `ID_T` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `Permissions`
--
ALTER TABLE `Permissions`
  ADD CONSTRAINT `Permissions_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`);

--
-- Ograniczenia dla tabeli `UsersData`
--
ALTER TABLE `UsersData`
  ADD CONSTRAINT `Stanowisko` FOREIGN KEY (`id_s`) REFERENCES `Stanowiska` (`ID_s`),
  ADD CONSTRAINT `TypUmowy` FOREIGN KEY (`id_t_u`) REFERENCES `TypyUmowy` (`ID_T`),
  ADD CONSTRAINT `UsersData_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
