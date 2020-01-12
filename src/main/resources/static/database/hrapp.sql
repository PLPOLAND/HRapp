-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 24 Lis 2019, 16:05
-- Wersja serwera: 5.7.28-0ubuntu0.18.04.4
-- Wersja PHP: 7.2.24-0ubuntu0.18.04.1

ALTER DATABASE hrapp DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
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
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `add_user` tinyint(1) NOT NULL DEFAULT '0',
  `del_user` tinyint(1) NOT NULL DEFAULT '0',
  `edit_user` tinyint(1) NOT NULL DEFAULT '0',
  `show_all_users` tinyint(1) NOT NULL DEFAULT '0',
  `show_d_data` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `Permissions`
--

INSERT INTO `Permissions` (`ID`, `admin`, `add_user`, `del_user`, `edit_user`, `show_all_users`, `show_d_data`) VALUES
(1, 1, 0, 0, 0, 0, 0),
(2, 1, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 1, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Stanowiska`
--

DROP TABLE IF EXISTS `Stanowiska`;
CREATE TABLE `Stanowiska` (
  `ID_s` int(11) NOT NULL,
  `Nazwa` text NOT NULL,
  `NazwaSkr` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `Stanowiska`
--

INSERT INTO `Stanowiska` (`ID_s`, `Nazwa`, `NazwaSkr`) VALUES
(1, 'Programista', 'Prog'),
(2, 'Ksiegowy', 'Ks'),
(3, 'Manager', 'Mng'),
(4, 'Sprzatacz', 'Sprz');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `TypyUmowy`
--

DROP TABLE IF EXISTS `TypyUmowy`;
CREATE TABLE `TypyUmowy` (
  `ID_T` int(11) NOT NULL,
  `nazwaSkr` text NOT NULL,
  `nazwa` text NOT NULL,
  `funduszPracy` float DEFAULT '0',
  `ubWypadkowe` float DEFAULT '0',
  `ubRentowePracodawca` float DEFAULT '0',
  `ubRentowePracownik` float DEFAULT '0',
  `ubEmerytalnePracodawca` float DEFAULT '0',
  `ubEmerytalnePracownik` float DEFAULT '0',
  `ubChorobowe` float DEFAULT '0',
  `ubZdrowotne` float DEFAULT '0',
  `zaliczkaPIT` float DEFAULT '0',
  `FGSP` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `TypyUmowy`
--

INSERT INTO `TypyUmowy` (`ID_T`, `nazwaSkr`, `nazwa`, `funduszPracy`, `ubWypadkowe`, `ubRentowePracodawca`, `ubRentowePracownik`, `ubEmerytalnePracodawca`, `ubEmerytalnePracownik`, `ubChorobowe`, `ubZdrowotne`, `zaliczkaPIT`, `FGSP`) VALUES
(1, 'UoP', 'Umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 3.65, 0.08),
(2, 'UnZ', 'Umowa na zlecenie', 0, 1.64, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 'UoD', 'Umowa o Dzielo', 0, 0, 0, 0, 0, 0, 0, 0, 13.6, 0),
(4, 'UoPiUnZ', 'Umowa na zlecenie z umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 5.05, 0.08),
(5, 'UoPiUoD', 'Umowa o dzielo z umowa o prace', 2.03, 1.39, 5.4, 1.5, 8.1, 9.76, 2.45, 7.77, 5.05, 0.08);

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

--
-- Zrzut danych tabeli `Users`
--

INSERT INTO `Users` (`ID`, `nickname`, `email`, `pass`, `oldpass`) VALUES
(1, 'PLPOLAND', 'marekpaldyna@wp.pl', 'Makowiec1', ''),
(2, 'Kozak', 'kozak@gmail.com', 'Kozak1', 'Kozak1'),
(3, 'Kupidyn', 'Lucja@maj.com', 'Kupidyn', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `UsersData`
--

DROP TABLE IF EXISTS `UsersData`;
CREATE TABLE `UsersData` (
  `ID` int(11) NOT NULL,
  `imie` text NOT NULL,
  `nazwisko` text NOT NULL,
  `pesel` decimal(11,0) NOT NULL,
  `nrTelefonu` decimal(11,0) NOT NULL,
  `dataUrodzenia` date NOT NULL,
  `kontoBankowe` text NOT NULL,
  `wyplataBrutto` double NOT NULL,
  `id_s` int(11) NOT NULL,
  `id_t_u` int(11) NOT NULL,
  `ulica` text NOT NULL,
  `nrDomu` text NOT NULL,
  `nrMieszkania` int(5) DEFAULT '0',
  `miasto` text NOT NULL,
  `kodPocztowy` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `UsersData`
--

INSERT INTO `UsersData` (`ID`, `imie`, `nazwisko`, `pesel`, `nrTelefonu`, `dataUrodzenia`, `kontoBankowe`, `wyplataBrutto`, `id_s`, `id_t_u`, `ulica`, `nrDomu`, `nrMieszkania`, `miasto`, `kodPocztowy`) VALUES
(1, 'Marek', 'Patus', '98072694616', '678567467', '1998-03-21', '25213129921111580206782827', 80, 1, 1, 'Malinowa', '11', 0, 'Warszawa', '03-234'),
(2, 'Adam', 'Mickiewicz', '57072558199', '999333000', '1957-07-25', '22345642126845567534542247', 40, 1, 1, 'Przekatna', '34', 109, 'Warszawa', '05-345'),
(3, 'Danuta', 'Kowalczyk', '87982998443', '506849985', '2000-02-08', '7865486548965458965', 90, 2, 3, 'Konikowa', '59', 5, 'Konin', '02-945');


- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Wyplaty`
--

DROP TABLE IF EXISTS `Wyplaty`;
CREATE TABLE `Wyplaty` (
  `ID_w` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `dataOd` date NOT NULL,
  `dataDo` date NOT NULL,
  `dataZaksiegowania` date NOT NULL,
  `kwotaBrutto` double NOT NULL,
  `przepracowaneGodziny` int(11) NOT NULL
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
-- Indeksy dla tabeli `Wyplaty`
--
ALTER TABLE `Wyplaty`
  ADD PRIMARY KEY (`ID_w`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `Stanowiska`
--
ALTER TABLE `Stanowiska`
  MODIFY `ID_s` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT dla tabeli `TypyUmowy`
--
ALTER TABLE `TypyUmowy`
  MODIFY `ID_T` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT dla tabeli `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT dla tabeli `Wyplaty`
--
ALTER TABLE `Wyplaty`
  MODIFY `ID_w` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `Permissions`
--
ALTER TABLE `Permissions`
  ADD CONSTRAINT `Permissions_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`) ON DELETE CASCADE;

--
-- Ograniczenia dla tabeli `UsersData`
--
ALTER TABLE `UsersData`
  ADD CONSTRAINT `Stanowisko` FOREIGN KEY (`id_s`) REFERENCES `Stanowiska` (`ID_s`),
  ADD CONSTRAINT `TypUmowy` FOREIGN KEY (`id_t_u`) REFERENCES `TypyUmowy` (`ID_T`),
  ADD CONSTRAINT `UsersData_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`) ON DELETE CASCADE;

  --
-- Ograniczenia dla tabeli `Wyplaty`
--
ALTER TABLE `Wyplaty`
  ADD CONSTRAINT `Wyplaty_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `Users` (`ID`) ON DELETE CASCADE;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
