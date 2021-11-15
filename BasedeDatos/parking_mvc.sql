-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 26, 2021 at 02:44 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parking_mvc`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cliente`
--

CREATE TABLE `Cliente` (
  `Identificacion` int(11) NOT NULL,
  `NombresCompletos` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroTelefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `CorreoElectronico` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Parqueadero`
--

CREATE TABLE `Parqueadero` (
  `Id` int(11) NOT NULL,
  `CuposTotales` int(11) NOT NULL,
  `CuposDisponibles` int(11) NOT NULL,
  `CuposReservados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Vehiculo`
--

CREATE TABLE `Vehiculo` (
  `Placa` varchar(6) COLLATE utf8_spanish_ci NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdParqueadero` int(11) NOT NULL,
  `Marca` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Color` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Modelo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Estado` int(11) NOT NULL,
  `HoraIngreso` datetime NOT NULL,
  `HoraSalida` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`Identificacion`);

--
-- Indexes for table `Parqueadero`
--
ALTER TABLE `Parqueadero`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `Vehiculo`
--
ALTER TABLE `Vehiculo`
  ADD PRIMARY KEY (`Placa`),
  ADD KEY `fk_cv` (`IdCliente`),
  ADD KEY `Fk_vp` (`IdParqueadero`) USING BTREE;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Vehiculo`
--
ALTER TABLE `Vehiculo`
  ADD CONSTRAINT `Fk_vc` FOREIGN KEY (`IdParqueadero`) REFERENCES `Parqueadero` (`Id`),
  ADD CONSTRAINT `fk_cv` FOREIGN KEY (`IdCliente`) REFERENCES `Cliente` (`Identificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
