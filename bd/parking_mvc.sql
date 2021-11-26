-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2021 a las 00:53:00
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
-- Base de datos: `parking_mvc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Identificacion` int(10) NOT NULL,
  `NombresCompletos` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroTelefono` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `CorreoElectronico` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(45) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Identificacion`, `NombresCompletos`, `NumeroTelefono`, `CorreoElectronico`, `Direccion`) VALUES
(8975642, 'Julio Botero', '320812333', 'julio158@correo.com', 'Cir 4 22 16'),
(9238475, 'Juan Perez', '3456789', 'juan@gmail.com', 'cr 8 - 9 - 15'),
(9856423, 'Juan Gallego', '302987120', 'juan.gallego@gmail.com', 'Cl 38 88 57'),
(42984722, 'Juan Perez', '9875240', 'juanp23@hotmail.com', 'Av 31 - 98 - 10'),
(78956442, 'Daniel Diaz', '3521879', 'danield12@hotmail.com', 'cr 9 15 37'),
(1054789663, 'Vanessa Montoya', '45687921', 'vane811@gmail.com', 'cr57 56 98'),
(1125487987, 'Sebastian Areiza', '305978456', 'sebasa123@gmail.com', 'cr 50 88 104'),
(1152184023, 'Ana Rendon', '3529184', 'ana.rendon@correo.com', 'Cr 80 #70 19'),
(1152439020, 'Jose Sanchez', '3045405340', 'fore029@gmail.com', 'Calle 9A sur #79 A 125'),
(1189756234, 'JULIAN GAVIRIA', '317895462', 'julian895@cesde.com', 'av 32 56 24');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parqueadero`
--

CREATE TABLE `parqueadero` (
  `Id` int(10) NOT NULL,
  `CuposTotales` int(10) NOT NULL,
  `CuposDisponibles` int(10) NOT NULL,
  `CuposReservados` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `parqueadero`
--

INSERT INTO `parqueadero` (`Id`, `CuposTotales`, `CuposDisponibles`, `CuposReservados`) VALUES
(1, 30, 21, 9);

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
('asd342', 9238475, 1, 'mazda', 'cyan', 'CX-30', 0, '2021-11-26 13:55:28', '2021-11-26 13:58:17'),
('JAR111', 78956442, 1, 'OPEL', 'VINOTINTO', 'ASTRA', 1, '2021-11-26 12:45:55', NULL),
('KAP112', 1054789663, 1, 'VOLVO', 'GRIS', 'S60', 1, '2021-11-26 12:47:58', NULL),
('KIP876', 1152184023, 1, 'Chevrolet', 'Rojo', 'Spark GT', 1, '2021-11-26 03:01:21', NULL),
('NKV378', 1152439020, 1, 'MAZDA', 'AZUL', 'CX-30', 1, '2021-11-26 02:53:50', NULL),
('NQW555', 8975642, 1, 'HYUNDAI', 'PLATA', 'TUCSON', 1, '2021-11-26 12:54:12', NULL),
('PER917', 42984722, 1, 'KIA', 'Negro', 'Picanto', 1, '2021-11-26 03:08:11', NULL),
('PWR487', 1189756234, 1, 'NISSAN', 'BLANCO', 'VERSA', 1, '2021-11-26 12:44:01', NULL),
('QAP187', 9856423, 1, 'SUSUKI', 'VERDE', 'JIMNY LITE', 1, '2021-11-26 12:37:42', NULL),
('TUY213', 1125487987, 1, 'RENAULT', 'AMARILLO', 'SANDERO', 1, '2021-11-26 12:41:56', NULL);

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
