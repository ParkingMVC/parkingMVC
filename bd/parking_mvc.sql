-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-11-2021 a las 01:42:45
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parking_mvc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Identificacion` int(11) NOT NULL,
  `NombresCompletos` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroTelefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `CorreoElectronico` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Identificacion`, `NombresCompletos`, `NumeroTelefono`, `CorreoElectronico`, `Direccion`) VALUES
(1, 'Pedro Picapiedra', '1234567', 'pedro@piedradura.com', 'Bedrock'),
(235246, 'sdgshgh', '344256', 'sdGsgrs', 'srtsrt4542'),
(532234, 'Alejandro', '4589566523', 'dgs@dgfsg.com', 'cll 57 55'),
(1234995, 'Jeferson', '224466665', 'dgs@sfgsg.com', 'crr 45 99'),
(2345566, 'sdgsfg', '4254636', 'fshfshfsd', 'sw435tgghdh'),
(62787394, 'Juan', '4583225', 'daflkd@dlk.com', 'cll 23'),
(98665424, 'Carlos Mario', '6042345412', 'inventado@gmail.com', 'Calle 123 # 81 12'),
(352465346, 'yepes', '245426242', 'adgsdg@dgg.com', 'cr 78 2554'),
(435246423, 'Paula', '546153', 'asrfaefe@fdg.com', 'crr 78 52'),
(642345453, 'Jorge', '25634363475', 'zdf@sfgfgg.com', 'crr 243 842');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parqueadero`
--

CREATE TABLE `parqueadero` (
  `Id` int(11) NOT NULL,
  `CuposTotales` int(11) NOT NULL,
  `CuposDisponibles` int(11) NOT NULL,
  `CuposReservados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `parqueadero`
--

INSERT INTO `parqueadero` (`Id`, `CuposTotales`, `CuposDisponibles`, `CuposReservados`) VALUES
(1, 20, 19, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `Placa` varchar(6) COLLATE utf8_spanish_ci NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdParqueadero` int(11) NOT NULL,
  `Marca` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Color` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Modelo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Estado` int(11) NOT NULL,
  `HoraIngreso` datetime NOT NULL,
  `HoraSalida` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`Placa`, `IdCliente`, `IdParqueadero`, `Marca`, `Color`, `Modelo`, `Estado`, `HoraIngreso`, `HoraSalida`) VALUES
('111aaa', 235246, 1, 'Mazda', 'Blanco', 'Serie 3 2020', 0, '2021-11-21 14:00:00', '2021-11-21 22:15:50'),
('111bbb', 2345566, 1, 'Chevrolet', 'Blanco', 'Corsa 1999', 0, '2021-11-21 14:22:10', '2021-11-21 22:17:01'),
('123pru', 98665424, 1, 'Volvo', 'Gris plateado', 'Recharge 2015', 0, '2021-11-21 10:15:41', '2021-11-21 22:26:09'),
('123ROK', 1, 1, 'Rocamovil', 'Cafe', 'Rock 10000 AC', 1, '2021-11-20 12:15:00', '2021-11-20 23:31:00'),
('555fff', 1234995, 1, 'Toyota', 'Gris', 'Corolla 2018', 1, '2021-11-21 13:44:34', '2021-11-21 16:03:06'),
('644tre', 642345453, 1, 'Toyota', 'Plateado', 'Fortuner 2018', 1, '2021-11-21 13:33:05', '2021-11-21 21:35:19'),
('987qwe', 352465346, 1, 'Volvo', 'Azul', 'XC40 2017', 1, '2021-11-21 13:02:45', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Identificacion`);

--
-- Indices de la tabla `parqueadero`
--
ALTER TABLE `parqueadero`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`Placa`),
  ADD KEY `fk_cv` (`IdCliente`),
  ADD KEY `Fk_vp` (`IdParqueadero`) USING BTREE;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `Fk_vc` FOREIGN KEY (`IdParqueadero`) REFERENCES `parqueadero` (`Id`),
  ADD CONSTRAINT `fk_cv` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Identificacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
