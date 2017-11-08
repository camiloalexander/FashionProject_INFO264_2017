-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-10-2017 a las 16:23:30
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
(16, '177171679', 'Gabolitro', 42, 'Valdivia', '81728361', 'gabo@gmail.com', '1', NULL),
(49, '17672234k', 'Lucia Marquez', 23, 'Valdivia', '+569878737', 'lucia@gmail.com', '1', '2017-09-27'),
(50, '23456723-5', 'humberto campos', 24, 'Nacimiento', '82912812', 'humbertito@hotmal.com', '1', '2017-09-27'),
(61, '16160239-6', 'Valeria Henriquez', 32, 'Valdivia', '', '', '1', '2017-09-29'),
(66, '18886384-1', 'camilo alarcón ', 23, 'valdivia', '', '', '1', '2017-10-05'),
(67, '188878474', 'Jinjirouxs', 22, 'Niebla', '', '', '1', '2017-10-17');

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `id_tratamiento` int(10) NOT NULL,
  `tipo` varchar(200) CHARACTER SET utf8 NOT NULL,
  `precio` int(10) NOT NULL,
  `estado` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`id_tratamiento`, `tipo`, `precio`, `estado`) VALUES
(1, 'Corte mujer', 3000, 1),
(3, 'corte cote', 5000, 1);

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
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`id_tratamiento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `id_trabajador` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id_tratamiento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
