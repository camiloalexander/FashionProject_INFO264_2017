-- phpMyAdmin SQL Dump
-- version 4.7.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-10-2017 a las 16:23:41
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

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
