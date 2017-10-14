-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-10-2017 a las 22:18:56
-- Versión del servidor: 5.7.19
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_peluqueria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(100) NOT NULL,
  `run` varchar(30) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(150) CHARACTER SET utf8 NOT NULL,
  `edad` int(4) NOT NULL,
  `ciudad` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `telefono` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `correo` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `estado` varchar(5) CHARACTER SET utf8 NOT NULL,
  `fecha_ingreso` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `run`, `nombre`, `edad`, `ciudad`, `telefono`, `correo`, `estado`, `fecha_ingreso`) VALUES
(16, '17.717.167-9', 'Gabolitro', 42, 'Valdivia', '81728361', 'gabo@gmail.com', '1', NULL),
(33, 'run1run', 'nombre1nombre', 15, 'ciudad1ciudad', 'telefono1telefono', 'correo@correo', '0', NULL),
(44, '18273849-9', 'Jose luis Prieto', 23, 'Paillaco', '873837846', '', '1', '2017-09-27'),
(45, '7.123.345-3', 'Carolina Urrutia', 60, 'Los Lagos', '78637467', '', '1', '2017-09-27'),
(46, '16131767-1', 'Marcos Ide', 29, 'La Union', '76657678', 'marcos@gmail.com', '1', '2017-09-27'),
(47, '23656765-2', 'Jorge Koch', 18, 'Valdivia', '+56989876567', 'jorge@alumnos.uach.cl', '1', '2017-09-27'),
(48, '14.562.233-2', 'Maria Pardo', 35, 'Valdivia', '987478398', 'maria@gmail.com', '1', '2017-09-27'),
(49, '17.672.234-k', 'Lucia Marquez', 23, 'Valdivia', '+569878737', 'lucia@gmail.com', '1', '2017-09-27'),
(50, '23456723-5', 'humberto campos', 24, 'Nacimiento', '82912812', 'humbertito@hotmal.com', '1', '2017-09-27'),
(51, '456565671', 'Bartolo', 15, 'Valdivia', '', '', '0', '2017-09-27'),
(60, '4565656711', '234123123', 12, '123123123', '', '', '0', '2017-09-27'),
(61, '16160239-6', 'Valeria Henriquez', 32, 'Valdivia', '', '', '1', '2017-09-29'),
(62, '2232', '123123', 12, '1231231', '', '', '1', '2017-10-01'),
(63, '123233', '123123', 123, '1231213', '', '', '1', '2017-10-01'),
(64, '22', '1234', 123, '123123', '123123123', '', '1', '2017-10-01'),
(66, '18886384-1', 'camilo alarcón ', 23, 'valdivia', '', '', '1', '2017-10-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `id_trabajador` int(5) NOT NULL,
  `run` varchar(15) CHARACTER SET utf8 NOT NULL,
  `nombre` varchar(150) CHARACTER SET utf8 NOT NULL,
  `telefono` varchar(30) CHARACTER SET utf8 NOT NULL,
  `pass` varchar(150) CHARACTER SET utf8 NOT NULL,
  `privilegios` int(5) NOT NULL,
  `estado` int(5) NOT NULL,
  `fecha_ingreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`id_trabajador`, `run`, `nombre`, `telefono`, `pass`, `privilegios`, `estado`, `fecha_ingreso`) VALUES
(1, '188863841', 'camilo alarcón', '123123', '123', 777, 1, '2017-10-06'),
(2, '76057063k', 'pancho', '123', '123456', 111, 1, '2017-10-06'),
(3, '107014667', 'javier', '879123', 'habdkasd', 111, 1, '2017-10-06'),
(4, '141475649', 'nombre', '+5698273832', '.-.-.', 111, 1, '2017-10-06');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`id_trabajador`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `id_trabajador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
