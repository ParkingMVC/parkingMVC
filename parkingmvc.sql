-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-10-2021 a las 06:13:00
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `parkingmvc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `par_tblclientescab`
--

CREATE TABLE `par_tblclientescab` (
  `IdRows` int(11) NOT NULL,
  `NombresCompletos` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Identificacion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroTelefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `CorreoElectronico` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `FechaCreacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `par_tblclientescab`
--

INSERT INTO `par_tblclientescab` (`IdRows`, `NombresCompletos`, `Identificacion`, `NumeroTelefono`, `CorreoElectronico`, `Direccion`, `FechaCreacion`) VALUES
(1, 'Carlos Andrés Vélez', '10480457', '3124567889', 'cvelez@gmail.com', 'Cr20#32-45', '2021-10-20 21:55:46'),
(2, 'Daniel Diaz', '98989898', '987987987', 'daniel@gmail.com', 'Cr22#33-54', '2021-10-20 21:55:46'),
(3, 'Juan Esteban Correa', '212165', '3124567123', 'juesteban@gmail.com', 'Cr21#34-85', '2021-10-20 21:55:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `par_tblclienteslin`
--

CREATE TABLE `par_tblclienteslin` (
  `IdRows` int(11) NOT NULL,
  `IdRowClientesCab` int(11) NOT NULL,
  `IdRowVehiculos` int(11) NOT NULL,
  `Marca` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Color` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Modelo` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Placa` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FechaCreacion` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `par_tblclienteslin`
--

INSERT INTO `par_tblclienteslin` (`IdRows`, `IdRowClientesCab`, `IdRowVehiculos`, `Marca`, `Color`, `Modelo`, `Placa`, `FechaCreacion`) VALUES
(1, 1, 1, 'Chevrolet', 'Red', '2021', 'UYT654', '2021-10-20 21:55:46'),
(2, 1, 2, 'Honda', 'Blue', '2018', 'POU52F', '2021-10-20 21:55:46'),
(3, 2, 2, 'Yamaha', 'Red', '2009', 'NIL83B', '2021-10-20 21:55:46'),
(4, 3, 3, 'Pinarello', 'Black', '2020', '2156', '2021-10-20 21:55:46');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `par_tblcontrolhorario`
--

CREATE TABLE `par_tblcontrolhorario` (
  `IdRows` int(11) NOT NULL,
  `IdRowClientesLin` int(11) NOT NULL,
  `IdRowPosicion` int(11) NOT NULL,
  `FechaIngreso` datetime NOT NULL,
  `FechaSalida` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `par_tblcontrolhorario`
--

INSERT INTO `par_tblcontrolhorario` (`IdRows`, `IdRowClientesLin`, `IdRowPosicion`, `FechaIngreso`, `FechaSalida`) VALUES
(1, 1, 2, '2021-10-20 21:55:46', NULL),
(2, 2, 3, '2021-10-20 21:55:46', NULL),
(3, 3, 6, '2021-10-20 21:55:46', NULL),
(4, 4, 9, '2021-10-20 21:55:46', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `par_tblposicion`
--

CREATE TABLE `par_tblposicion` (
  `IdRows` int(11) NOT NULL,
  `Posicion` int(11) NOT NULL,
  `Estado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `par_tblposicion`
--

INSERT INTO `par_tblposicion` (`IdRows`, `Posicion`, `Estado`) VALUES
(1, 1, b'0'),
(2, 2, b'1'),
(3, 3, b'1'),
(4, 4, b'0'),
(5, 5, b'0'),
(6, 6, b'1'),
(7, 7, b'0'),
(8, 8, b'0'),
(9, 9, b'1'),
(10, 10, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `par_tblvehiculos`
--

CREATE TABLE `par_tblvehiculos` (
  `IdRows` int(11) NOT NULL,
  `TipoVehiculo` varchar(15) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `par_tblvehiculos`
--

INSERT INTO `par_tblvehiculos` (`IdRows`, `TipoVehiculo`) VALUES
(1, 'Car'),
(2, 'MotorBike'),
(3, 'Bike');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `par_tblclientescab`
--
ALTER TABLE `par_tblclientescab`
  ADD PRIMARY KEY (`IdRows`);

--
-- Indices de la tabla `par_tblclienteslin`
--
ALTER TABLE `par_tblclienteslin`
  ADD PRIMARY KEY (`IdRows`),
  ADD KEY `IdRowClientesCab` (`IdRowClientesCab`),
  ADD KEY `IdRowVehiculos` (`IdRowVehiculos`);

--
-- Indices de la tabla `par_tblcontrolhorario`
--
ALTER TABLE `par_tblcontrolhorario`
  ADD PRIMARY KEY (`IdRows`),
  ADD KEY `IdRowClientesLin` (`IdRowClientesLin`),
  ADD KEY `IdRowPosicion` (`IdRowPosicion`);

--
-- Indices de la tabla `par_tblposicion`
--
ALTER TABLE `par_tblposicion`
  ADD PRIMARY KEY (`IdRows`);

--
-- Indices de la tabla `par_tblvehiculos`
--
ALTER TABLE `par_tblvehiculos`
  ADD PRIMARY KEY (`IdRows`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `par_tblclientescab`
--
ALTER TABLE `par_tblclientescab`
  MODIFY `IdRows` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `par_tblclienteslin`
--
ALTER TABLE `par_tblclienteslin`
  MODIFY `IdRows` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `par_tblcontrolhorario`
--
ALTER TABLE `par_tblcontrolhorario`
  MODIFY `IdRows` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `par_tblposicion`
--
ALTER TABLE `par_tblposicion`
  MODIFY `IdRows` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `par_tblvehiculos`
--
ALTER TABLE `par_tblvehiculos`
  MODIFY `IdRows` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `par_tblclienteslin`
--
ALTER TABLE `par_tblclienteslin`
  ADD CONSTRAINT `par_tblclienteslin_ibfk_1` FOREIGN KEY (`IdRowClientesCab`) REFERENCES `par_tblclientescab` (`IdRows`),
  ADD CONSTRAINT `par_tblclienteslin_ibfk_2` FOREIGN KEY (`IdRowVehiculos`) REFERENCES `par_tblvehiculos` (`IdRows`);

--
-- Filtros para la tabla `par_tblcontrolhorario`
--
ALTER TABLE `par_tblcontrolhorario`
  ADD CONSTRAINT `par_tblcontrolhorario_ibfk_1` FOREIGN KEY (`IdRowClientesLin`) REFERENCES `par_tblclienteslin` (`IdRows`),
  ADD CONSTRAINT `par_tblcontrolhorario_ibfk_2` FOREIGN KEY (`IdRowPosicion`) REFERENCES `par_tblposicion` (`IdRows`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
